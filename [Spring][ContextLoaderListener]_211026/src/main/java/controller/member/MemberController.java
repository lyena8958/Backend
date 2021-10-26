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


	// request�κ��� �׻� ������ �޴� ���� �ƴϰ�, �α����� �Ϸ�Ǿ�� session ������ �Ǵ� ���̱� ������{

	// ���ڿ� request�� �־��ش�.
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String logInPrint(@ModelAttribute("guest")MemberVO vo) { // ������Ʈ ������ POJO�̱� ������ ������ == MemberVO
		
		vo.setId("test");
		vo.setPassword("1234");
		
		return "login.jsp";

	}
	// request�κ��� �׻� ������ �޴� ���� �ƴϰ�, �α����� �Ϸ�Ǿ�� session ������ �Ǵ� ���̱� ������
	// ���ڿ� request�� �־��ش�.
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String logIn(HttpServletRequest request, MemberDAO dao, MemberVO vo) {

		vo = dao.getMember(vo);		

		// �α��� ����	
		if(vo!=null){
			// session���/
			// ���� �α����� �Ǿ����� ���������� ���Ǵ����� ����
			HttpSession session = request.getSession();
			session.setAttribute("userData", vo);

			return "redirect:main.do";

		}
		// �α��� ����
		else{			
			return "redirect:index.jsp";
		}

	}

	// 100% session�� ����ϱ� ������ command��ü�� session���ڷ� �޴´�.
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
			out.println("<script> alert('������ �Ϸ�Ǿ����ϴ�.'); location.href='index.jsp';</script>");

		}else {
			out.println("<script>alert('����!'); history.go(-1); </script>");

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
			out.println("<script>alert('����!'); history.go(-1); </script>");
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
			out.println("<script>alert('����!'); history.go(-1); </script>");
			return null;
		}
	}

}
