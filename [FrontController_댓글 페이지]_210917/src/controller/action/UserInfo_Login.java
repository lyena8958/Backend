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
		
	// class 인스턴스		
		// 리턴 forward 인스턴스화
		ActionForward forward = new ActionForward();
		
		// DAO VO 인스턴스화
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoVO userInfoVO = new UserInfoVO();
				
	// DAO 수행 필요 데이터	
		userInfoVO.setUserID(request.getParameter("userID"));
		userInfoVO.setUserPW(request.getParameter("userPW"));
				
	// 로그인 정보 받음	
		userInfoVO = userInfoDAO.user_SELECT_ONE(userInfoVO);
		
	// 로그인 실패시	(반환데이터가 null이라면) -> 뒤로가기
		if(userInfoVO == null) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 실패!');  history.go(-1); </script>");
			return null;
		}
		
	// 로그인 완료 세션추가 및 메인페이지 이동
		HttpSession session = request.getSession();
		session.setAttribute("userData", userInfoVO);
		
		forward.setRedirect(false);
		forward.setPath("main.do");
				
		return forward;
	}
	
	

}
