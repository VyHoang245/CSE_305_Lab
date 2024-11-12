package builderPattern;

public interface ContractBuilder {
	ContractBuilder setContractID(String contractID);

	ContractBuilder setPropertyID(String propertyID);

	ContractBuilder setTenantID(String tenantID);

	ContractBuilder setRentAmount(Double rentAmount);

	Contract build();
}
