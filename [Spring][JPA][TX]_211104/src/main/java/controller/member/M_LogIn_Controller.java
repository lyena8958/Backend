/*package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.member.MemberDAO;
import model.member.MemberVO;

// @Service
// @Repository

//Component이 있지만 → 위 처럼 상속받은 어노테이션 중에, controller임을 알리자
// @Controller 어노테이션을 사용함으로써 컨트롤러임을 인식하기 때문에 implements를 안해 주어도 된다. 


// 어노테이션을 사용함으로써 implements를 갖는 의의
//   implements Controller를 하게 되면 → import를 수행하는데 web.servlet.mvc로, POJO가 아니다.(servlet)
// ① 완벽한 POJO 클래스 이다.
// ② 상속xxx, 추상메서드의 강제성xxx → 함수의 input, output "함수명 변경이 가능하다."


@Controller
public class M_LogIn_Controller{
	
	@RequestMapping("/login.do")
	public String handleRequest(HttpServletRequest request, MemberDAO dao, MemberVO vo) {
		//ActionForward forward = new ActionForward();

		// 코드의 변화를 줄이기 위해서 == 결합도를 낮추기 위해 VO를 사용하는 것이다.
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao = new MemberDAO();
		vo = dao.getMember(vo);

		//forward.setRedirect(true);

		// ★
		ModelAndView mav = new ModelAndView();
		
		
		// 로그인 성공	
		if(vo!=null){
			// session등록/
			// 누가 로그인이 되었는지 저장을위해 세션단위로 저장
			HttpSession session = request.getSession();
			session.setAttribute("userData", vo);

			// ★ 경로설정
			//mav.setViewName("redirect:main.do");
			
			return "redirect:main.do";

		}
		// 로그인 실패
		else{
			// .jsp를 굳이 쓰지않아도. do가 없기 때문에 jsp로 ViewResolver가 인지하게 된다. 
			
			// ★ 경로설정 // redirect : VR의 설정을 무시하고 redirect
			mav.setViewName("redirect:index.jsp");		// DispatcherServlet -> HendlerMapping -> Control -> ViewResolver
			
			return "redirect:index.jsp";
		}


		
		//return mav;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();

		// 코드의 변화를 줄이기 위해서 == 결합도를 낮추기 위해 VO를 사용하는 것이다.
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.getMember(vo);

		//forward.setRedirect(true);

		// ★
		ModelAndView mav = new ModelAndView();
		
		
		// 로그인 성공	
		if(data!=null){
			// session등록/
			// 누가 로그인이 되었는지 저장을위해 세션단위로 저장
			HttpSession session = request.getSession();
			session.setAttribute("userData", data);

			// ★ 경로설정
			mav.setViewName("redirect:main.do"); 
			// 전송
			//forward.setPath("main.do");

		}
		// 로그인 실패
		else{
			// .jsp를 굳이 쓰지않아도. do가 없기 때문에 jsp로 ViewResolver가 인지하게 된다. 
			
			// ★ 경로설정 // redirect : VR의 설정을 무시하고 redirect
			mav.setViewName("redirect:index.jsp");		// DispatcherServlet -> HendlerMapping -> Control -> ViewResolver
			//forward.setPath("index.jsp");
		}


		//return forward;s
		return mav;
	}



}
*/