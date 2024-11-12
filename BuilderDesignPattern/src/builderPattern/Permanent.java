package builderPattern;

public class Permanent implements ContractBuilder{
	private String contractID; 
	private String propertyID; 
	private String tenantID; 
	private double rentAmount;

	@Override
	public ContractBuilder setContractID(String contractID) {
		this.contractID = contractID;
        return this;
	}

	@Override
	public ContractBuilder setPropertyID(String propertyID) {
		this.propertyID = propertyID;
        return this;
	}

	@Override
	public ContractBuilder setTenantID(String tenantID) {
		this.tenantID = tenantID;
        return this;
	}

	@Override
	public ContractBuilder setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
        return this;
	}

	@Override
	public Contract build() {
		return new Contract(contractID,propertyID,tenantID,rentAmount);
	}
	
}

