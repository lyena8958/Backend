package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.common.Action;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class UserInfo_SignUp implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
	// class 인스턴스	
		// 리턴 forward 인스턴스화
		ActionForward forward = new ActionForward();
		
		// DAO VO 인스턴스화
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoVO userInfoVO = new UserInfoVO();
		
	// DAO 수행 필요 데이터	
		userInfoVO.setUserID(request.getParameter("userID"));
		userInfoVO.setUserPW(request.getParameter("userPW"));
		userInfoVO.setUserName(request.getParameter("userName"));
		
	// 가입 실패시
		
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		if(!userInfoDAO.user_INSERT(userInfoVO)) {
			
			out.println("<script>alert('회원가입 실패!');  history.go(-1); </script>");
			return null;
		}
	
	// 추가 되었다면 새창 close 
		out.println("<script>alert('가입 완료!'); window.close(); </script>");
		
		return null;
	}

	
	
}
