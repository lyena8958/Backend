package model.commit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {

	
	public static Connection getConnection() {
		String DName ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "Hwang"; //kim
		String pw = "1234"; // 8958
		
		Connection conn= null;
		
		try {
			Class.forName(DName);
			conn= DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
