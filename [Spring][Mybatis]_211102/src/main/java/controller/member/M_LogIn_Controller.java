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

//Component�� ������ �� �� ó�� ��ӹ��� ������̼� �߿�, controller���� �˸���
// @Controller ������̼��� ��������ν� ��Ʈ�ѷ����� �ν��ϱ� ������ implements�� ���� �־ �ȴ�. 


// ������̼��� ��������ν� implements�� ���� ����
//   implements Controller�� �ϰ� �Ǹ� �� import�� �����ϴµ� web.servlet.mvc��, POJO�� �ƴϴ�.(servlet)
// �� �Ϻ��� POJO Ŭ���� �̴�.
// �� ���xxx, �߻�޼����� ������xxx �� �Լ��� input, output "�Լ��� ������ �����ϴ�."


@Controller
public class M_LogIn_Controller{
	
	@RequestMapping("/login.do")
	public String handleRequest(HttpServletRequest request, MemberDAO dao, MemberVO vo) {
		//ActionForward forward = new ActionForward();

		// �ڵ��� ��ȭ�� ���̱� ���ؼ� == ���յ��� ���߱� ���� VO�� ����ϴ� ���̴�.
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao = new MemberDAO();
		vo = dao.getMember(vo);

		//forward.setRedirect(true);

		// ��
		ModelAndView mav = new ModelAndView();
		
		
		// �α��� ����	
		if(vo!=null){
			// session���/
			// ���� �α����� �Ǿ����� ���������� ���Ǵ����� ����
			HttpSession session = request.getSession();
			session.setAttribute("userData", vo);

			// �� ��μ���
			//mav.setViewName("redirect:main.do");
			
			return "redirect:main.do";

		}
		// �α��� ����
		else{
			// .jsp�� ���� �����ʾƵ�. do�� ���� ������ jsp�� ViewResolver�� �����ϰ� �ȴ�. 
			
			// �� ��μ��� // redirect : VR�� ������ �����ϰ� redirect
			mav.setViewName("redirect:index.jsp");		// DispatcherServlet -> HendlerMapping -> Control -> ViewResolver
			
			return "redirect:index.jsp";
		}


		
		//return mav;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();

		// �ڵ��� ��ȭ�� ���̱� ���ؼ� == ���յ��� ���߱� ���� VO�� ����ϴ� ���̴�.
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.getMember(vo);

		//forward.setRedirect(true);

		// ��
		ModelAndView mav = new ModelAndView();
		
		
		// �α��� ����	
		if(data!=null){
			// session���/
			// ���� �α����� �Ǿ����� ���������� ���Ǵ����� ����
			HttpSession session = request.getSession();
			session.setAttribute("userData", data);

			// �� ��μ���
			mav.setViewName("redirect:main.do"); 
			// ����
			//forward.setPath("main.do");

		}
		// �α��� ����
		else{
			// .jsp�� ���� �����ʾƵ�. do�� ���� ������ jsp�� ViewResolver�� �����ϰ� �ȴ�. 
			
			// �� ��μ��� // redirect : VR�� ������ �����ϰ� redirect
			mav.setViewName("redirect:index.jsp");		// DispatcherServlet -> HendlerMapping -> Control -> ViewResolver
			//forward.setPath("index.jsp");
		}


		//return forward;s
		return mav;
	}



}
*/