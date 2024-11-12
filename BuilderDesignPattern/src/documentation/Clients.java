package documentation;

import java.util.Scanner;

import builderPattern.*;
import builderPattern.ShortTerm;

public class Clients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contractID = sc.nextLine();
        int rentAmount = sc.nextInt();
        sc.nextLine();
        String tenantID = sc.nextLine();
        String propertyID = sc.nextLine();
        ContractBuilder contract = new ShortTerm(contractID, propertyID, tenantID, rentAmount);
        ContractBuilder longContract = new Longterm(contractID, propertyID, tenantID, rentAmount);
        System.out.println(contract);
        System.out.println(longContract);
    }
}
