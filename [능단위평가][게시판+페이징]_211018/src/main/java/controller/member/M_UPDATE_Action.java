package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import controller.Action;
import controller.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class M_UPDATE_Action implements Action{

	@Override
	public ActionForward doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = (MemberVO)session.getAttribute("userData");
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		
		if(dao.updateMember(vo)) {
			forward.setPath("main.do");
			forward.setRedirect(true);
			
		}else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('½ÇÆÐ!'); history.go(-1); </script>");
			return null;
		}
		
		
		
		return forward;
	}

}
