package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckingAccount {
	public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	protected int id;
	protected Customer customer;
	protected Calendar creationDate;
	protected double accountBalance;
	protected boolean canTransfer;
	protected boolean validAccount;
	protected boolean activatedAccount;
	
	public CheckingAccount() {}
	
	public CheckingAccount(double accountBalance) {
		this.accountBalance = accountBalance;
		this.validAccount = false;
		this.activatedAccount = false; 
	}
	
	public CheckingAccount(Customer customer, Date creationDate, double accountBalance, boolean validAccount, boolean activatedAccount) {
		super();
		this.customer = customer;
		this.creationDate = Calendar.getInstance();
		this.creationDate.setTime(creationDate);
		this.accountBalance = accountBalance;
		this.validAccount = validAccount;
		this.activatedAccount = activatedAccount;
	}
	
	public CheckingAccount(int id, Customer customer, Date creationDate, double accountBalance, boolean canTransfer, boolean validAccount, boolean activatedAccount) {
		super();
		this.id = id;
		this.customer = customer;
		this.creationDate = Calendar.getInstance();
		this.creationDate.setTime(creationDate);
		this.accountBalance = accountBalance;
		this.canTransfer = canTransfer;
		this.validAccount = validAccount;
		this.activatedAccount = activatedAccount;
	}

	/**
	 * @return the canTransfer
	 */
	public boolean isCanTransfer() {
		return canTransfer;
	}

	/**
	 * @param canTransfer the canTransfer to set
	 */
	public void setCanTransfer(boolean canTransfer) {
		this.canTransfer = canTransfer;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return sdf.format(creationDate.getTime());
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate.setTime(creationDate);
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
	 * @return the validAccount
	 */
	public boolean isValidAccount() {
		return validAccount;
	}

	/**
	 * @param validAccount the validAccount to set
	 */
	public void setValidAccount(boolean validAccount) {
		this.validAccount = validAccount;
	}

	/**
	 * @return the activatedAccount
	 */
	public boolean isActivatedAccount() {
		return activatedAccount;
	}

	/**
	 * @param activatedAccount the activatedAccount to set
	 */
	public void setActivatedAccount(boolean activatedAccount) {
		this.activatedAccount = activatedAccount;
	}
}
 
