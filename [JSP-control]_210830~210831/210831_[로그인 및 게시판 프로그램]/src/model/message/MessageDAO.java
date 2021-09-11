package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBCM;

public class MessageDAO {
	public ArrayList<MessageVO> selectAll(String condition,String content){
		Connection conn=JDBCM.connect();
		ArrayList<MessageVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from message where "+condition+" like '"+content+"%' order by mid desc";
			pstmt=conn.prepareStatement(sql);
			/*
			pstmt.setString(1, condition);
			pstmt.setString(2, "%"+content+"%"); // '?%'
			*/
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				MessageVO vo=new MessageVO();
				vo.setContent(rs.getString("content"));
				vo.setMid(rs.getInt("mid"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getDate("wdate"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBCM.disconnect(pstmt,conn);
		}
		
		return datas;
	}

	public MessageVO selectOne(MessageVO vo){
		Connection conn=JDBCM.connect();
		MessageVO data=null;
		PreparedStatement pstmt=null;
		try{
			String sql="select * from message where mid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MessageVO();
				data.setContent(rs.getString("content"));
				data.setMid(rs.getInt("mid"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setWdate(rs.getDate("wdate"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBCM.disconnect(pstmt,conn);
		}
		return data;
	}

	public void insertDB(MessageVO vo) {
		Connection conn=JDBCM.connect();
		PreparedStatement pstmt=null;
		try{
			String sql="insert into message (writer,title,content,wdate) values(?,?,?,now())";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("insertDB()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBCM.disconnect(pstmt,conn);
		}
	}
}
