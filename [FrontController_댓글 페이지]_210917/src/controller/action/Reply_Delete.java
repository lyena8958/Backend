package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.common.Action;
import model.reply.ReplyDAO;
import model.reply.ReplyVO;

public class Reply_Delete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// class 인스턴스	
		// 리턴 forward 인스턴스화
		ActionForward forward = new ActionForward();
		
		
		// DAO VO 인스턴스화	
		ReplyDAO replyDAO = new ReplyDAO();
		ReplyVO replyVO = new ReplyVO();
		
		replyVO.setRnum(Integer.parseInt(request.getParameter("rnum")));
		replyVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		
	// 리플 업데이트 실패 
		if(!replyDAO.reply_DELETE(replyVO)) {
			throw new IOException("Reply_Delete 에러");
		}
		
	// 추가 되었다면 메인페이지 이동
		forward.setRedirect(false);
		forward.setPath("main.do"); //메인페이지 이동
		
		return forward;
	}

}
