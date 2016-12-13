package group2.lesson7.prog7_3.employeeinfo;

public enum AccountType 
{
	CHECKING("checking"), SAVINGS("savings"), RETIREMENT("retirement");
	
	private String acctType;
	private AccountType(String acctType)
	{
		this.acctType = acctType;
	}
	
    @Override
    public String toString()
    {
        return this.acctType;
    }
}
