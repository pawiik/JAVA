package pl.edu.pwr.pdabrowski;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class FileEncryptor {
    private static final String ALGORITHM = "RSA"; // Wybrany algorytm szyfrowania

    public void encryptFile(String inputFile, String outputFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException {
        File inputFileObj = new File(inputFile);
        File outputFileObj = new File(outputFile);

        System.out.println(inputFile);
        System.out.println(outputFile);
        System.out.println(key);

        byte[] privateKeyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);


        try (FileInputStream fis = new FileInputStream(inputFileObj);
             FileOutputStream fos = new FileOutputStream(outputFileObj)) {

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            try (CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    cos.write(buffer, 0, bytesRead);
                }

//            int inputBlockSize = cipher.getBlockSize();
//            System.out.println(inputBlockSize);
//            int outputBlockSize = cipher.getOutputSize(inputBlockSize);
//            System.out.println(outputBlockSize);
//
//            byte[] inputBuffer = new byte[inputBlockSize];
//            byte[] outputBuffer = new byte[outputBlockSize];
//
//            int bytesRead;
//
//            while ((bytesRead = fis.read(inputBuffer)) > 0) {
//                try {
//                    byte[] encryptedBytes = cipher.update(inputBuffer, 0, bytesRead);
//                    if (encryptedBytes != null) {
//                        fos.write(encryptedBytes);
//                    }
//                    System.out.println(Arrays.toString(encryptedBytes));
//                } catch (Exception e) {
//                    System.out.println("Encryption Error: " + e.getMessage());
//                    throw new IOException("Encryption Error", e);
//                }
//            }
//
//            byte[] finalEncryptedBytes = cipher.doFinal();  // Zaszyfrowanie ewentualnych pozostałych danych
//            if (finalEncryptedBytes != null) {
//                fos.write(finalEncryptedBytes);
//            }
//
//            fos.flush();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void encryptFileAES(String inputFile, String outputFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException {
        File inputFileObj = new File(inputFile);
        File outputFileObj = new File(outputFile);

        byte[] privateKeyBytes = key.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        privateKeyBytes = sha.digest(privateKeyBytes);
        privateKeyBytes = Arrays.copyOf(privateKeyBytes, 16);
        SecretKeySpec keySpec = new SecretKeySpec(privateKeyBytes, "AES");

        try (FileInputStream fis = new FileInputStream(inputFileObj);
             FileOutputStream fos = new FileOutputStream(outputFileObj)) {

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            try (CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    cos.write(buffer, 0, bytesRead);
                }

            }
        }

    }
}
