package controller.action;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.member.MemberService;
import model.member.MemberVO;

@Controller
public class Member_Controller {

	@Autowired
	private MemberService memService;
	
	@RequestMapping("/mazer-main/dist/showMem.do")
	public String showMember(MemberVO vo, HttpServletResponse response, Model model) throws IOException {//, @ModelAttribute("data")MemberSet result
		System.out.println("showMem : "+vo);
		vo = memService.getData(vo);

		if(vo==null) {
			response.setContentType("text/html; charset=UTF-8"); 
			response.getWriter().println("<script>alert('존재하지 않는 사번입니다.'); history.go(-1);</script>");
			return null;
		}
		// UI시 date yyyy-mm-dd 나오도록 set
		vo.setBirthDate(vo.getBirthDate().substring(0, 10));
		vo.setStartDate(vo.getStartDate().substring(0, 10));

		model.addAttribute("data", vo);

		return "show_Mem.jsp";
		
	}
	
	@RequestMapping("/mazer-main/dist/insertMem.do")
	public String insertMember(@ModelAttribute("data")MemberVO vo, HttpServletResponse response) throws IOException {
	
		vo.setEndDate("9999-12-31");
		vo.setPath(null);
		System.out.println("showMem : "+vo);
		if(!memService.insertMember(vo)) {
			try {
				throw new Exception("Member insertMem");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>alert('정상적으로 채용 발령이 완료되었습니다.'); location.href='main.jsp';</script>");
		return null;
		// showMem을 통해 생성된 유저 화면 보여주기
		//return "main.jsp";
	}
	
	@RequestMapping("/mazer-main/dist/updateMem.do")
	public String updateMem(MemberVO vo, Model model) throws IOException {
		System.out.println("updateMem : "+vo);
		if(vo.getEndDate()==null) {
			vo.setEndDate("9999-12-31");
		}
		if(!memService.updateMember(vo)) {
			try {
				throw new Exception("Member updateMem");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		vo = memService.getData(vo);
		model.addAttribute("data", vo);
		return "showMem.do";
	}
	
	@RequestMapping("/mazer-main/dist/deleteMem.do")
	public String deleteMember(MemberVO vo, HttpServletResponse response) throws IOException {
		if(!memService.deleteMember(vo)) {
			try {
				throw new Exception("Member deleteMem");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>alert('해당 구성원의 삭제 처리가 완료되었습니다.'); location.href='main.jsp';</script>");

		
		//return "redirect:showMem.do";
		return null;
	}
	
	
}
