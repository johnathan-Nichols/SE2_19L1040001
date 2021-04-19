package model;

public class Account {
	private String owner;
	private String accountType;
	private int accountID;
	private double accountBalance;

	public Account() {}

	public Account(String owner, String accountType, double accountBalance, int accountID) {
		super();
		this.owner = owner;
		this.accountType = convertAccount(accountType);
		this.accountBalance = accountBalance;
		this.accountID = accountID;
	}

	public String convertAccount(String accountType) {
		accountType = accountType.toLowerCase();
		switch(accountType) {
		case "checkingaccount":
			return "checking";
		case "savingsaccount":
			return "savings";
		case "loanaccount":
			return "loan";
		}
		
		System.out.println("The accountType " + accountType + " cannot be converted!");
		return null;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = convertAccount(accountType);
	}

	/**
	 * @return the accountBalance
	 */
	public double getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * @return the accountID
	 */
	public int getAccountID() {
		return accountID;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
}
