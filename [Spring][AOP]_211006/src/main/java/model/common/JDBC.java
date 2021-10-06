
package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String password = "8958";

		Connection conn = null;
		try {
			Class.forName(driver);
			return conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null; // 리턴되지 않아 아래까지 오게 되었다면 null 리턴
	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close(); // 커넥션이 close를 하면서 관련된 것을 모두 닫아주기 때문에 rs, pstmt close 안해주어도 무방하다. 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
