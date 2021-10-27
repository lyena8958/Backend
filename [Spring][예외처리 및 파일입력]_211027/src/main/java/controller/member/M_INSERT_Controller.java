/*package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.member.MemberDAO;
import model.member.MemberVO;


@Controller
public class M_INSERT_Controller{

	@RequestMapping("/signUp.do")
	public String insertMem(HttpServletRequest request, HttpServletResponse response, MemberDAO dao, MemberVO vo) throws Exception {
		//ActionForward forward = new ActionForward();

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setRole("USER");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();

		if(dao.insertMember(vo)) {
			HttpSession session = request.getSession();
			session.invalidate();
			out.println("<script> alert('가입이 완료되었습니다.'); location.href='index.jsp';</script>");

		}else {
			out.println("<script>alert('실패!'); history.go(-1); </script>");

		}



		return null;
	}
	@Override
	public ModelAndView insertMem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setRole("USER");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();

		if(dao.insertMember(vo)) {
			HttpSession session = request.getSession();
			session.invalidate();
			out.println("<script> alert('가입이 완료되었습니다.'); location.href='index.jsp';</script>");

		}else {
			out.println("<script>alert('실패!'); history.go(-1); </script>");

		}



		return null;
	}


}
*/