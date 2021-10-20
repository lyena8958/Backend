package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;
import model.member.MemberDAO;
import model.member.MemberVO;

public class M_LogIn_Action implements Action{

	@Override
	public ActionForward doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.getMember(vo);

		forward.setRedirect(true);

		// 로그인 성공	
		if(data!=null){
			// session등록
			HttpSession session = request.getSession();
			session.setAttribute("userData", data);
			
			// 전송
			forward.setPath("main.do");
			
		}
		// 로그인 실패
		else{
			forward.setPath("index.jsp");
		}
		
		
		return forward;
	}

}
