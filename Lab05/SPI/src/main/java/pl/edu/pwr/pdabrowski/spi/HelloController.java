package pl.edu.pwr.pdabrowski.spi;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import pl.edu.pwr.pdabrowski.api.AnalysisException;
import pl.edu.pwr.pdabrowski.api.DataSet;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    public TextField filePathField;
    public TableView dataTable;
    public Button dataPathButton;
    public ListView resultDataList;
    public RadioButton kappaRadioButton;
    public ToggleGroup factorGroup;
    public Button calculateButton;
    private DataReader dataReader;
    private Label welcomeText;
    private DataSet dataSet;
    private Analyser service;

    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dataSet = new DataSet();
        this.dataReader = new DataReader();
        this.service = new Analyser();
    }

    public void refresh(){
        this.dataTable.getColumns().clear();
        for (int i = 0; i < this.dataSet.getData()[0].length; i++) {
            final int colIndex = i;
            TableColumn<String[], String> column = new TableColumn<>(this.dataSet.getData()[0][i]);
            column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[colIndex]));
            this.dataTable.getColumns().add(column);
        }

        // add columns to table
        this.dataTable.getItems().clear();
        ObservableList<String[]> data = FXCollections.observableArrayList();

        for (String[] row : this.dataSet.getData()) {
            data.add(row);
        }

        this.dataTable.setItems(data);
    }


    public void setDataPathButtonClicked(MouseEvent event) throws FileNotFoundException {
        this.dataSet.setHeader(this.dataReader.readHeader("C:\\Users\\pawel\\Desktop\\CSV_Data_2023_4_19 18_23.csv"));
        this.dataSet.setData(this.dataReader.readFile("C:\\Users\\pawel\\Desktop\\CSV_Data_2023_4_19 18_23.csv"));
        refresh();
    }

    public void calculateButtonClicked(MouseEvent event) throws AnalysisException {
        this.service.submit(this.dataSet);
        this.resultDataList.getItems().add(this.service.CalculateKappa());
    }
}
