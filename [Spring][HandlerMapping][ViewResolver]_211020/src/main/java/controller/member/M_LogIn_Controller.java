package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Controller;
import model.member.MemberDAO;
import model.member.MemberVO;

public class M_LogIn_Controller implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//ActionForward forward = new ActionForward();

		// 코드의 변화를 줄이기 위해서 == 결합도를 낮추기 위해 VO를 사용하는 것이다.
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.getMember(vo);

//forward.setRedirect(true);

		// 로그인 성공	
		if(data!=null){
			// session등록
			HttpSession session = request.getSession();
			session.setAttribute("userData", data);
			
			return "main.do";
			// 전송
//forward.setPath("main.do");
			
		}
		// 로그인 실패
		else{
			// .jsp를 굳이 쓰지않아도. do가 없기 때문에 jsp로 ViewResolver가 인지하게 된다. 
			return "index";		// DispatcherServlet -> HendlerMapping -> Control -> ViewResolver
//forward.setPath("index.jsp");
		}
		
		
//return forward;
	}

}
