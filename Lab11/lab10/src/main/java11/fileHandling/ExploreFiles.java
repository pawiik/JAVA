package pl.edu.pwr.pdabrowski.lab10.fileHandling;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ExploreFiles {
    private String currentDir;
    private List<String> fileList;

    public ExploreFiles(){
        this.currentDir = "C:\\Users\\pawel\\Desktop";
        updateFileList();
    }

    public String getCurrentDir() {
        return currentDir;
    }

    public List<String> getFileList(){
        return this.fileList;
    }

    public void changeDirectory(String path){
        this.currentDir = path;
        updateFileList();
    }

    public void updateFileList(){
        List<String> filesIn = new ArrayList<>();
        File dir = new File(this.currentDir);
        try {
            File[] files = dir.listFiles();

            for(File file : files){
                if(file.isDirectory()){
                    filesIn.add(file.getAbsolutePath());
                }
                else{
                    filesIn.add(file.getName());
                }
            }
            this.fileList = filesIn;
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

}
