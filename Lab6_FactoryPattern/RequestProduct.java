package Lab6_FactoryPattern;

public interface RequestProduct {
    void setPriority();

    void setExpire();

    void setStatus();

    void processRequest();
}
