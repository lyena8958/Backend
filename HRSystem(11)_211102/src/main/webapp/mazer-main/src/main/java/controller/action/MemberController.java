package controller.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.member.MemberDAO;
import model.member.MemberVO;

@Controller
public class MemberController {
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginPrint(@ModelAttribute("guest")MemberVO vo) {
		vo.setId("test");
		vo.setPassword("1234");
		return "login.jsp";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpSession session,MemberVO vo,MemberDAO dao) {
		MemberVO data=dao.getMember(vo);
		
		if(data!=null){
			session.setAttribute("user", data.getName());
			return "redirect:main.do";
		}
		else{
			return "redirect:login.jsp";
		}	
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
}
