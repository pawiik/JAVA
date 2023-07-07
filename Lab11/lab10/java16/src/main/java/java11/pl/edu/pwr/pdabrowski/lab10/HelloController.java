package java11.pl.edu.pwr.pdabrowski.lab10;

//
//
//
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

import pl.edu.pwr.pdabrowski.lab10.fileHandling.ExploreFiles;
import pl.edu.pwr.pdabrowski.lab10.idk.KeyManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import pl.edu.pwr.pdabrowski.FileDecryptor;
import pl.edu.pwr.pdabrowski.FileEncryptor;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class HelloController implements Initializable {
    public RadioButton RSA;
    public static final RadioButton DSA = new RadioButton();
    public RadioButton AES;
    private final ExploreFiles exploreFiles;
    public ListView filesList;
    public TextField NameField;
    public TextField nameField;
    public Button encryptButton;
    public Button decryptButton;
    public Button goBackButton;
    public Button generateKeysButton;
    public TextField userKey;
    public TextArea privateKeyField;
    public TextArea publicKeyField;
    public ToggleGroup alg;


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

        String selectedItem = this.filesList.getSelectionModel().getSelectedItem().toString();
//        selectedItem.contains(".csv")
        if (!(new File(selectedItem)).isDirectory()){
            selectedItem = exploreFiles.getCurrentDir() + "\\" + selectedItem;
        }
        else {
            this.exploreFiles.changeDirectory(selectedItem);
            refreshFileList();
        }
    }

    public void goBackButtonClicked(MouseEvent event) throws IOException {
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

    public void decryptButtonClicked(MouseEvent click) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException {
        String key = userKey.getText();
        String fileToEncrypt = exploreFiles.getCurrentDir() + "\\"  + this.filesList.getSelectionModel().getSelectedItem().toString();
        String nameAfterEncryption = exploreFiles.getCurrentDir() + "\\" + this.nameField.getText();
        FileDecryptor decryptor = new FileDecryptor();
        if (RSA.isSelected()){
            decryptor.decryptFile(fileToEncrypt, nameAfterEncryption, key);
            System.out.println("Success");
        }
        else if (AES.isSelected())
        {
            decryptor.decryptFileAES(fileToEncrypt, nameAfterEncryption, key);
            System.out.println("Success");
        }
    }
    public void encryptButtonClicked(MouseEvent click) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException {
        String key = userKey.getText();
        String fileToEncrypt = exploreFiles.getCurrentDir() + "\\" + this.filesList.getSelectionModel().getSelectedItem().toString();
        String nameAfterEncryption =  exploreFiles.getCurrentDir() + "\\" + this.nameField.getText();
        FileEncryptor encryptor = new FileEncryptor();
        if (RSA.isSelected()){
            encryptor.encryptFile(fileToEncrypt, nameAfterEncryption, key);
            System.out.println("Success");
        }
     else if (AES.isSelected())
    {
        encryptor.encryptFileAES(fileToEncrypt, nameAfterEncryption, key);
        System.out.println("Success");
    }


    }
    public void generateKeysButtonClicked(MouseEvent click) throws NoSuchAlgorithmException {
        System.out.println("generate");
        if (RSA.isSelected()){
            System.out.println("RSA");
            KeyManager keyManager = new KeyManager();
            KeyPair keyPair = keyManager.generateKeyPair();
            Key privateKey = keyPair.getPrivate();
            Key publicKey = keyPair.getPublic();
            this.privateKeyField.setText(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
            this.publicKeyField.setText(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

        } else if (AES.isSelected()) {
            System.out.println("AES");
            KeyManager keyManager = new KeyManager();
            SecretKey secretKey = keyManager.generateSecret();
            StringBuilder res = new StringBuilder();
            for (byte b : secretKey.getEncoded()){
                res.append(String.format("%02x", b));
            }
            this.privateKeyField.setText(String.valueOf(res));
        }
//        System.out.println("RSA");
//        KeyManager keyManager = new KeyManager();
//        KeyPair keyPair = keyManager.generateKeyPair();
//        Key privateKey = keyPair.getPrivate();
//        Key publicKey = keyPair.getPublic();
//        this.privateKeyField.setText(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
//        this.publicKeyField.setText(Base64.getEncoder().encodeToString(publicKey.getEncoded()));



//        this.privateKeyField.setText(Base64.getEncoder().encodeToString(privateKey.getEncoded()));

//        this.publicKeyField.setText(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

    }

}