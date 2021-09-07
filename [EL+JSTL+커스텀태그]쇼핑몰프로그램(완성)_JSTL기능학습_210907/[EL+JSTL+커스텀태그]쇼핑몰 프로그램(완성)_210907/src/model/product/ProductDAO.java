package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.commit.JDBC;

public class ProductDAO {
	String sql_INSERT = "INSERT INTO PRODUCT (PNUM, PNAME, PRICE, CNT) VALUES "
			+ "((SELECT NVL(MAX(PNUM), 0)+1 FROM PRODUCT), ?, ?, ?)";
	String sql_SELECT_ALL = "SELECT * FROM PRODUCT WHERE PNAME LIKE ? ORDER BY PNUM DESC";
	String sql_SELECT_ONE = "SELECT * FROM PRODUCT WHERE PNUM=?";
	String sql_UPDATE = "UPDATE PRODUCT SET PNAME=?, PRICE=?, CNT=? WHERE PNUM=?";
	String sql_DELETE = "DELETE FROM PRODUCT WHERE PNUM=?";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	// [물품추가]
	public boolean productInsert(ProductVO vo) {
		
		
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getpName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getCnt());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("productInsert 오류발생");
			return false;
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return true;
		
	}
	
	// [물품 전체목록] [검색기록]
	public ArrayList<ProductVO> productList(String str){
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setString(1, "%"+str+"%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO data = new ProductVO();
				data.setPnum(rs.getInt("PNUM"));
				data.setpName(rs.getString("PNAME"));
				data.setPrice(rs.getInt("PRICE"));
				data.setCnt(rs.getInt("CNT"));
				datas.add(data); // 인덱스단위로 객체 삽입
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("productList 오류발생");
		}finally {
			JDBC.close(conn, pstmt);
		}
	
		return datas;
		
	}
	
	// [단일상품조회]
	public ProductVO productData(ProductVO vo) {
		ProductVO data = null;
		
		
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getPnum());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new ProductVO();
				data.setPnum(rs.getInt("PNUM"));
				data.setpName(rs.getString("PNAME"));
				data.setPrice(rs.getInt("PRICE"));
				data.setCnt(rs.getInt("CNT"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("productData 오류발생");
		}finally {
			JDBC.close(conn, pstmt);
		}

		return data;
	}
	
	// [상품변경]
	public boolean productUpdate(ProductVO vo) {
		
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getpName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getCnt());
			pstmt.setInt(4, vo.getPnum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("productUpdate 오류발생");
			return false;
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return true;
	}
	
	// [상품삭제]
	public boolean productDelete(ProductVO vo) {
		
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("productDelete 오류발생");
			return false;
		}finally{
			JDBC.close(conn, pstmt);
		}
		
		return true;
	}
}
