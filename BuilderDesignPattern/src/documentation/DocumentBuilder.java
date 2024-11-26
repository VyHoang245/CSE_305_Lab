package documentation;

public interface DocumentBuilder {

    DocumentBuilder setExtension();

    DocumentBuilder setEncryption();

    void save(String string);

    Document buildDoc();
}
