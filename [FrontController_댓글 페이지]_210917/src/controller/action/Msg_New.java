package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.common.Action;
import model.message.MessageDAO;
import model.message.MessageVO;

public class Msg_New implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// class �ν��Ͻ�	
		// ���� forward �ν��Ͻ�ȭ
		ActionForward forward = new ActionForward();
		// DAO VO �ν��Ͻ�ȭ
		MessageDAO messageDAO = new MessageDAO();
		MessageVO messageVO = new MessageVO();

		// DAO ���� �ʿ� ������
		messageVO.setUserID(request.getParameter("userID"));
		messageVO.setMsg(request.getParameter("msg"));
		
		// ����߰� ����
		if(!messageDAO.msg_INSERT(messageVO)){
			throw new IOException("MsgNew���� �߻�!");			
		}
		
		// �߰� �Ǿ��ٸ� ���������� �̵�
		forward.setRedirect(false);
		forward.setPath("main.do"); //���������� �̵�
		return forward;

	}
	
}
