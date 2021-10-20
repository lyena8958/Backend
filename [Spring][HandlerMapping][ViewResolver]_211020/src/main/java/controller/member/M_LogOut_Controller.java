package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Controller;

public class M_LogOut_Controller implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//ActionForward forward = new ActionForward();
		
		// 세션 초기화
		HttpSession session = request.getSession();
		session.invalidate();
		
//forward.setRedirect(true); //헤더교체
//forward.setPath("index.jsp");
		
		return "index";
	}

}
