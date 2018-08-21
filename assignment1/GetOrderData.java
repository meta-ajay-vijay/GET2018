package assignment1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import queries.Queries;
import connection.Connect;

public class GetOrderData {
/**
 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of 
 * that user which are in shipped state. Orders should be sorted by order date column in chronological order.
 * @param userId
 * @return
 */
	public static List<OrderInfo> getOrderData(int userId) {
		List<OrderInfo> listOfOrderInfo = new ArrayList<OrderInfo>();
		
		String query = (new Queries()).getSelectOrderInfoQuery();

		try (Connection conn = Connect.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);) {
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {

				int id = rset.getInt("OrderID");
				int cost = rset.getInt("Order_Cost");
				Date date = rset.getDate("PlacedDate");
				OrderInfo info = new OrderInfo(id, cost, date);
				listOfOrderInfo.add(info);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return listOfOrderInfo;
	}

}
