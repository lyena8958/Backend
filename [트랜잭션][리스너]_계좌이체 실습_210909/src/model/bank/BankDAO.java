package model.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BankDAO {
	String sql_SELECT_ALL = "SELECT * FROM BANK";
	String sql_SELECT_ONE = "SELECT * FROM BANK WHERE BID=? OR BNAME=?";
	//String sql_UPDATE_minus = "UPDATE BANK SET BALANCE=BALANCE?? WHERE BID=?";
	String sql_UPDATE_plus = "UPDATE BANK SET BALANCE=BALANCE+? WHERE BID=?";
	String sql_UPDATE_minus = "UPDATE BANK SET BALANCE=BALANCE-? WHERE BID=?";
	String sql_INSERT = "INSERT INTO BANK (BID, BNAME,BALANCE) VALUES "
			+ "((SELECT NVL(MAX(BID),0)+1 FROM BANK), ?, ?)";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public ArrayList<BankVO> bankList(){
		ArrayList<BankVO> datas = new ArrayList<BankVO>();
		
		try {
			conn = DBCP.getConn();
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BankVO data = new BankVO();
				data.setBid(rs.getInt("bid"));
				data.setBname(rs.getString("bname"));
				data.setBalance(rs.getInt("balance"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("bankList 에러");
		}finally {
				DBCP.disConn(conn, pstmt);
		}
		
		return datas;
		
		
	}
	public BankVO bankOne(BankVO vo){
		BankVO data = null;
		try {
			conn = DBCP.getConn();
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			
			pstmt.setInt(1, vo.getBid()==0 ? 0 : vo.getBid());
			pstmt.setString(2, vo.getBname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BankVO();
				data.setBid(rs.getInt("bid"));
				System.out.println(data.getBid());
				data.setBname(rs.getString("bname"));
				System.out.println(data.getBname());
				data.setBalance(rs.getInt("balance"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("bankOne 에러");
		}finally {
				DBCP.disConn(conn, pstmt);
		}
		
		return data;
		
		
	}

	public boolean pay(BankVO outVO, BankVO inVO){
		ArrayList<BankVO> datas = new ArrayList<BankVO>();
		Connection conn = null;
		try {
			conn = DBCP.getConn();
			conn.setAutoCommit(false);
			
			//보낸사람
			pstmt = conn.prepareStatement(sql_UPDATE_minus);
			pstmt.setInt(1, outVO.getBalance());
			pstmt.setInt(2, outVO.getBid());
			pstmt.executeUpdate();
			
			//받는사람
			pstmt = conn.prepareStatement(sql_UPDATE_plus);
			pstmt.setInt(1, inVO.getBalance());
			pstmt.setInt(2, inVO.getBid());
			pstmt.executeUpdate();
			
			BankVO outUser = bankOne(outVO);
			System.out.println(outUser);
			if(outUser.getBalance()-outVO.getBalance() < 0) {
				conn.rollback();
				return false;
			}
			
			conn.commit();  


			conn.setAutoCommit(true);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("pay 에러");
			return false;
		}finally {
			DBCP.disConn(conn, pstmt);
		}
		
		return true;
		
		
	}
}
