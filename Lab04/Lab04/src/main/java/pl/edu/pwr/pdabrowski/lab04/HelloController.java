package pl.edu.pwr.pdabrowski.lab04;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class HelloController implements Initializable {
    public Button setDirectoryButton;
    public ListView filesList;
    public Button goBackButton;
    public ListView loadedClassesList;
    public Button loadClassButton;
    public Button setJobButton;
    public Button abandonJobButton;
    public Button unloadClassButton;
    public ListView jobStatusList;
    public TextField directoryField;

    private ExploreFiles exploreFiles;
    private MyClassLoader myClassLoader;
    private HashMap<String, Object> classMap;
    private HashMap<String, String> tasks;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.exploreFiles = new ExploreFiles();
        this.classMap = new HashMap<>();
        this.tasks = new HashMap<>();
        try {
            refreshFileList();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public void refreshFileList() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.jobStatusList.getItems().clear();
        this.filesList.getItems().clear();
        this.loadedClassesList.getItems().clear();
        this.exploreFiles.updateFileList();
        this.filesList.getItems().addAll(this.exploreFiles.getFileList());
        for (Map.Entry<String, Object> entry : classMap.entrySet()) {
            String key = entry.getKey();
            Object object = entry.getValue();
             Method method = object.getClass().getDeclaredMethod("getInfo");
            this.loadedClassesList.getItems().add(key + "   " +  (String)method.invoke(object));
        }
        for (Map.Entry<String, String> entry : tasks.entrySet()) {
            String key = entry.getKey();
            this.jobStatusList.getItems().add(key + " " +  entry.getValue());
        }

    }
    public void fileClicked(MouseEvent event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String selectedItem = (String) this.filesList.getSelectionModel().getSelectedItem();
        if (new File(selectedItem).isDirectory()){
            this.exploreFiles.changeDirectory(selectedItem);
            refreshFileList();
        }
    }

    public void setDirectoryButtonClicked(MouseEvent event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.exploreFiles.changeDirectory(this.directoryField.getText());
        refreshFileList();
    }

    public void goBackButtonClicked(MouseEvent event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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

    public void loadedClassesClicked(MouseEvent event) {
    }

    public void loadClassButtonClicked(MouseEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        String selectedClass = (String) this.filesList.getSelectionModel().getSelectedItem();
        String path = this.exploreFiles.getCurrentDir() + "\\" + selectedClass;
        MyClassLoader myClassLoader = new MyClassLoader(new File(this.exploreFiles.getCurrentDir()).getParent());
        String [] tab = selectedClass.split("\\.");
        System.out.println(tab[0]);
        Class<?> myClass = myClassLoader.loadClass("example."+tab[0]);
        Object myObject = myClass.newInstance();
        this.classMap.put(tab[0], myObject);
        refreshFileList();
    }

    public void setJobButtonClicked(MouseEvent event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String selectedClass = (String) this.loadedClassesList.getSelectionModel().getSelectedItem();
        String [] tab = selectedClass.split(" ");
        Object object = classMap.get(tab[0]);
        System.out.println(object.getClass());
        Method submitTask = object.getClass().getMethod("submitTask", new Class[]{String.class, StatusListener.class});

        String task = "Tekst na wejscie";
        boolean b = (boolean) submitTask.invoke(object, task, new MyStatusListener());

        Method getResultMethod = object.getClass().getDeclaredMethod("getResult");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            String result = null;
            while (true) {

                try {
                    Thread.sleep(800);

                    // String result = (String) getResultMethod.invoke(o,new Object[] {});
                    result = (String) getResultMethod.invoke(object);
                } catch (InterruptedException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (result != null) {
                    this.tasks.put(task, result);
                    executor.shutdown();
                    break;
                }
            }
        });
    }

    public void abandonButtonClicked(MouseEvent event) {
    }


    public void unloadButtonClicked(MouseEvent event) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String selectedClass = (String) this.loadedClassesList.getSelectionModel().getSelectedItem();
        Object o =  this.classMap.get(selectedClass);
        o = null;
        this.classMap.remove(selectedClass);
        System.gc();
        refreshFileList();
    }
}