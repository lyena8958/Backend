
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
		
		return null; // ���ϵ��� �ʾ� �Ʒ����� ���� �Ǿ��ٸ� null ����
	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close(); // Ŀ�ؼ��� close�� �ϸ鼭 ���õ� ���� ��� �ݾ��ֱ� ������ rs, pstmt close �����־ �����ϴ�. 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
