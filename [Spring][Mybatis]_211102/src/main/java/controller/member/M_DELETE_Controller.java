/*package controller.member;

import java.io.IOException;
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
public class M_DELETE_Controller{

	@RequestMapping("/deleteBoard.do")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//ActionForward forward = new ActionForward();

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		ModelAndView mav = new ModelAndView();
		
		vo.setId(request.getParameter("id"));

		if(dao.deleteMember(vo)) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			//mav.setViewName("redirect:index.jsp");
			
			
			return "redirect:index.jsp";


		}else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('실패!'); history.go(-1); </script>");
			return null;
		}



		//return forward;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		ModelAndView mav = new ModelAndView();
		
		vo.setId(request.getParameter("id"));

		if(dao.deleteMember(vo)) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			mav.setViewName("redirect:index.jsp");
			
			return mav;
			//return "index";
			 
			forward.setPath("index.jsp");
		forward.setRedirect(true);

		}else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('실패!'); history.go(-1); </script>");
			return null;
		}



		//return forward;
	}



}
*/