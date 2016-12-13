package group2.lesson3.prog3_1_account;

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
