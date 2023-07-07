package pl.edu.pwr.pdabrowski.lab10.idk;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class KeyManager {
    private static final String KEYSTORE_PATH = System.getProperty("java.home") + "/lib/security/cacerts";
    private static final String KEYSTORE_PASSWORD = "changeit";
    private static final String ALIAS = "myalias";
    private static final String KEY_PASSWORD = "keypassword";
    private static final String KEY_ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;

    public KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            FileInputStream fis = new FileInputStream(KEYSTORE_PATH);
//            keyStore.load(fis, KEYSTORE_PASSWORD.toCharArray());
//            fis.close();

//            keyStore.setKeyEntry(ALIAS, keyPair.getPrivate(), KEY_PASSWORD.toCharArray(), new java.security.cert.Certificate[]{});

//            FileOutputStream fos = new FileOutputStream(KEYSTORE_PATH);
//            keyStore.store(fos, KEYSTORE_PASSWORD.toCharArray());
//            fos.close();

            System.out.println("Key pair generated and saved in cacerts keystore.");
            return keyPair;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error generating key pair: " + e.getMessage());
        }
        return null;
    }

    public PrivateKey loadPrivateKey() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream fis = new FileInputStream(KEYSTORE_PATH);
            keyStore.load(fis, KEYSTORE_PASSWORD.toCharArray());
            fis.close();

            return (PrivateKey) keyStore.getKey(ALIAS, KEY_PASSWORD.toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException |
                 UnrecoverableKeyException e) {
            System.err.println("Error loading private key: " + e.getMessage());
        }
        return null;
    }
    public SecretKey generateSecret() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }
}
