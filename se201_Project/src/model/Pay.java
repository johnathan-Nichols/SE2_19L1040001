package model;

public class Pay {
	private String account;
	private String receiveID;
	private String owedAmount;
	private String payAmount;
	private String cIPR;
	
	public Pay(Account account, String receiveID, String owedAmount, String payAmount, String cIPR) {
		super();
		this.account = account.toString();
		this.receiveID = receiveID;
		this.owedAmount = owedAmount;
		this.payAmount = payAmount;
		this.cIPR = cIPR;
	}
	
	public Pay(String account, String receiveID, String owedAmount, String payAmount, String cIPR) {
		super();
		this.account = account;
		this.receiveID = receiveID;
		this.owedAmount = owedAmount;
		this.payAmount = payAmount;
		this.cIPR = cIPR;
	}
	
	/**
	 * account - receiveID - owedAmount - payAmount - cIPR
	 */
	public String toString() {
		return account + "and" + receiveID+ "and" + owedAmount+ "and" + payAmount+ "and" + cIPR;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account.toString();
	}

	/**
	 * @return the receiveID
	 */
	public String getReceiveID() {
		return receiveID;
	}

	/**
	 * @param receiveID the receiveID to set
	 */
	public void setReceiveID(String receiveID) {
		this.receiveID = receiveID;
	}

	/**
	 * @return the owedAmount
	 */
	public String getowedAmount() {
		return owedAmount;
	}

	/**
	 * @param owedAmount the owedAmount to set
	 */
	public void setowedAmount(String owedAmount) {
		this.owedAmount = owedAmount;
	}

	/**
	 * @return the payAmount
	 */
	public String getPayAmount() {
		return payAmount;
	}

	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * @return the cIPR
	 */
	public String getcIPR() {
		return cIPR;
	}

	/**
	 * @param cIPR the cIPR to set
	 */
	public void setcIPR(String cIPR) {
		this.cIPR = cIPR;
	}
	
	
}
