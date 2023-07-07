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
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class FileDecryptor {
    private static final String ALGORITHM = "RSA"; // Wybrany algorytm szyfrowania

    public void decryptFile(String inputFile, String outputFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException {
        File inputFileObj = new File(inputFile);
        File outputFileObj = new File(outputFile);

        byte[] publicKeyBytes = Base64.getDecoder().decode(key);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        try (FileInputStream fis = new FileInputStream(inputFileObj);
             FileOutputStream fos = new FileOutputStream(outputFileObj)) {


            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);

            try (CipherInputStream cis = new CipherInputStream(fis, cipher)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = cis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
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
//                outputBuffer = cipher.update(inputBuffer, 0, bytesRead);
//                if (outputBuffer != null) {
//                    fos.write(outputBuffer);
//                }
//            }
//
//            outputBuffer = cipher.doFinal();
//            if (outputBuffer != null) {
//                fos.write(outputBuffer);
//            }

            } catch (Exception e) {
                System.out.println("File Handling Error: " + e.getMessage());
                throw new IOException("File Handling Error", e);
            }

        }
    }
    public void decryptFileAES(String inputFile, String outputFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException {
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
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

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

