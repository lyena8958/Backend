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
		
		// 회원이 아닌데 접속했을 경우, 뒤로가기 이동
		if(session.getAttribute("userData")==null) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=UTF-8"); 
			out.println("<script>alert('회원만 이용이 가능한 서비스 입니다!');  history.go(-1); </script>");
			return null;
		}
		
	// class 인스턴스	
		// 리턴 forward 인스턴스화
		ActionForward forward = new ActionForward();
		
	// DAO VO 인스턴스화
		MessageDAO messageDAO = new MessageDAO();
		MessageVO messageVO = new MessageVO();
		
	//messageVO DB데이터 받아오기
		messageVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		messageVO = messageDAO.msg_SELECT_ONE(messageVO);
		
	// DAO를 수행 필요 데이터
			// 1. LikeCnt 추가한 경우
		if(request.getParameter("likeCnt")!=null){ 
			messageVO.setLikeCnt(Integer.parseInt(request.getParameter("likeCnt")));	
		}
		    // 2. msg 추가
		messageVO.setMsg(request.getParameter("msg"));

	// 댓글업데이트 실패
		if(!messageDAO.msg_UPDATE(messageVO)){
			throw new IOException("MsgNew에서 발생!");	
		}
		
	// 추가 되었다면 메인페이지 이동
		forward.setRedirect(false);
		forward.setPath("main.do"); //메인페이지 이동
		return forward;
	}
	
}
