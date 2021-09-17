package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.common.Action;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class UserInfo_Login implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// class �ν��Ͻ�		
		// ���� forward �ν��Ͻ�ȭ
		ActionForward forward = new ActionForward();
		
		// DAO VO �ν��Ͻ�ȭ
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoVO userInfoVO = new UserInfoVO();
				
	// DAO ���� �ʿ� ������	
		userInfoVO.setUserID(request.getParameter("userID"));
		userInfoVO.setUserPW(request.getParameter("userPW"));
				
	// �α��� ���� ����	
		userInfoVO = userInfoDAO.user_SELECT_ONE(userInfoVO);
		
	// �α��� ���н�	(��ȯ�����Ͱ� null�̶��) -> �ڷΰ���
		if(userInfoVO == null) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�α��� ����!');  history.go(-1); </script>");
			return null;
		}
		
	// �α��� �Ϸ� �����߰� �� ���������� �̵�
		HttpSession session = request.getSession();
		session.setAttribute("userData", userInfoVO);
		
		forward.setRedirect(false);
		forward.setPath("main.do");
				
		return forward;
	}
	
	

}
