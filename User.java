import java.util.ArrayList;

public class User {
	private Account[] accounts;
	private String id;
	private String name;
	private String pin;
	static ArrayList<User> users = new ArrayList<User>();


	// CONSTRUCTOR
	public User(String name, String id, String pin, Account[] accounts)
	{
		this.name = name;
		this.id = id;
		this.pin = pin;
		this.accounts = accounts;
	}

	// COMPLETE
	public Account[] getAccounts()
	{
		return accounts;
	}

	// COMPLETE
	String getName()
	{
		return name;
	}

	// COMPLETE
	public static User getUser(String id, String pin)
	{
		int userIndex = 0;
		for(int i = 0; i < users.size() ; i++)
		{
			User input = users.get(i);
			if(input.id.equals(id) && input.pin.equals(pin))
			{
				return users.get(i);
			}
		}
		return null;
	}
}
