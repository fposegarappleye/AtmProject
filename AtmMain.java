public class AtmMain {

	public static void main(String[] args) {
		// Initialize the ATM with 100 monetary units
		Atm myAtm = new Atm(100);

		Account[] accA = new Account[]
				{
					new Account("savings", "John's Savings", 0),
					new Account("type", "name", 10)
				};
		User A = new User("Name","id001","1234", accA);
		User.users.add(A);

		Account[] accB = new Account[]
				{
					new Account("savings", "John's Savings", 0),
					new Account("type", "name", 10)
				};
		User B = new User("User2","id002","1111", accB);
		User.users.add(B);

		Account[] accC = new Account[]
				{
					new Account("savings", "John's Savings", 0),
					new Account("type", "name", 10)
				};
		User C = new User("John","id003","1999", accC);
		User.users.add(C);

		// At least 3 different users each with 1 to 3 of their own accounts

		myAtm.startSession();

	}
}
