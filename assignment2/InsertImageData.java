package assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import queries.Queries;
import connection.Connect;

public class InsertImageData {
 /**
  * Insert five or more images of a product using batch insert technique.
  * @param listOfImageData
  * @param productId
  * @return
  */
	public static boolean inserImageData(List<ImageData> listOfImageData,int productId){
		String query = (new Queries()).getInsertImageQuery();
		int rowInserted = 0;
		try (Connection conn = Connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);) {
			
			try{
				conn.setAutoCommit(false);
				for (int i = 1; i <= 5; i++) {
					stmt.setString(1,listOfImageData.get(i-1).getUrl());
					stmt.setString(2, listOfImageData.get(i-1).getName());
					stmt.setInt(3, productId);
					stmt.addBatch();
				}
				rowInserted = stmt.executeBatch().length;
				conn.commit();
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
				conn.rollback();
		  }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rowInserted==listOfImageData.size();
	}
	
}