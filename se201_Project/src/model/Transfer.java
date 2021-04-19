package model;

public class Transfer {
	private String mainType;
	private int mainID;
	private String transferType;
	private int transferID;
	private double transferAmount;
	private double mainAccountAmount;
	private double transferAccountAmount;
	
	public Transfer() {}

	public Transfer(String mainType, String mainID, String transferType, String transferID, String transferAmount, String mainAccountAmount, String transferAccountAmount) {
		super();
		this.mainType = mainType;
		this.mainID = Integer.parseInt(mainID);
		this.transferType = transferType;
		this.transferID = Integer.parseInt(transferID);
		this.transferAmount = Double.parseDouble(transferAmount);
		this.mainAccountAmount = Double.parseDouble(mainAccountAmount);
		this.transferAccountAmount = Double.parseDouble(transferAccountAmount);
	}
	
	public String toString(){
		return mainType+"and"+mainID+"and"+transferType+"and"+transferID+"and"+transferAmount+"and"+mainAccountAmount+"and"+transferAccountAmount;
	}

	/**
	 * @return the mainAccountAmount
	 */
	public double getMainAccountAmount() {
		return mainAccountAmount;
	}

	/**
	 * @param mainAccountAmount the mainAccountAmount to set
	 */
	public void setMainAccountAmount(double mainAccountAmount) {
		this.mainAccountAmount = mainAccountAmount;
	}

	/**
	 * @return the transferAccountAmount
	 */
	public double getTransferAccountAmount() {
		return transferAccountAmount;
	}

	/**
	 * @param transferAccountAmount the transferAccountAmount to set
	 */
	public void setTransferAccountAmount(double transferAccountAmount) {
		this.transferAccountAmount = transferAccountAmount;
	}

	/**
	 * @return the transferAmount
	 */
	public double getTransferAmount() {
		return transferAmount;
	}

	/**
	 * @param transferAmount the transferAmount to set
	 */
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	/**
	 * @return the mainType
	 */
	public String getMainType() {
		return mainType;
	}

	/**
	 * @param mainType the mainType to set
	 */
	public void setMainType(String mainType) {
		this.mainType = mainType;
	}

	/**
	 * @return the mainID
	 */
	public int getMainID() {
		return mainID;
	}

	/**
	 * @param mainID the mainID to set
	 */
	public void setMainID(int mainID) {
		this.mainID = mainID;
	}

	/**
	 * @return the transferType
	 */
	public String getTransferType() {
		return transferType;
	}

	/**
	 * @param transferType the transferType to set
	 */
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	/**
	 * @return the transferID
	 */
	public int getTransferID() {
		return transferID;
	}

	/**
	 * @param transferID the transferID to set
	 */
	public void setTransferID(int transferID) {
		this.transferID = transferID;
	}
	
	
}
