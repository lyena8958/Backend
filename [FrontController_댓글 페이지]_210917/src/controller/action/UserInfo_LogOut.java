package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.common.Action;

public class UserInfo_LogOut implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 리턴 forward 인스턴스화
		ActionForward forward = new ActionForward();
		
		// session 인스턴스화
		HttpSession session = request.getSession();
		
		// 세션초기화
		session.invalidate();
		
		//메인페이지 이동
		forward.setRedirect(false);
		forward.setPath("main.do");
		
		return forward;
	}

	
	
}
