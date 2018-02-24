public class Account {
	String accountID;
	int balance;
	String name;
	String type;
	static int idCount = 0; //Initialize static variables at the top

	// CONSTRUCTOR 1: Specifies balance/amount
	public Account(String type, String name, int amount) {
		this.type = type;
		this.name = name;
		this.balance = amount;
	}
	// CONSTRUCTOR 2: Defaults balance to 0
	public Account(String type, String name) {
		this.type = type;
		this.name = name;
		this.balance = 0;
	}

	// STILL NEED TO ADD SELF-TESTER

	// COMPLETE
	void credit(int amount)
	{
		this.balance += amount;
	}

	// COMPLETE
	boolean debit(int amount)
	{
		if(amount > balance)
		{
			return false;
		}
		else
		{
			balance -= amount;
			return true;
		}
	}

	// COMPLETE, BUT JAVADOC SEEMS MISWRITTEN FOR A BOOLEAN TYPE
	int getBalance()
	{
		return balance;
	}

	// COMPLETE
	@Override
	public String toString()
	{
		return "Account[ accountID: " + accountID
				+ " | balance: " + balance
				+ " | name: " + name
				+ " | type: " + type + " ]";
	}
}
