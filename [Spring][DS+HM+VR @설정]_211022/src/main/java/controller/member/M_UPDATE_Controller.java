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
public class M_UPDATE_Controller{

	@RequestMapping("/updateMem.do")
	public String updateMem(HttpServletResponse response, MemberDAO dao, MemberVO vo) throws IOException {

		HttpSession session = request.getSession();

		MemberDAO dao = new MemberDAO();
		MemberVO vo = (MemberVO)session.getAttribute("userData");

		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));

		if(dao.updateMember(vo)) {			
			//ModelAndView mav = new ModelAndView();
			//mav.setViewName("redirect:main.do"); 
			
			return "redirect:main.do";

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
		HttpSession session = request.getSession();

		MemberDAO dao = new MemberDAO();
		MemberVO vo = (MemberVO)session.getAttribute("userData");

		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));

		if(dao.updateMember(vo)) {
forward.setPath("main.do");
forward.setRedirect(true);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:main.do"); 
			
			return mav;
		//  return "main.do"; 

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