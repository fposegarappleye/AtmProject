import java.util.Scanner;

public class ConsoleUserInterface {
	final String QUIT_STRING = "Q";
	Scanner inDevice = new Scanner(System.in);

	// CONSTRUCTOR*
	public ConsoleUserInterface()
	{
		Scanner inDevice = new Scanner(System.in); // REINITIALIZES SCANNER - IS THIS AN ISSUE?
	}

	// INPUT READS
	// Numbers
	int readNumber()
	{
		String input = inDevice.nextLine();
		int output = 0;
		try
		{
			output = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return 0;
		}
		return output;
	}
	// Strings
	String readString()
	{
		if(inDevice.hasNext())
		{
			String input = inDevice.next();
			return input;
		}
		else
		{
			return null;
		}
	}

	// NOTIFICATIONS
	// Error (does it have enough emphasis?)
	void displayError(String errorMessage)
	{
		System.out.println("ERROR: " + errorMessage);
	}
	// Message
	void displayMessage(String message)
	{
		System.out.println(message);
	}

	// Doesn't utilize 'message' function, should be fine
	// You might want the return card function to end the ATM session with a method call to Atm
	// Boolean "waiting" for while loop is never made false, so there's no out to it - but that should be okay?
	Atm.TransactionType chooseTransactionType()
	{
		System.out.print("Choose transaction type:"
				+ " \n[ 1 ] Check Balance"
				+ " \n[ 2 ] Deposit"
				+ " \n[ 3 ] Withdrawal"
				+ " \n[ " + QUIT_STRING + " ] (Return Card)\n");
		boolean waiting = true;
		while(waiting)
		{
			String input = inDevice.next();
			if(input.equals("1"))
			{
				return Atm.TransactionType.CHECK_BALANCE;
			}
			else if(input.equals("2"))
			{
				return Atm.TransactionType.DEPOSIT;
			}
			else if(input.equals("3"))
			{
				return Atm.TransactionType.WITHDRAWAL;
			}
			else
			if(input.equals(QUIT_STRING))
			{
				returnCard();
				return null;
			}
			else
			{
				displayError(input + " is not a valid input"); // This should work?
			}
		}
		System.out.println("!!!!!!!");
		return null;
	}

	// Digi - Physical or vice versa?
	// COMPLETE**
	void deliverMoney(int amount)
	{
		//Deliver money to cardholder
		// Determine card holder, deliver money
		displayMessage("Retrieved " + amount + " dollars.");
	}

	// Check functional overlap with deliverMoney after breaking some things
	// COMPLETE***
	private int getAmount()
	{
		displayMessage("How much do you want to retrieve? : ");
		int input = 0;
		boolean waiting = true;
		while(waiting)
		{
			input = readNumber();
			if(input >= 0)
			{
				waiting = false;
			}
			else
			{
				displayError("Must input non-negative value");
			}
		}
		displayMessage("Request processed successfully!");
		return input;
	}

	// Uses accounts[i].toString() as a way of displaying account type, def want to clean that up later
	// COMPLETE *
	Account readAccount(Account[] accounts)
	{
		// Lists all the accounts the user has (including types)
		for(int i = 0; i < accounts.length ; i++)
		{
			int iPlusOne = i + 1;
			System.out.println("[ " + iPlusOne + " ] " + accounts[i].toString());
		}
		// Prompt user for input
		displayMessage("Choose an account by entering its corresponding number:");

		boolean waiting = true;
		while(waiting)
		{
			int input = readNumber();
			if(input == 0)
			{
				return null;
			}
			else if(input < 0 || input > accounts.length + 1) // WATCH THIS LINE - IT MIGHT CREATE AN OVERFLOW ERROR
			{
				displayError("You must enter a non-negative number within the range");
				return null;
			}
			else
			{
				waiting = false;
				return accounts[input - 1]; // THIS SHOULD WORK, RIGHT? ONE WAY TO FIND OUT ===================
			}
		}
		return null;
	}

	// COMPLETE ** (TRY TO BREAK THIS)
	String readCard()
	{
		displayMessage("Enter Card ID: "); //or [" + QUIT_STRING + "] to Quit: ");
		String input = readString();
		if(input.equals(QUIT_STRING))
		{
			return "-";
		}
		else
		{
			return input; // Is this what I return?
		}
	}

	// COMPLETE ** (?) (TRY TO BREAK THIS)
	String readPin()
	{
		displayMessage("Enter Card PIN: ");// or [" + QUIT_STRING + "] to Quit: ");
		String input = readString();
		if(input.equals(QUIT_STRING))
		{
			return null;
		}
		else
		{
			return input; // Is this what I return?
		}
	}


	// COMPLETE (?) seems too easy
	int readWithdrawalAmount()
	{
		displayMessage("Withdraw how much? : ");
		return readNumber();
	}

	// COMPLETE
	void returnCard()
	{
		displayMessage("Here's your card back!");
	}

	// COMPLETE
	int takeDepositEnvelope()
	{
		displayMessage("How much is in the envelope? : ");
		int input = readNumber();
		while(input <= 0)
		{
			displayError("Envelope cannot contain negative or 0 money");
			displayMessage("How much is in the envelope? : ");
			input = readNumber();
		}
		return input;
	}

}
