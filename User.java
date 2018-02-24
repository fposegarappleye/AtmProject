import java.util.ArrayList;

public class User {
	// CHECK NOTEBOOK!
	private String id;
	private String name;
	private String pin;
	private Account[] accounts;
	//static ArrayList<User> users = new ArrayList<User>();
	/**Account[] a = new Account
			{
				new Account();
			}
			**/

	// Creates a new user

	public User(String name, String id, String pin, Account[] accounts)
	{
		this.name = name;
		this.id = id;
		this.pin = pin;
		this.accounts = accounts;
	}

	public Account[] getAccounts()
	{
		return accounts;
	}

	public String getName()
	{
		return name;
	}

	public User getUser(String id, String pin)
	{
		if(id == id && pin == pin) //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<<<<<<
		{
			return User;
		}
		else
		{
			return null;
		}
	}
}
