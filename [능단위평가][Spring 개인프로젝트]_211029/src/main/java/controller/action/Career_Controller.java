package controller.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.CommonExceptionHandler;
import model.careerInfo.CareerInfoService;
import model.careerInfo.CareerInfoVO;

@Controller
public class Career_Controller {

	@Autowired
	private CareerInfoService careService;

	// [단일 조회]
	@RequestMapping("/getCareer.do")
	public String getCare(HttpServletRequest request, @ModelAttribute("data")CareerInfoVO vo){

		vo = careService.getData(vo);

		// 경로
		return "show_Career.jsp";
	}

	// [경력 추가]
	@RequestMapping("/insertCare.do")
	public String insertCare(HttpServletRequest request, CareerInfoVO vo, Model model, CommonExceptionHandler excep) {

		// 수행s
		if(careService.insertCareer(vo)) {	
			CareerInfoVO data = vo; // vo재활용
			data = careService.getData(vo); // 수행된 데이터 객체 전달받음
			
			model.addAttribute("careerData", data);
			
			// 경로
			return "show_Mem.jsp";

		}
		// 수행오류
		else {
			//excep.handleException(e);
			return null;
		}
	}

	// [경력 수정] --> 향후 SPA로 구현 예정
	@RequestMapping("/updateCare.do")
	public String updateCare(HttpServletRequest request, CareerInfoVO vo, Model model) {

		// 수행
		if(careService.updateCareer(vo)) {

			CareerInfoVO data = vo; // vo재활용
			data = careService.getData(vo); // 수행된 데이터 객체 전달받음

			model.addAttribute("careerData", data);
			
			// 경로
			return "show_Mem.jsp";

		}
		// 수행오류
		else {
			try {
				throw new Exception("Career_updateCare 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}
	}

	// [경력 삭제] --> 향후 SPA로 구현 예정
	@RequestMapping("/deleteCare.do")
	public String deleteCare(HttpServletRequest request, CareerInfoVO vo) {

		// 반영이 안되었다면
		if(!careService.deleteCareer(vo)) {
			try {
				throw new Exception("Career_deleteCare 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		// 경로
		return "redirect:showMem.do";
	}






}
