package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoanAccount {
	public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	protected  int id;
	protected Customer customer;
	protected double increaseRate;
	protected int increaseInterval;
	protected double latePaymentPenalty;
	protected double intervalRequiredPayment;
	protected double currentIntervalPaymentReceived;
	protected Calendar lastIntervalDate;
	protected Calendar creationDate;
	protected Calendar dueDate;
	protected double accountBalance;
	protected double owedAmount;
	protected boolean canTransfer;
	protected boolean validAccount;
	protected boolean activatedAccount;

	public LoanAccount() {}

	/**
	 * TODO change to false 
	 * @param loanLength
	 * @param accountBalance
	 */
	public LoanAccount(double accountBalance) {
		this.accountBalance = accountBalance;
		owedAmount = accountBalance;
		increaseRate = (accountBalance * 0.05);
		increaseInterval = 20;
		latePaymentPenalty = (accountBalance * 1.5);
		intervalRequiredPayment = (accountBalance * 0.1);
		currentIntervalPaymentReceived = 0;
		validAccount = true;
		activatedAccount = true;
	}
	
	public LoanAccount(Customer customer, double increaseRate, int increaseInterval, double latePaymentPenalty, double intervalRequiredPayment, double currentIntervalPaymentReceived, Date lastIntervalDate, Date creationDate, double accountBalance, double owedAmount, boolean validAccount, boolean activatedAccount) {
		super();
		this.customer = customer;
		this.increaseRate = increaseRate;
		this.increaseInterval = increaseInterval;
		this.latePaymentPenalty = latePaymentPenalty;
		this.intervalRequiredPayment = intervalRequiredPayment;
		this.currentIntervalPaymentReceived = currentIntervalPaymentReceived;
		this.lastIntervalDate = Calendar.getInstance();
		this.lastIntervalDate.setTime(lastIntervalDate);
		this.creationDate = Calendar.getInstance();
		this.creationDate.setTime(creationDate);
		this.accountBalance = accountBalance;
		this.owedAmount = owedAmount;
		this.validAccount = validAccount;
		this.activatedAccount = activatedAccount;
		dueDate = Calendar.getInstance();
		dueDate.setTime(this.lastIntervalDate.getTime());
		dueDate.add(dueDate.DATE, increaseInterval);
		checkDates();
	}
	
	public LoanAccount(int id, Customer customer, double increaseRate, int increaseInterval, double latePaymentPenalty, double intervalRequiredPayment, double currentIntervalPaymentReceived, Date lastIntervalDate, Date creationDate, double accountBalance, double owedAmount, boolean canTransfer, boolean validAccount, boolean activatedAccount) {
		super();
		this.id = id;
		this.customer = customer;
		this.increaseRate = increaseRate;
		this.increaseInterval = increaseInterval;
		this.latePaymentPenalty = latePaymentPenalty;
		this.intervalRequiredPayment = intervalRequiredPayment;
		this.currentIntervalPaymentReceived = currentIntervalPaymentReceived;
		this.lastIntervalDate = Calendar.getInstance();
		this.lastIntervalDate.setTime(lastIntervalDate);
		this.creationDate = Calendar.getInstance();
		this.creationDate.setTime(creationDate);
		this.accountBalance = accountBalance;
		this.owedAmount = owedAmount;
		this.canTransfer = canTransfer;
		this.validAccount = validAccount;
		this.activatedAccount = activatedAccount;
		dueDate = Calendar.getInstance();
		dueDate.setTime(this.lastIntervalDate.getTime());
		dueDate.add(dueDate.DATE, increaseInterval);
		checkDates();
	}

	public String getCreationDateAsString() {
		return sdf.format(creationDate.getTime());
	}

	public String getLastIntervalDateAsString() {
		return sdf.format(lastIntervalDate.getTime());
	}

	public String getDueDateAsString() {
		return sdf.format(dueDate.getTime());
	}

	/**
	 * @return the dueDate
	 */
	public Calendar getDueDate() {
		dueDate = lastIntervalDate;
		dueDate.add(Calendar.DATE, increaseInterval);
		checkDates();
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
		checkDates();
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
	 * @return the owedAmount
	 */
	public double getOwedAmount() {
		checkDates();
		return owedAmount;
	}

	/**
	 * @param owedAmount the owedAmount to set
	 */
	public void setOwedAmount(double owedAmount) {
		this.owedAmount = owedAmount;
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
	 * @return the increaseRate
	 */
	public double getIncreaseRate() {
		return increaseRate;
	}

	/**
	 * @param increaseRate the increaseRate to set
	 */
	public void setIncreaseRate(double increaseRate) {
		this.increaseRate = increaseRate;
	}

	/**
	 * @return the increaseInterval
	 */
	public int getIncreaseInterval() {
		return increaseInterval;
	}

	/**
	 * @param increaseInterval the increaseInterval to set
	 */
	public void setIncreaseInterval(int increaseInterval) {
		this.increaseInterval = increaseInterval;
	}

	/**
	 * @return the latePaymentPenalty
	 */
	public double getLatePaymentPenalty() {
		return latePaymentPenalty;
	}

	/**
	 * @param latePaymentPenalty the latePaymentPenalty to set
	 */
	public void setLatePaymentPenalty(double latePaymentPenalty) {
		this.latePaymentPenalty = latePaymentPenalty;
	}

	/**
	 * @return the intervalRequiredPayment
	 */
	public double getIntervalRequiredPayment() {
		return intervalRequiredPayment;
	}

	/**
	 * @param intervalRequiredPayment the intervalRequiredPayment to set
	 */
	public void setIntervalRequiredPayment(double intervalRequiredPayment) {
		this.intervalRequiredPayment = intervalRequiredPayment;
	}

	/**
	 * @return the currentIntervalPaymentReceived
	 */
	public double getCurrentIntervalPaymentReceived() {
		checkDates();
		return currentIntervalPaymentReceived;
	}

	/**
	 * @param currentIntervalPaymentReceived the currentIntervalPaymentReceived to set
	 */
	public void setCurrentIntervalPaymentReceived(double currentIntervalPaymentReceived) {
		this.currentIntervalPaymentReceived = currentIntervalPaymentReceived;
	}

	/**
	 * @return the lastIntervalDate
	 */
	public Calendar getLastIntervalDate() {
		checkDates();
		return lastIntervalDate;
	}

	/**
	 * @param lastIntervalDate the lastIntervalDate to set
	 */
	public void setLastIntervalDate(Calendar lastIntervalDate) {
		this.lastIntervalDate = lastIntervalDate;
	}

	/**
	 * @return the creationDate
	 */
	public Calendar getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
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
	
	public void checkDates() {
		while(dueDate.getTime().before(Calendar.getInstance().getTime())) {
			lastIntervalDate.setTime(dueDate.getTime());
			dueDate.add(lastIntervalDate.DATE, increaseInterval);
			if(intervalRequiredPayment > currentIntervalPaymentReceived) {
				owedAmount += latePaymentPenalty;
			}
			owedAmount *= increaseRate;
			currentIntervalPaymentReceived = 0;
		}
	}
}