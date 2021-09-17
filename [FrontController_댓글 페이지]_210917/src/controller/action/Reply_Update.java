package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.common.Action;
import model.reply.ReplyDAO;
import model.reply.ReplyVO;

public class Reply_Update implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// class �ν��Ͻ�	
		// ���� forward �ν��Ͻ�ȭ
		ActionForward forward = new ActionForward();
		
		
		// DAO VO �ν��Ͻ�ȭ	
		ReplyDAO replyDAO = new ReplyDAO();
		ReplyVO replyVO = new ReplyVO();
				
		replyVO.setRmsg(request.getParameter("rmsg"));
		replyVO.setRnum(Integer.parseInt(request.getParameter("rnum")));
		
	// ���� ������Ʈ ���� 
		if(!replyDAO.reply_UPDATE(replyVO)) {
			throw new IOException("Reply_Update ����");
		}
		
	// �߰� �Ǿ��ٸ� ���������� �̵�
		forward.setRedirect(false);
		forward.setPath("main.do"); //���������� �̵�
		
		return forward;
	}

}
