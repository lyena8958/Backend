package controller.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import model.hradmin.HRAdminVO;
import model.member.MemberService;
import model.member.MemberVO;

@Controller
public class Member_Controller {
	public Member_Controller(){
		
		// 파일 저장경로
		path = "C:\\YN_0910\\workspace\\SoloProject_211020\\src\\main\\webapp\\mazer-main\\dist\\imgMem\\";
	}
	@Autowired
	private MemberService memService;
	
	private String path; 

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
		
		System.out.println("showMem : "+vo);
		if(!memService.insertMember(vo)) {
			try {
				throw new Exception("Member insertMem");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		if(path!=null) {
			MultipartFile fileupload = vo.getPath();
			if(!fileupload.isEmpty()) {
				String fileName = fileupload.getOriginalFilename();
				System.out.println("파일이름 : "+fileName);
				fileupload.transferTo(new File(path+vo.getMnum()));
			}
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
	public String deleteMember(MemberVO vo, HttpServletResponse response, HttpSession session) throws IOException {
		if(!memService.deleteMember(vo)) {
			try {
				throw new Exception("Member deleteMem");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		HRAdminVO admin = (HRAdminVO)session.getAttribute("userData");
		// 삭제된 데이터와 같다면, 로그아웃처리
		if(admin.getHmem()==vo.getMnum()) {
			
			return "logOutHRAdmin.do";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>alert('해당 구성원의 삭제 처리가 완료되었습니다.'); location.href='main.jsp';</script>");

		
		//return "redirect:showMem.do";
		return null;
	}
	
	
	////////////////////////////////////////////////SPA////////////////////////////////////////////////
	
	// insertPost.jsp
	@RequestMapping("/mazer-main/dist/getMem.do")
	public String getMem(MemberVO vo, HttpServletResponse response, PrintWriter out) throws IOException {//, @ModelAttribute("data")MemberSet results
		
		System.out.println("getMem : "+vo);
		
		vo = memService.getData(vo);
		
		System.out.println("getMem1 "+vo);
		
		if(vo!=null) {
			System.out.println("들림");
			
			//response.setContentType("text/html; charset=euc-kr");
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			
			//out.println("루피"); 
			out.println("[{\"name\":\"" + vo.getmName()+"\"}]");
			//out.println(vo.getmName());
			
		}
		return null;
		
	}
	
}
