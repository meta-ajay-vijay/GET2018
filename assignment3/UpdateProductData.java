package assignment3;

import java.sql.Connection;
import java.sql.PreparedStatement;

import queries.Queries;
import connection.Connect;

public class UpdateProductData {
/**
 * Delete all those products which were not ordered by any Shopper in last 1 year. 
 * Returns the number of products deleted.
 * @return
 */
	public static int deleteData(){
		int rowDeleted = 0;
		String queryForSafeUpdates = "SET SQL_SAFE_UPDATES = 0;";
		String query = (new Queries()).getUpdateProductDataQuery();		
		
		try(Connection conn = Connect.getConnection();
				PreparedStatement safeUpdateStmt = conn.prepareStatement(queryForSafeUpdates);	
				PreparedStatement stmt = conn.prepareStatement(query);	
			){
			
			safeUpdateStmt.executeUpdate();
			rowDeleted = stmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return rowDeleted;
	}
}