package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;

public class M_LogOut_Action implements Action{

	@Override
	public ActionForward doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		// ���� �ʱ�ȭ
		HttpSession session = request.getSession();
		session.invalidate();
		
		forward.setRedirect(true); //�����ü
		forward.setPath("index.jsp");
		
		return forward;
	}

}
