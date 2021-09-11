package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

// DAO마다 conn, disconn을 해야하니 --> JDBC 클래스를 만들어주자.
public class MessageDAO {
	//JDBC 인스턴스화를 하는게 아니라, 다이렉트로 불러서 쓰고있다.
	//				== static
	
	
	public ArrayList<MessageVO> getDBList(){
		Connection conn = JDBC.connect();
		ArrayList<MessageVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		
		try{ 
			String sql="select * from message order by mnum desc"; // 최근 게시글 상단배치
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				MessageVO vo=new MessageVO();
				vo.setContent(rs.getString("content"));
				vo.setMnum(rs.getInt("mnum"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setWriter(rs.getString("writer"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("select()���� ���");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return datas;
	}

	public MessageVO getDBData(MessageVO vo){
	      Connection conn=JDBC.connect();
	      MessageVO data=null;
	      PreparedStatement pstmt=null;
	      try{
	         String sql="select * from message where mnum=?";
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setInt(1, vo.getMnum());
	         ResultSet rs=pstmt.executeQuery();
	         if(rs.next()){
	            data=new MessageVO();
	            data.setContent(rs.getString("content"));
	            data.setMnum(rs.getInt("mnum"));
	            data.setTitle(rs.getString("title"));
	            data.setWdate(rs.getDate("wdate"));
	            data.setWriter(rs.getString("writer"));
	         }
	         rs.close();
	      }
	      catch(Exception e){
	         System.out.println("getDBData()에서 출력");
	         e.printStackTrace();
	      }
	      finally {
	         JDBC.disconnect(pstmt,conn);
	      }
	      return data;
	   }
	
	public boolean insertDB(MessageVO vo) {
	      Connection conn=JDBC.connect();
	      PreparedStatement pstmt=null;
	      try{
	         String sql="insert into message values((select nvl(max(mnum), 0)+1 from message) , ?, ?, ?, ?)";
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, vo.getWriter());
	         pstmt.setString(2, vo.getTitle());
	         pstmt.setString(3, vo.getContent());
	         pstmt.setDate(4, vo.getWdate());
	         pstmt.executeUpdate();
	      }
	      catch(Exception e){
	         System.out.println("insertDB()에서 출력");
	         e.printStackTrace();
	         return false; // 오류 발생시 false 반환
	      }
	      finally {
	         JDBC.disconnect(pstmt,conn);
	      }
	      return true; // catch부분에서 오류가 발생하지 않았다면 true 반환
	}
	
	public boolean deleteDB(MessageVO vo) {
		
	      Connection conn=JDBC.connect();
	      PreparedStatement pstmt=null;
	      try{
	         String sql="delete from message where mnum=?";
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setInt(1, vo.getMnum());
	         pstmt.executeUpdate();
	      }
	      catch(Exception e){
	         System.out.println("deleteDB()에서 출력");
	         e.printStackTrace();
	         return false; // 오류 발생시 false 반환
	      }
	      finally {
	         JDBC.disconnect(pstmt,conn);
	      }
	      return true; // catch부분에서 오류가 발생하지 않았다면 true 반환
	}
	
	// 회사마다, boolean, num, 로깅기법으로 확인하는 방식이 다르다
	// 포폴에서는 boolean으로 자주사용
	//예나풀이
	public void updateDB(MessageVO vo) {
		
	      Connection conn=JDBC.connect();
	      PreparedStatement pstmt=null;
	      try{
	         String sql="update message set content=?, title=?, wdate=?, writer=? where mnum=?";
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, vo.getContent());
	         pstmt.setString(2, vo.getTitle());
	         pstmt.setDate(3, vo.getWdate());
	         pstmt.setString(4, vo.getWriter());
	         pstmt.setInt(5, vo.getMnum());
	         pstmt.executeUpdate();
	      }
	      catch(Exception e){
	         System.out.println("updateDB()에서 출력");
	         e.printStackTrace();
	      }
	      finally {
	         JDBC.disconnect(pstmt,conn);
	      }
	}
	
	
	// 강사님 풀이
		// 인자에 String title....가 반복되면 유지보수가 매우 안좋다 == 추가시마다 코드를 추가해줘야함
	public boolean updateDB2(MessageVO vo) { 
		
	      Connection conn=JDBC.connect();
	      boolean result = false;
	      PreparedStatement pstmt=null;
	      try{												// date는 현재시간으로 수정시간을 변경
	         String sql="update message set content=?, title=?, wdate=sysdate, writer=? where mnum=?";
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, vo.getContent());
	         pstmt.setString(2, vo.getTitle());
	         pstmt.setDate(3, vo.getWdate());  
	         pstmt.setInt(4, vo.getMnum());
	         pstmt.executeUpdate();
	         result=true; // 오류가나지않았다면 true 변환
	      }
	      catch(Exception e){
	         System.out.println("updateDB2()에서 출력");
	         e.printStackTrace();
	         //res=false;
	      }
	      finally {
	         JDBC.disconnect(pstmt,conn);
	      }
	      return result;
	}
	
}
