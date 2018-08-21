package assignment4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import queries.Queries;
import connection.Connect;

public class GetCategoryData {
/**
 * Select and display the category title
 *  of all top parent categories sorted alphabetically and 
 *  the count of their child categories.	
 * @return
 */
	public static List<Category> getCategoryData() {
		List<Category> categoryList = new ArrayList<Category>();

		String query = (new Queries()).getSelectCategoryInfoQuery();

		System.out.println(query);
		
		try (Connection conn = Connect.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);) {
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				String parentType = rset.getString("parent_type");
			    int childs = rset.getInt("Total_Childs");
				Category categoryInfo = new Category(parentType, childs);
				categoryList.add(categoryInfo);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return categoryList;
	}


}