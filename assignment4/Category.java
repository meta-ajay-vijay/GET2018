package assignment4;

public class Category {
	String ParentType; 
	int totalChilds;

	public Category(String parentType, int totalChilds) {
		super();
		ParentType = parentType;
		this.totalChilds = totalChilds;
	}
	/**
	 * @return the parentType
	 */
	public String getParentType() {
		return ParentType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [ParentType=" + ParentType + ", totalChilds="
				+ totalChilds + "]";
	}
	/**
	 * @param parentType the parentType to set
	 */
	public void setParentType(String parentType) {
		ParentType = parentType;
	}
	/**
	 * @return the totalChilds
	 */
	public int getTotalChilds() {
		return totalChilds;
	}
	/**
	 * @param totalChilds the totalChilds to set
	 */
	public void setTotalChilds(int totalChilds) {
		this.totalChilds = totalChilds;
	}

}