package pl.edu.pwr.pdabrowski.lab06;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import pl.edu.pwr.pdabrowski.lab06.entities.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Tab clientTab;
    public ListView clientsListView;
    public Button clientRemoveButton;
    public TextField clientNameField;
    public TextField clientLastNameField;
    public TextField clientNumberField;
    public Button clientModifyButton;
    public Button clientSubmitButton;
    public Tab instalationTab;
    public Tab priceListTab;
    public Tab paymentTab;
    public Tab paidPaymentsTab;
    public ListView instalationsListView;
    public Button modifyInstalationButton;
    public Button removeInstalationButton;
    public ListView pricesListView;
    public ListView donePaymentsListView;
    public ListView paymentsListView;
    public AnchorPane instalationSubmitButton;
    public TextField routerNumberField;
    public TextField routerAdressField;
    public TextField serviceTypeField;
    public TextField clientNumberInstalationField;


    private HibernateUtil hibernateUtil;
    private List<Klient> clients;
    private List<Cennik> priceList;
    private List<DokonanieWplaty> donePayments;
    private List<Instalacja> instalations;
    private List<NaliczenieNaleznosci> payments;

    public void refresh() {

        if(clientTab.isSelected()){
            this.clientsListView.getItems().clear();
            this.clients = this.hibernateUtil.listClients();
            this.clientsListView.getItems().addAll(this.clients);

        } else if (instalationTab.isSelected()) {
            this.instalationsListView.getItems().clear();
            this.instalations = this.hibernateUtil.listInstalations();
            this.clientsListView.getItems().addAll(this.clients);

        } else if (priceListTab.isSelected()) {
            this.pricesListView.getItems().clear();
            this.priceList = this.hibernateUtil.listPrices();
            this.clientsListView.getItems().addAll(this.clients);

        } else if (paymentTab.isSelected()) {
            this.paymentsListView.getItems().clear();
            this.payments = this.hibernateUtil.listPayments();
            this.clientsListView.getItems().addAll(this.clients);

        } else if (paidPaymentsTab.isSelected()) {
            this.donePaymentsListView.getItems().clear();
            this.donePayments = this.hibernateUtil.listDonePayments();
            this.clientsListView.getItems().addAll(this.clients);
        }
    }

    public void clientRemoveButtonClicked(MouseEvent mouseEvent) {
        int num = this.clientsListView.getSelectionModel().getSelectedIndex();
        Long id = this.clients.get(num).getNumerKlienta();
        this.hibernateUtil.deleteClient(id);
        refresh();
    }

    public void clientModifyButtonClicked(MouseEvent mouseEvent) throws Exception {
        int num = this.clientsListView.getSelectionModel().getSelectedIndex();
        this.clientNameField.setText(this.clients.get(num).getImie());
        this.clientLastNameField.setText(this.clients.get(num).getNazwisko());
        this.clientNumberField.setText(this.clients.get(num).getNumerKlienta().toString());

    }

    public void clientSubminButtonClicked(MouseEvent mouseEvent) throws Exception {

        if (this.clientNumberField.getText().equals("")){
            this.hibernateUtil.saveClient(this.clientNameField.getText(), this.clientLastNameField.getText());
        }
        else {
            this.hibernateUtil.modifyClient(this.clientNameField.getText(),
                                            this.clientLastNameField.getText(),
                                            Long.parseLong(this.clientNumberField.getText()));
            this.clientNumberField.clear();
            this.clientNameField.clear();
            this.clientLastNameField.clear();
        }
        refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.hibernateUtil = new HibernateUtil();
        try {
            this.hibernateUtil.setUp();
            refresh();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveInstallationButtonClicked(MouseEvent mouseEvent) throws Exception {
        Long clientId = Long.parseLong(this.clientNumberInstalationField.getText());
        Klient client = new Klient();
        for (Klient c : this.clients) {
            if (c.getNumerKlienta() == clientId){
                client = c;
            }
        }
        String address = this.routerAdressField.getText();
        String type = this.serviceTypeField.getText();

        this.hibernateUtil.saveInstalation(address, type, client);
        refresh();
    }
}