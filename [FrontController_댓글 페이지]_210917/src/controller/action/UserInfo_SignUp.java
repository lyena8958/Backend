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
	// class �ν��Ͻ�	
		// ���� forward �ν��Ͻ�ȭ
		ActionForward forward = new ActionForward();
		
		// DAO VO �ν��Ͻ�ȭ
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoVO userInfoVO = new UserInfoVO();
		
	// DAO ���� �ʿ� ������	
		userInfoVO.setUserID(request.getParameter("userID"));
		userInfoVO.setUserPW(request.getParameter("userPW"));
		userInfoVO.setUserName(request.getParameter("userName"));
		
	// ���� ���н�
		
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		if(!userInfoDAO.user_INSERT(userInfoVO)) {
			
			out.println("<script>alert('ȸ������ ����!');  history.go(-1); </script>");
			return null;
		}
	
	// �߰� �Ǿ��ٸ� ��â close 
		out.println("<script>alert('���� �Ϸ�!'); window.close(); </script>");
		
		return null;
	}

	
	
}
