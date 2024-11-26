package documentation;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import builderPattern.*;

public class Clients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contractID = sc.nextLine();
        double rentAmount = sc.nextDouble();
        sc.nextLine();
        String tenantID = sc.nextLine();
        String propertyID = sc.nextLine();
        final ContractBuilder contract = new ShortTerm().setContractID(contractID).setPropertyID(propertyID)
                .setRentAmount(rentAmount).setTenantID(tenantID);
        // Contract shortTerm = contract.build();

        DocumentBuilder normalDoc = new NormalDoc().setExtension().setEncryption();
        normalDoc.save(contract.toString());

        String zipFileName = "example.zip";
        String entryName = "file.txt";

    }

    static void saveNormalFile(String contract) {

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(contract);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void SaveConfidentialDocument(ContractBuilder contract, String zipFileName, String entryName) {
        try {
            SecretKey key = generateKey();
            String message = contract.toString();
            byte[] encryptedMessage = encrypt(message, key);

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
