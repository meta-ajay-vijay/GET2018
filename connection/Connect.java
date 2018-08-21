package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/storefront";
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return conn;
	}

}