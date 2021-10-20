package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Controller;
import model.member.MemberDAO;
import model.member.MemberVO;

public class M_DELETE_Controller implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//ActionForward forward = new ActionForward();
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id"));
		
		if(dao.deleteMember(vo)) {
			HttpSession session = request.getSession();
			session.invalidate();
			return "index";
/*forward.setPath("index.jsp");
forward.setRedirect(true);*/
			
		}else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('½ÇÆÐ!'); history.go(-1); </script>");
			return null;
		}
		
		
		
//return forward;
	}

}
