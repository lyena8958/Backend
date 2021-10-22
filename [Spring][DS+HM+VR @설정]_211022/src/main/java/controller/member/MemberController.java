package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.member.MemberDAO;
import model.member.MemberVO;

@Controller
public class MemberController {


	// request로부터 항상 세션을 받는 것이 아니고, 로그인이 완료되어야 session 셋팅이 되는 것이기 때문에{

	// 인자에 request만 넣어준다.
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String logInPrint(@ModelAttribute("guest")MemberVO vo) { // 오브젝트 하위로 POJO이기 때문에 가볍다 == MemberVO
		
		vo.setId("test");
		vo.setPassword("1234");
		
		return "login.jsp";

	}
	// request로부터 항상 세션을 받는 것이 아니고, 로그인이 완료되어야 session 셋팅이 되는 것이기 때문에
	// 인자에 request만 넣어준다.
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String logIn(HttpServletRequest request, MemberDAO dao, MemberVO vo) {

		vo = dao.getMember(vo);		

		// 로그인 성공	
		if(vo!=null){
			// session등록/
			// 누가 로그인이 되었는지 저장을위해 세션단위로 저장
			HttpSession session = request.getSession();
			session.setAttribute("userData", vo);

			return "redirect:main.do";

		}
		// 로그인 실패
		else{			
			return "redirect:index.jsp";
		}

	}

	// 100% session을 사용하기 때문에 command객체를 session인자로 받는다.
	@RequestMapping("/logout.do")
	public String logOut(HttpSession session, HttpServletResponse response) throws Exception {

		session.invalidate();

		return "redirect:index.jsp";
	}
	
	@RequestMapping("/signUp.do")
	public String signUp(HttpServletRequest request, HttpServletResponse response, MemberDAO dao, MemberVO vo) throws Exception {

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
	@RequestMapping("/updateMem.do")
	public String updateMem(HttpServletRequest request,HttpServletResponse response, MemberDAO dao, MemberVO vo) throws IOException {

		HttpSession session = request.getSession();
		vo = (MemberVO)session.getAttribute("userData");

		if(dao.updateMember(vo)) {			
			return "redirect:main.do";

		}else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('실패!'); history.go(-1); </script>");
			return null;
		}

	}
	@RequestMapping("/deleteMem.do")
	public String deleteMem(HttpServletResponse response, MemberDAO dao, MemberVO vo) throws IOException {

		if(dao.updateMember(vo)) {						
			return "redirect:main.do";

		}else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('실패!'); history.go(-1); </script>");
			return null;
		}
	}

}
