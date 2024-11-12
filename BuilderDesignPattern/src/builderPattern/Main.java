package builderPattern;

public class Main {

        public static void main(String[] args) {
                ContractBuilder contractBuilder = new Longterm()
                                .setContractID("C1")
                                .setPropertyID("P100");

                System.out.println(contractBuilder.build());

        }
}
