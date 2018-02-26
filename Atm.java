public class Atm {
	private User currentUser;
	private int moneySupply;
	static int sessionNumber = 0;
	ConsoleUserInterface ui = new ConsoleUserInterface(); // WATCH THIS PARTd
	public static enum TransactionType
	{
		CHECK_BALANCE,
		DEPOSIT,
		WITHDRAWAL;
	}
	Atm.TransactionType transaction;

	// CONSTRUCTOR
	public Atm(int moneySupply)
	{
		if(moneySupply >= 0)
		{
			this.moneySupply = moneySupply;
		}
		else
		{
			moneySupply = 0;
		}
	}

	// FINISHED*
	public boolean startSession()
	{
		boolean waiting = true;
		while(waiting)
		{
			//Prompt and Read for Card ID
			String cardId = ui.readCard();
			//System.out.println("cardId " + cardId);
			String cardPin = ui.readPin();
			//System.out.println("cardPin " + cardPin);

			User userRetrieved = User.getUser(cardId, cardPin);
			try
			{
				//System.out.println(userRetrieved.toString());
				if(userRetrieved.getName().equals(""))
				{
					ui.displayError("User not found! Re-enter Card ID and PIN or [" + ui.QUIT_STRING + "] to quit");
				}
				else
				{
					currentUser = userRetrieved;
					waiting = false;
					ui.displayMessage("Retrived User");
				}
			} catch (NullPointerException npe) {
				//currentUser = userRetrieved;
				ui.displayError("User not found! Re-enter Card ID and PIN");
				startSession();
				return false;
			}
		}
		performTransaction();
		return true;
	}

	// REVIEW
	public void endSession()// DO I NEED A TRIGGER FOR THIS?
	{
		currentUser = null;
	}

	// FINISHED*
	public Atm.TransactionType performTransaction()
	{
		Atm.TransactionType input = ui.chooseTransactionType();
		while(true) {
		switch(input)
		{
		case CHECK_BALANCE:
			doCheckBalance();
			break;
		case DEPOSIT:
			doDeposit();
			break;
		case WITHDRAWAL:
			doWithdrawal();
			break;
		}
		return input;
	}
	}

	// FINISHED
	void doCheckBalance()
	{
		//Displays available accounts
		System.out.print("\n");
		ui.readAccount(currentUser.getAccounts());
		ui.displayMessage("You have " + currentUser.getAccounts()[0].getBalance() + " in account 0\n");
		performTransaction();
		ui.chooseTransactionType();
		//Asks user which account to check balance
		/*ui.displayMessage("Check which account now?");

		try{
			ui.readAccount(currentUser.getAccounts()).getBalance();
			//int amount = currentUser.getAccounts.
			ui.displayMessage("You have " + amount + " in the account");
			ui.chooseTransactionType();
		} catch(NullPointerException npe) {
			System.out.println("-");
		}
	}*/
	}

	//FINISHED
	private void doDeposit()
	{
		ui.displayMessage("Which account to deposit to?");
		// Ask which account to retrieve from
		Account inputAccount = ui.readAccount(currentUser.getAccounts()); // THIS MIGHT CREATE AN ISSUE WITH ACCOUNTS CLASS TYPE
		// Get the deposit envelope
		int deposited = ui.takeDepositEnvelope();
		// Make the deposit
		inputAccount.credit(deposited);
		ui.displayMessage("========\nProcessed!\n========");
		// Loop back to main
		ui.chooseTransactionType();
	}

	// FINISHED
	private void doWithdrawal()
	{
		try
		{
			ui.displayMessage("Which account to withdraw from?");
			// Ask which account to retrieve from
			Account inputAccount = ui.readAccount(currentUser.getAccounts()); // THIS MIGHT CREATE AN ISSUE WITH ACCOUNTS CLASS TYPE
			// Ask how much to withdraw
			int withdrawn = ui.readWithdrawalAmount();
			// Make the withdrawal
			inputAccount.debit(withdrawn);
			ui.displayMessage("========\nProcessed!\n========");
		}catch(NullPointerException npe) {
			ui.displayMessage("Not Found");
		}

		// Loop back to main
		ui.chooseTransactionType();

	}
}
