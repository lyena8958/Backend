package controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.member.MemberService;
import model.member.MemberSet;
import model.member.MemberVO;

@Controller
public class Member_Controller {

	@Autowired
	private MemberService memService;
	
	@RequestMapping("/showMem.do")
	public String showMember(MemberVO vo, @ModelAttribute("result")MemberSet result) {
		
		result = memService.getSetList(vo);
		
		return "show_Mem.jsp";
	}
	
	@RequestMapping("/insertMem.do")
	public String insertMember(MemberVO vo) {
		
		if(!memService.insertMember(vo)) {
			try {
				throw new Exception("Member insertMem");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// 생성된 객체를 받아 
		memService.getData(vo);
		
		// showMem을 통해 생성된 유저 화면 보여주기
		return "redirect:showMem.do";
	}
	
	@RequestMapping("/updateMem.do")
	public String updateMem(MemberVO vo, Model model) {
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
		
		return "redirect:showMem.do";
	}
	
	@RequestMapping("/deleteMem.do")
	public String deleteMember(MemberVO vo) {
		return "aa";
	}
	
	
}
