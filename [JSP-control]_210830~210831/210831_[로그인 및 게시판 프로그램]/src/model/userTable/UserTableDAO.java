package model.userTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.JDBCM;

public class UserTableDAO {
	public UserTableVO selectOne(UserTableVO vo) {
		Connection conn=JDBCM.connect();
		PreparedStatement pstmt=null;
		UserTableVO data=null;
		try{
			String sql="select * from userTable where userID=? and userPW=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new UserTableVO();
				data.setUnum(rs.getInt("unum"));
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserTableDAO selectOne()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBCM.disconnect(pstmt,conn);
		}
		return data;
	}
}
