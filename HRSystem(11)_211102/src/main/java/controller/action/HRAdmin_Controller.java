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

	//[main페이지 이동] 
	@RequestMapping("/mazer-main/dist/main.do")
	public String mainMove(HttpRequest request, HRAdminVO vo) {

		return "main.jsp";
	}

	//[로그인]
	@RequestMapping(value="/mazer-main/dist/loginHRAdmin.do", method=RequestMethod.GET)
	public String loginMove() {
		return "login.jsp";

	}
	
	//[로그인]
	@RequestMapping(value="/mazer-main/dist/loginHRAdmin.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, HRAdminVO vo) throws IOException {
	//System.out.println("loginHRAdmin : " +vo);
		HRAdminVO data = vo;
		data = hrService.getData(vo); 
	//System.out.println("data : "+data);
		
		// 사번이 존재하지 않을 경우, index페이지 되돌아감
		if(data==null) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("<script>alert('존재하지 않는 정보입니다.'); location.href='loginHRAdmin.do';</script>");
			return null;
		}

		// 존재한다면, 세션 등록 및 메인 페이지 이동
		HttpSession session = request.getSession();
		session.setAttribute("userData", data);
		System.out.println("data : "+data);

		return "main.jsp";
		//"redirect:main.do"; (변경예정)
	}

	//[로그아웃]
	@RequestMapping("/mazer-main/dist/logOutHRAdmin.do")
	public String logOut(HttpSession session) {
		// 세션 종료 및 index 이동
		session.invalidate();
		return "index.jsp";
	}

	//[HRAdmin 추가] 
	@RequestMapping("/mazer-main/dist/insertHRAdmin.do")
	public String insertHRAdmin(HRAdminVO vo, HttpServletResponse response) throws IOException {
		System.out.println("들림 ~~ @@@! ");
		System.out.println(vo);
		response.setContentType("text/html; charset=UTF-8");
		// 생성이 안되었다면,
		if(!hrService.insertHRAdmin(vo)) {
			
			response.getWriter().println("<script>alert('등록이 불가합니다.'); location.href='signUp_HRAdmin.jsp'; </script>");
			return null;
		}

		response.getWriter().println("<script>alert('HR관리자 등록이 완료 되었습니다. 로그인 화면으로 이동합니다.'); location.href='loginHRAdmin.do'; </script>");
		//return "redirect:login.jsp";
		return null;
	}

	//[HRAdmin 수정]
	@RequestMapping("/mazer-main/dist/updateHRAdmin.do")
	public String updateHRAdmin(HRAdminVO vo, HttpServletResponse response) throws IOException {
		System.out.println("update VO : "+vo);
		// 수정이 안되었다면,
		if(!hrService.updateHRAdmin(vo)) {
			try {
				throw new Exception("HRAdmin_updateHRAdmin 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>alert('정보 변경이 완료되었습니다.'); location.href='main.jsp';</script>");
		// 되었다면 index 이동
		//return "main.jsp";
		return null;
	}

	//[HRAdmin 삭제] 
	@RequestMapping("/mazer-main/dist/deleteHRAdmin.do")
	public String deleteHRAdmin(HRAdminVO vo, HttpServletResponse response) throws IOException {
		System.out.println("deleteHRAdmin "+vo);
		// 수정이 안되었다면,
		if(!hrService.deleteHRAdmin(vo)) {
			try {
				throw new Exception("HRAdmin_deleteHRAdmin 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}							
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>alert('관리자 권한이 해제되었습니다. 첫 화면으로 이동됩니다.'); location.href='loginHRAdmin.do'; </script>");

		return null;
	}


	//[ONE]  -- 현 버전에서는 미사용
	@RequestMapping("/mazer-main/dist/getHRAdmin.do")
	public String getHRAdmin(HttpRequest request, HRAdminVO vo) {
		HRAdminVO data = vo; // vo재활용

		data = hrService.getData(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("hrAdminData", data);

		return "main.jsp";
	}

	//[LIST] -- 현 버전에서는 미사용
	@RequestMapping("/mazer-main/dist/getListHRAdmin.do")
	public String getListHRAdmin(HttpRequest request, HRAdminVO vo) {

		List<HRAdminVO> datas = hrService.getList(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("hrAdminList", datas);

		return "main.jsp";
	}


}
