package assignment1;

import java.sql.Date;

public class OrderInfo {
	private int objectId;
	private int totalCost;
	private Date placedDate; 

	/**
	 * @return the objectId
	 */
	public int getObjectId() {
		return objectId;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	/**
	 * @return the totalCost
	 */
	public int getTotalCost() {
		return totalCost;
	}
	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * @return the placedDate
	 */
	public Date getPlacedDate() {
		return placedDate;
	}
	/**
	 * @param placedDate the placedDate to set
	 */
	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}
	public OrderInfo(int objectId, int totalCost, Date placedDate) {
		super();
		this.objectId = objectId;
		this.totalCost = totalCost;
		this.placedDate = placedDate;
	}

}