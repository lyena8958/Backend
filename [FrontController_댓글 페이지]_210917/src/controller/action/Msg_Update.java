package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.common.Action;
import model.message.MessageDAO;
import model.message.MessageVO;

public class Msg_Update implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// ȸ���� �ƴѵ� �������� ���, �ڷΰ��� �̵�
		if(session.getAttribute("userData")==null) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=UTF-8"); 
			out.println("<script>alert('ȸ���� �̿��� ������ ���� �Դϴ�!');  history.go(-1); </script>");
			return null;
		}
		
	// class �ν��Ͻ�	
		// ���� forward �ν��Ͻ�ȭ
		ActionForward forward = new ActionForward();
		
	// DAO VO �ν��Ͻ�ȭ
		MessageDAO messageDAO = new MessageDAO();
		MessageVO messageVO = new MessageVO();
		
	//messageVO DB������ �޾ƿ���
		messageVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		messageVO = messageDAO.msg_SELECT_ONE(messageVO);
		
	// DAO�� ���� �ʿ� ������
			// 1. LikeCnt �߰��� ���
		if(request.getParameter("likeCnt")!=null){ 
			messageVO.setLikeCnt(Integer.parseInt(request.getParameter("likeCnt")));	
		}
		    // 2. msg �߰�
		messageVO.setMsg(request.getParameter("msg"));

	// ��۾�����Ʈ ����
		if(!messageDAO.msg_UPDATE(messageVO)){
			throw new IOException("MsgNew���� �߻�!");	
		}
		
	// �߰� �Ǿ��ٸ� ���������� �̵�
		forward.setRedirect(false);
		forward.setPath("main.do"); //���������� �̵�
		return forward;
	}
	
}
