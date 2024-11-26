package documentation;

import java.io.FileWriter;
import java.io.IOException;

public class NormalDoc implements DocumentBuilder {
    private String extension;
    private boolean encryption;

    @Override
    public DocumentBuilder setExtension() {
        this.extension = ".txt";
        return this;
    }

    @Override
    public DocumentBuilder setEncryption() {
        this.encryption = false;
        return this;
    }

    @Override
    public Document buildDoc() {
        return new Document(extension, encryption);

    }

    public void save(String contract) {

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

    // @Override
    // public void setExtension() {
    // this.extension = ".txt";
    // }

    // @Override
    // public void setEncryption() {
    // this.encryption = false;
    // }

    // @Override
    // public Document buildDoc() {
    // // Logic to create and save normal document
    // return this;
    // }
}
