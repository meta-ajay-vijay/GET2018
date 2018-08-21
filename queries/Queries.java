package queries;

public class Queries {
	

	private String selectOrderInfoQuery;
	private String insertImageQuery;
	private String updateProductDataQuery;
	private String selectCategoryInfoQuery;

	
	/**
	 * @return the selectOrderInfoQuery
	 */
	public String getSelectOrderInfoQuery() {
		return selectOrderInfoQuery;
	}

	/**
	 * @param selectOrderInfoQuery the selectOrderInfoQuery to set
	 */
	public void setSelectOrderInfoQuery(String selectOrderInfoQuery) {
		this.selectOrderInfoQuery = selectOrderInfoQuery;
	}

	/**
	 * @return the insertImageQuery
	 */
	public String getInsertImageQuery() {
		return insertImageQuery;
	}

	/**
	 * @param insertImageQuery the insertImageQuery to set
	 */
	public void setInsertImageQuery(String insertImageQuery) {
		this.insertImageQuery = insertImageQuery;
	}

	/**
	 * @return the deleteProductDataQuery
	 */
	public String getUpdateProductDataQuery() {
		return updateProductDataQuery;
	}

	/**
	 * @param deleteProductDataQuery the deleteProductDataQuery to set
	 */
	public void setUpdateProductDataQuery(String deleteProductDataQuery) {
		this.updateProductDataQuery = deleteProductDataQuery;
	}

	/**
	 * @return the selectCategoryInfoQuery
	 */
	public String getSelectCategoryInfoQuery() {
		return selectCategoryInfoQuery;
	}

	/**
	 * @param selectCategoryInfoQuery the selectCategoryInfoQuery to set
	 */
	public void setSelectCategoryInfoQuery(String selectCategoryInfoQuery) {
		this.selectCategoryInfoQuery = selectCategoryInfoQuery;
	}

	public Queries() {

		this.selectOrderInfoQuery =  "SELECT ORDERS.OrderID, ORDERS.PlacedDate, PRODUCTS_ORDERS.ProductID, SUM(PRODUCTS.COST) AS Order_Cost"
				+ " FROM ORDERS"
				+ " LEFT JOIN PRODUCTS_ORDERS"
				+ " ON PRODUCTS_ORDERS.OrderID = ORDERS.OrderID"
				+ " LEFT JOIN PRODUCTS ON PRODUCTS.ProductID = PRODUCTS_ORDERS.ProductID"
				+ " WHERE PRODUCTS_ORDERS.State LIKE \'%Shipped%\'"
				+ " AND ORDERS.UserID ="
				+ 2
				+ " GROUP BY OrderID ORDER BY "
				+ " ORDERS.PlacedDate;";
		
		this.insertImageQuery = "INSERT INTO IMAGES(ImageURL,ImageName,ProductID) VALUES(?,?,?)"; 

		this.updateProductDataQuery = "UPDATE PRODUCTS SET PRODUCTS.IsActive = 0 "
				+ "WHERE PRODUCTS.ProductID NOT IN "
				+ "(SELECT DISTINCT PRODUCTS_ORDERS.ProductID "
				+ "FROM PRODUCTS_ORDERS "
				+ "LEFT JOIN ORDERS ON PRODUCTS_ORDERS.OrderID = ORDERS.OrderID "
				+ "WHERE ORDERS.PlacedDate BETWEEN (CURRENT_DATE - INTERVAL 1 YEAR) AND (CURRENT_DATE) );" ;

		this.selectCategoryInfoQuery =  "SELECT t.parent_type, COUNT(t.childId) AS Total_Childs "
				+ "FROM "
				+ "(SELECT c1.CategoryID AS childId, c1.Type AS childType, c2.CategoryID AS parentId, c2.type as parent_type "
				+ "FROM CATEGORIES c1 LEFT JOIN CATEGORies c2 ON c1.ParentCategory = c2.CategoryId) "
				+ "as t WHERE t.parentId IN (Select CategoryID FROM Categories WHERE ParentCategory = 0) "
				+ "GROUP BY t.parentId ORDER BY t.parent_type;";
	}
	

}