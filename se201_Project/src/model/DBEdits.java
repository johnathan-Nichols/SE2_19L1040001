package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DBEdits {
	public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private int id;
	private Calendar editDate;
	private int editerUserID;
	private int editedUserID;
	private String editDescription;
	
	public DBEdits() {}

	public DBEdits(int id, Date editDate, int editerUserID, int editedUserID, String editDescription) {
		super();
		this.id = id;
		this.editDate = Calendar.getInstance();
		this.editDate.setTime(editDate);
		this.editerUserID = editerUserID;
		this.editedUserID = editedUserID;
		this.editDescription = editDescription;
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
	 * @return the editDate
	 */
	public Calendar getEditDate() {
		return editDate;
	}

	/**
	 * @return the editDate
	 */
	public String getEditDateAsString() {
		return sdf.format(editDate.getTime());
	}

	/**
	 * @param editDate the editDate to set
	 */
	public void setEditDate(Calendar editDate) {
		this.editDate = editDate;
	}

	/**
	 * @param editDate the editDate to set
	 */
	public void setEditDate(Date editDate) {
		this.editDate.setTime(editDate);;
	}

	/**
	 * @return the editerUserID
	 */
	public int getEditerUserID() {
		return editerUserID;
	}

	/**
	 * @param editerUserID the editerUserID to set
	 */
	public void setEditerUserID(int editerUserID) {
		this.editerUserID = editerUserID;
	}

	/**
	 * @return the editedUserID
	 */
	public int getEditedUserID() {
		return editedUserID;
	}

	/**
	 * @param editedUserID the editedUserID to set
	 */
	public void setEditedUserID(int editedUserID) {
		this.editedUserID = editedUserID;
	}

	/**
	 * @return the editDescription
	 */
	public String getEditDescription() {
		return editDescription;
	}

	/**
	 * @param editDescription the editDescription to set
	 */
	public void setEditDescription(String editDescription) {
		this.editDescription = editDescription;
	}
	
	

}
