package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.hradmin.HRAdminService;
import model.hradmin.HRAdminVO;

@Controller
public class HRAdmin_Controller {

	@Autowired
	private HRAdminService hrService;

	//[main������ �̵�] 
	@RequestMapping("/mazer-main/dist/main.do")
	public String mainMove(HttpRequest request, HRAdminVO vo) {

		return "main.jsp";
	}

	//[�α���]
	@RequestMapping(value="/mazer-main/dist/loginHRAdmin.do", method=RequestMethod.GET)
	public String loginMove() {
		return "login.jsp";

	}
	
	//[�α���]
	@RequestMapping(value="/mazer-main/dist/loginHRAdmin.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, HRAdminVO vo) throws IOException {
	//System.out.println("loginHRAdmin : " +vo);
		HRAdminVO data = vo;
		data = hrService.getData(vo); 
	//System.out.println("data : "+data);
		
		// ����� �������� ���� ���, index������ �ǵ��ư�
		if(data==null) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("<script>alert('�������� �ʴ� �����Դϴ�.'); location.href='loginHRAdmin.do';</script>");
			return null;
		}

		// �����Ѵٸ�, ���� ��� �� ���� ������ �̵�
		HttpSession session = request.getSession();
		session.setAttribute("userData", data);
		System.out.println("data : "+data);

		return "main.jsp";
		//"redirect:main.do"; (���濹��)
	}

	//[�α׾ƿ�]
	@RequestMapping("/mazer-main/dist/logOutHRAdmin.do")
	public String logOut(HttpSession session) {
		// ���� ���� �� index �̵�
		session.invalidate();
		return "index.jsp";
	}

	//[HRAdmin �߰�] 
	@RequestMapping("/mazer-main/dist/insertHRAdmin.do")
	public String insertHRAdmin(HRAdminVO vo, HttpServletResponse response) throws IOException {
		System.out.println("�鸲 ~~ @@@! ");
		System.out.println(vo);
		response.setContentType("text/html; charset=UTF-8");
		// ������ �ȵǾ��ٸ�,
		if(!hrService.insertHRAdmin(vo)) {
			
			response.getWriter().println("<script>alert('����� �Ұ��մϴ�.'); location.href='signUp_HRAdmin.jsp'; </script>");
			return null;
		}

		response.getWriter().println("<script>alert('HR������ ����� �Ϸ� �Ǿ����ϴ�. �α��� ȭ������ �̵��մϴ�.'); location.href='loginHRAdmin.do'; </script>");
		//return "redirect:login.jsp";
		return null;
	}

	//[HRAdmin ����]
	@RequestMapping("/mazer-main/dist/updateHRAdmin.do")
	public String updateHRAdmin(HRAdminVO vo, HttpServletResponse response) throws IOException {
		System.out.println("update VO : "+vo);
		// ������ �ȵǾ��ٸ�,
		if(!hrService.updateHRAdmin(vo)) {
			try {
				throw new Exception("HRAdmin_updateHRAdmin ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>alert('���� ������ �Ϸ�Ǿ����ϴ�.'); location.href='main.jsp';</script>");
		// �Ǿ��ٸ� index �̵�
		//return "main.jsp";
		return null;
	}

	//[HRAdmin ����] 
	@RequestMapping("/mazer-main/dist/deleteHRAdmin.do")
	public String deleteHRAdmin(HRAdminVO vo, HttpServletResponse response) throws IOException {
		System.out.println("deleteHRAdmin "+vo);
		// ������ �ȵǾ��ٸ�,
		if(!hrService.deleteHRAdmin(vo)) {
			try {
				throw new Exception("HRAdmin_deleteHRAdmin ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}							
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>alert('������ ������ �����Ǿ����ϴ�. ù ȭ������ �̵��˴ϴ�.'); location.href='loginHRAdmin.do'; </script>");

		return null;
	}


	//[ONE]  -- �� ���������� �̻��
	@RequestMapping("/mazer-main/dist/getHRAdmin.do")
	public String getHRAdmin(HttpRequest request, HRAdminVO vo) {
		HRAdminVO data = vo; // vo��Ȱ��

		data = hrService.getData(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("hrAdminData", data);

		return "main.jsp";
	}

	//[LIST] -- �� ���������� �̻��
	@RequestMapping("/mazer-main/dist/getListHRAdmin.do")
	public String getListHRAdmin(HttpRequest request, HRAdminVO vo) {

		List<HRAdminVO> datas = hrService.getList(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("hrAdminList", datas);

		return "main.jsp";
	}


}
