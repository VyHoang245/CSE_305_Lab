package documentation;

import javax.crypto.*;
import java.util.*;

public class RentalManagement_Application {
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cryptoBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(cryptoBytes);
    }

    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            SecretKey key = generateKey();
            String message = "Hello my word!!!";
            String encryptedMessage = encrypt(message, key);
            System.out.println("Encrypted String: " + encryptedMessage);

            String decryptedMessage = decrypt(encryptedMessage, key);
            System.out.println("Decrypted String: " + decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
