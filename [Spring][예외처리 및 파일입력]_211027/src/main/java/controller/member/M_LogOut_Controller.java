/*package controller.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class M_LogOut_Controller{

	@RequestMapping("/logout.do")
	public String handleRequest(HttpSession session, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();

		// ���� �ʱ�ȭ
		//HttpSession session = request.getSession();
		session.invalidate();

		//forward.setRedirect(true); //�����ü
		//forward.setPath("index.jsp");

		//return "index";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp"); 
		
		return mav;
		
		return "redirect:index.jsp";
	}



}
*/