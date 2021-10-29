package controller.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.CommonExceptionHandler;
import model.schoolInfo.SchoolInfoService;
import model.schoolInfo.SchoolInfoVO;

@Controller
public class SchoolInfo_Controller {
	@Autowired
	private SchoolInfoService schoolService;

	// [단일 조회]
	@RequestMapping("/getSchool.do")
	public String getCare(HttpServletRequest request, @ModelAttribute("data")SchoolInfoVO vo, Model model){

		vo = schoolService.getData(vo);

		// 경로
		return "show_School.jsp";
	}

	// [학력 추가]
	@RequestMapping("/insertSch.do")
	public String insertCare(HttpServletRequest request, SchoolInfoVO vo, Model model) {

		// 비즈니스메서드 수행 오류 시
		if(!schoolService.insertSchool(vo)) {	

			try {
				throw new Exception("HRAdmin_updateHRAdmin 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		// 성공시 데이터 및 경로 이동
		SchoolInfoVO data = vo; // vo재활용
		data = schoolService.getData(vo); // 수행된 데이터 객체 전달받음

		model.addAttribute("careerData", data);

		// 경로
		return "show_Mem.jsp";
	}

	// [학력 수정] --> 향후 SPA로 구현 예정
	@RequestMapping("/updateSch.do")
	public String updateCare(HttpServletRequest request, SchoolInfoVO vo, Model model) {

		// 수행
		if(!schoolService.updateSchool(vo)) {
			try {
				throw new Exception("SchoolInfo_update 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

	    SchoolInfoVO data = vo; // vo재활용
		data = schoolService.getData(vo); // 수행된 데이터 객체 전달받음
		model.addAttribute("careerData", data);
		model.addAttribute("snum", vo.getSnum()); // 단일 페이징
		
		// 경로
		return "show_School.jsp";

	}

	// [학력 삭제]
	@RequestMapping("/deleteSch.do")
	public String deleteCare(HttpServletRequest request, SchoolInfoVO vo) {

		// 반영이 안되었다면
		if(!schoolService.deleteSchool(vo)) {
			try {
				throw new Exception("SchoolInfo_delete 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// 경로
		return "redirect:showMem.do";
	}




}
