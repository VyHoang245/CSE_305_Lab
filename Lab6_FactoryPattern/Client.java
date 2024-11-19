package Lab6_FactoryPattern;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        RequestCreator lowCreator = new LowPriorityConcreteCreator();
        lowCreator.processRequest();
    }
}
