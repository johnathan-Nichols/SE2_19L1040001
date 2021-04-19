package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SavingsAccount {
	public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	protected int id; 
	protected Customer customer; 
	protected double increasePercentage; 
	protected int increaseRate;
	protected Calendar lastIncrease; 
	protected Calendar creationDate; 
	protected double accountBalance; 
	protected boolean canTransfer;
	protected boolean validAccount; 
	protected boolean activatedAccount;
	
	public SavingsAccount() {}
	
	public SavingsAccount(double accountBalance) {
		this.accountBalance = accountBalance;
		increasePercentage = accountBalance * 0.05;
		increaseRate = 30;
		validAccount = true;
		activatedAccount = true;
	}
	
	public SavingsAccount(Customer customer, double increasePercentage, int increaseRate, Date lastIncrease, Date creationDate, double accountBalance, boolean validAccount, boolean activatedAccount) {
		super();
		this.customer = customer;
		this.increasePercentage = increasePercentage;
		this.increaseRate = increaseRate; 
		this.lastIncrease = Calendar.getInstance();
		this.lastIncrease.setTime(lastIncrease);
		this.creationDate = Calendar.getInstance();
		this.creationDate.setTime(creationDate);  
		this.accountBalance = accountBalance;  
		this.validAccount = validAccount; 
		this.activatedAccount = activatedAccount;
		checkIncrease();
	}
	
	public SavingsAccount(int id, Customer customer, double increasePercentage, int increaseRate, Date lastIncrease, Date creationDate, double accountBalance, boolean canTransfer, boolean validAccount, boolean activatedAccount) {
		super();
		this.id = id;
		this.customer = customer;
		this.increasePercentage = increasePercentage;
		this.increaseRate = increaseRate; 
		this.lastIncrease = Calendar.getInstance();
		this.lastIncrease.setTime(lastIncrease);
		this.creationDate = Calendar.getInstance();
		this.creationDate.setTime(creationDate); 
		this.accountBalance = accountBalance;  
		this.canTransfer = canTransfer;
		this.validAccount = validAccount; 
		this.activatedAccount = activatedAccount;
		checkIncrease();
	}

	public void checkIncrease() {
		Calendar dueDate = Calendar.getInstance();
		dueDate.setTime(lastIncrease.getTime());
		dueDate.add(dueDate.DATE, increaseRate);
		while(dueDate.getTime().before(Calendar.getInstance().getTime())) {
			lastIncrease.setTime(dueDate.getTime());
			dueDate.add(dueDate.DATE, increaseRate);
			accountBalance *= 1+increasePercentage;
		}
	}
	
	public String getLastIncrease() {
		return sdf.format(lastIncrease.getTime());
	}

	public void setLastIncrease(Date lastIncrease) {
		this.lastIncrease.setTime(lastIncrease);
	}

	public String getCreationDate() {
		return sdf.format(creationDate.getTime());
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate.setTime(creationDate);
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
	 * @return the increasePercentage
	 */
	public double getIncreasePercentage() {
		return increasePercentage;
	}

	/**
	 * @param increasePercentage the increasePercentage to set
	 */
	public void setIncreasePercentage(double increasePercentage) {
		this.increasePercentage = increasePercentage;
	}

	/**
	 * @return the increaseRate
	 */
	public int getIncreaseRate() {
		return increaseRate;
	}

	/**
	 * @param increaseRate the increaseRate to set
	 */
	public void setIncreaseRate(int increaseRate) {
		this.increaseRate = increaseRate;
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