package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO vo=new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao=new MemberDAO();
		MemberVO data=dao.getMember(vo);
		
		ModelAndView mav=new ModelAndView();
		if(data!=null){
			HttpSession session=request.getSession();
			session.setAttribute("user", data.getName());
			mav.setViewName("redirect:main.do"); // VR의 설정을 무시하고 redirect
		}
		else{
			mav.setViewName("redirect:index.jsp");
		}
		return mav;
	}

}
