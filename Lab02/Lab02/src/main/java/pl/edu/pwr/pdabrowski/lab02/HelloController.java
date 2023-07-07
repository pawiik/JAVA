package pl.edu.pwr.pdabrowski.lab02;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class HelloController implements Initializable {
    @FXML
    public ListView<String> filesList;
    @FXML
    public ListView<String> fileContainsList = new ListView<>();
    @FXML
    public ListView<String> calculatedDataList = new ListView<>();
    public TextField memoryInfo;
    public Button goBackButton;
    public RadioButton csv;
    public RadioButton txt;
    public RadioButton defAlg;
    public RadioButton algOne;
    public RadioButton algTwo;
    public ToggleGroup file;
    public RadioButton five;
    public ToggleGroup lines;
    public RadioButton ten;
    public RadioButton fifty;
    public RadioButton oHundret;
    public RadioButton fHundret;
    public RadioButton thousand;
    public ToggleGroup alg;
    public RadioButton xml;
    @FXML
    private Label welcomeText;
    private final ExploreFiles exploreFiles;
    private WeakHashMap<String, List<Measure>> measures = new WeakHashMap<>();




    public HelloController() throws IOException {
        this.exploreFiles = new ExploreFiles();
        this.exploreFiles.updateFileList();
    }
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {

            refreshFileList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void refreshFileList() throws IOException {
        this.filesList.getItems().clear();
        this.exploreFiles.updateFileList();
        this.filesList.getItems().addAll(this.exploreFiles.getFileList());
    }

    public void fileClicked(MouseEvent click) throws IOException {

//        System.out.println(s);

        String selectedItem = this.filesList.getSelectionModel().getSelectedItem();
//        selectedItem.contains(".csv")
        if (!(new File(selectedItem)).isDirectory()){
            selectedItem = exploreFiles.getCurrentDir() + "\\" + selectedItem;
            this.fileContainsList.getItems().clear();
            if (selectedItem.contains(getExtension())){
                if (this.measures.containsKey(selectedItem)){
                    List<Measure> measureList = this.measures.get(selectedItem);
                    int i = 0;
                    for (Measure m : measureList) {
                        if(i == getLines())
                            break;
                        this.fileContainsList.getItems().add(m.toString());
                        i++;
                    }
                    showAverageData(measureList);
                    this.memoryInfo.setText("Load from cache");
                }
                else{
                    FileHandler fileHandler = new FileHandler();
                    List<Measure> daat = fileHandler.parseData(fileHandler.readFile(selectedItem));
                    this.measures.put(selectedItem, daat);

                    int i = 0;
                    for (Measure m : daat) {
                        if(i == getLines())
                            break;
                        this.fileContainsList.getItems().add(m.toString());
                        i++;
                    }
                    showAverageData(daat);
                    this.memoryInfo.setText("Load from memory");
                }

                }
            else{
                this.fileContainsList.getItems().clear();
                this.fileContainsList.getItems().add("You chose wrong file extension");
            }
             }
        else {
            this.exploreFiles.changeDirectory(selectedItem);
            refreshFileList();
        }
    }

    public void goBack(MouseEvent event) throws IOException {
        String dir = this.exploreFiles.getCurrentDir();
        String[] d = dir.split(Pattern.quote("\\"));
        int i = d.length;
        d[i-1] = "";
        String newDirectory = "";
        for (String s : d) {
           newDirectory += "\\" + s;
        }
        this.exploreFiles.changeDirectory(newDirectory);
        refreshFileList();
    }

    public void showAverageData(List<Measure> data){
        this.calculatedDataList.getItems().clear();
        List<String> map = DataAnalizer.calculate(data);
        this.calculatedDataList.getItems().addAll(map);
    }
    public int getLines(){
        if (five.isSelected())
            return 5;
        else if (ten.isSelected())
            return 10;
        else if (oHundret.isSelected())
            return 100;
        else if (fifty.isSelected())
            return 50;
        else if (fHundret.isSelected())
            return 500;
        else
            return Integer.MAX_VALUE;
    }


    public String getExtension(){
        if (csv.isSelected())
            return ".csv";
        if(txt.isSelected())
            return ".txt";
        else
            return ".xml";
    }
}