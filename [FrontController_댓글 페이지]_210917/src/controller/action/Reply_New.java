package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.common.Action;
import model.reply.ReplyDAO;
import model.reply.ReplyVO;

public class Reply_New implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
	// ȸ���� �ƴѵ� �������� ���, �ڷΰ��� �̵�
		if(session.getAttribute("userData")==null) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('ȸ���� �̿��� ������ ���� �Դϴ�!');  history.go(-1); </script>");
			return null;
		}
		
	// class �ν��Ͻ�	
		// ���� forward �ν��Ͻ�ȭ
		ActionForward forward = new ActionForward();
		// DAO VO �ν��Ͻ�ȭ
		ReplyVO replyVO = new ReplyVO();
		ReplyDAO replyDAO = new ReplyDAO();
		

	// DAO ���� �ʿ� ������
		replyVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		replyVO.setUserID(request.getParameter("userID"));
		replyVO.setRmsg(request.getParameter("rmsg"));
		
	// �����߰� ����
		if(!replyDAO.reply_INSERT(replyVO)){
			throw new IOException("ReplyNew���� �߻�!");			
		}
		
	// �߰� �Ǿ��ٸ� ���������� �̵�
		forward.setRedirect(false);
		forward.setPath("main.do"); //���������� �̵�
		return forward;


	}
	

}
