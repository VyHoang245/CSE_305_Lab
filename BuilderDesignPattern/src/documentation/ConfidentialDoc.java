package documentation;

import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class ConfidentialDoc implements DocumentBuilder {
    private String extension;
    private boolean encryption;

    @Override
    public DocumentBuilder setExtension() {
        this.extension = ".zip";
        return this;
    }

    @Override
    public DocumentBuilder setEncryption() {
        this.encryption = true;
        return this;
    }

    @Override
    public Document buildDoc() {
        return new Document(extension, encryption);

    }

    @Override
    public void save(String contract) {
        try {
            SecretKey key = generateKey();
            String message = contract;
            byte[] encryptedMessage = encrypt(message, key);
            String zipFileName = "example.zip";
            String entryName = "file.txt";

            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            ZipEntry zipEntry = new ZipEntry(entryName);
            zipOut.putNextEntry(zipEntry);
            zipOut.write(encryptedMessage);
            zipOut.closeEntry();
            zipOut.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

    public static byte[] encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cryptoBytes = cipher.doFinal(plainText.getBytes());
        // return Base64.getEncoder().encodeToString(cryptoBytes);
        return cryptoBytes;
    }
}
