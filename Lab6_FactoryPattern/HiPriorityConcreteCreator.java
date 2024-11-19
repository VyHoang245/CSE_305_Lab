package Lab6_FactoryPattern;

public class HiPriorityConcreteCreator extends RequestCreator {
    @Override
    public RequestProduct createRequest() {
        return new HighPriorityConcrete();
    }
}