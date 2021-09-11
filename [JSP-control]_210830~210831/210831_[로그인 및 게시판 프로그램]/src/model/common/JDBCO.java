package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCO {
	public static Connection connect() {
		Connection conn=null;
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		try{
			Class.forName(jdbc_driver);
			conn=DriverManager.getConnection(jdbc_url,"kim","1234");
		}
		catch(Exception e){
			System.out.println("Oconnect()에서 출력");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void disconnect(PreparedStatement pstmt,Connection conn) {
		try{
			if(pstmt!=null) {
				pstmt.close();
			}
			conn.close();
		}
		catch(Exception e){
			System.out.println("Odisconnect()에서 출력");
			e.printStackTrace();
		}
	}
}
