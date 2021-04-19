package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TransactionHistory {
	public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	protected int id; 
	protected int accountID; 
	protected String acountType; 
	protected Calendar transactionDate; 
	protected double amount;
	protected int receivingID; 
	protected String receivingType; 

	public TransactionHistory() {}
	
	public TransactionHistory(int id, int accountID, char acountType, Date transactionDate, double amount, int receivingID, char receivingType) {
		super();
		this.id = id;
		this.accountID = accountID;
		switch(acountType) {
		case 's':
			this.acountType = "savings";
			break;
		case 'l':
			this.acountType = "loan";
			break;
		case 'c':
			this.acountType = "checking";
			break;
		}
		this.transactionDate = Calendar.getInstance();
		this.transactionDate.setTime(transactionDate);
		this.amount = amount;
		this.receivingID = receivingID;
		switch(receivingType) {
		case 's':
			this.receivingType = "savings";
			break;
		case 'l':
			this.receivingType = "loan";
			break;
		case 'c':
			this.receivingType = "checking";
			break;
		}
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

	/**
	 * @return the acountType
	 */
	public String getAcountType() {
		return acountType;
	}

	/**
	 * @param acountType the acountType to set
	 */
	public void setAcountType(String acountType) {
		this.acountType = acountType;
	}

	/**
	 * @return the transactionDate
	 */
	public Calendar getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @return the transactionDate
	 */
	public String getTransactionDateAsString() {
		return sdf.format(transactionDate.getTime());
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate.setTime(transactionDate);
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the receivingID
	 */
	public int getReceivingID() {
		return receivingID;
	}

	/**
	 * @param receivingID the receivingID to set
	 */
	public void setReceivingID(int receivingID) {
		this.receivingID = receivingID;
	}

	/**
	 * @return the receivingType
	 */
	public String getReceivingType() {
		return receivingType;
	}

	/**
	 * @param receivingType the receivingType to set
	 */
	public void setReceivingType(String receivingType) {
		this.receivingType = receivingType;
	}
}

 