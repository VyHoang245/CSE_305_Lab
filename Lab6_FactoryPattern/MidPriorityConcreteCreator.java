package Lab6_FactoryPattern;

public class MidPriorityConcreteCreator extends RequestCreator {
    @Override
    public RequestProduct createRequest() {
        return new MidPriorityConcrete();
    }
}
