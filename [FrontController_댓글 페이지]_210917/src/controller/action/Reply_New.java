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
		
	// 회원이 아닌데 접속했을 경우, 뒤로가기 이동
		if(session.getAttribute("userData")==null) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원만 이용이 가능한 서비스 입니다!');  history.go(-1); </script>");
			return null;
		}
		
	// class 인스턴스	
		// 리턴 forward 인스턴스화
		ActionForward forward = new ActionForward();
		// DAO VO 인스턴스화
		ReplyVO replyVO = new ReplyVO();
		ReplyDAO replyDAO = new ReplyDAO();
		

	// DAO 수행 필요 데이터
		replyVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		replyVO.setUserID(request.getParameter("userID"));
		replyVO.setRmsg(request.getParameter("rmsg"));
		
	// 리플추가 실패
		if(!replyDAO.reply_INSERT(replyVO)){
			throw new IOException("ReplyNew에서 발생!");			
		}
		
	// 추가 되었다면 메인페이지 이동
		forward.setRedirect(false);
		forward.setPath("main.do"); //메인페이지 이동
		return forward;


	}
	

}
