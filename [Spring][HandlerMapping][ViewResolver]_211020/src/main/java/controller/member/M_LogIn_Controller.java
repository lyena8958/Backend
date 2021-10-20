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

		// �ڵ��� ��ȭ�� ���̱� ���ؼ� == ���յ��� ���߱� ���� VO�� ����ϴ� ���̴�.
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.getMember(vo);

//forward.setRedirect(true);

		// �α��� ����	
		if(data!=null){
			// session���
			HttpSession session = request.getSession();
			session.setAttribute("userData", data);
			
			return "main.do";
			// ����
//forward.setPath("main.do");
			
		}
		// �α��� ����
		else{
			// .jsp�� ���� �����ʾƵ�. do�� ���� ������ jsp�� ViewResolver�� �����ϰ� �ȴ�. 
			return "index";		// DispatcherServlet -> HendlerMapping -> Control -> ViewResolver
//forward.setPath("index.jsp");
		}
		
		
//return forward;
	}

}
