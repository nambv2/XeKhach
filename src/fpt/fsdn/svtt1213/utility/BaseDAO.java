package fpt.fsdn.svtt1213.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
	

	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:sqlserver://localhost:1433;databasename=XEKHACH";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, "sa", "12345678");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
