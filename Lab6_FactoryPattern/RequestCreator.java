package Lab6_FactoryPattern;

public abstract class RequestCreator {
    public abstract RequestProduct createRequest();

    public void processRequest() {
        RequestProduct product = createRequest();
        product.setPriority();
        product.setExpire();
        product.setStatus();
        product.processRequest();
    }
}
