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
		
		// ���� forward �ν��Ͻ�ȭ
		ActionForward forward = new ActionForward();
		
		// session �ν��Ͻ�ȭ
		HttpSession session = request.getSession();
		
		// �����ʱ�ȭ
		session.invalidate();
		
		//���������� �̵�
		forward.setRedirect(false);
		forward.setPath("main.do");
		
		return forward;
	}

	
	
}
