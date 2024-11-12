package builderPattern;

public class Contract {
	private String contractID; 
	private String propertyID; 
	private String tenantID; 
	private double rentAmount;
	
	public Contract(String contractID, String propertyID, String tenantID, double rentAmount) {
		super();
		this.contractID = contractID;
		this.propertyID = propertyID;
		this.tenantID = tenantID;
		this.rentAmount = rentAmount;
	}
	
}