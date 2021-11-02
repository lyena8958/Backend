package controller.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.CommonExceptionHandler;
import common.InfoDataPaging;
import model.careerInfo.CareerInfoService;
import model.careerInfo.CareerInfoVO;

@Controller
public class Career_Controller {

	@Autowired
	private CareerInfoService careService;

	// [조회]
	@RequestMapping("/mazer-main/dist/getCareer.do")
	public String getCare(CareerInfoVO vo, ArrayList<CareerInfoVO> datas, Model model,
			@RequestParam(value="pnum", defaultValue="1", required=false)int cpnum, @RequestParam(value="type", required=false)String type, InfoDataPaging infoPaging){
		datas = (ArrayList<CareerInfoVO>) careService.getList(vo);

		// 페이징 처리 호출
		ArrayList<Object> models = infoPaging.paging(datas, vo, cpnum, type);

		if(models != null) {
			// AL 짝홀이 한묶음이므로, i 2씩증가
			for(int i = 0; i < models.size(); i+=2) {
				model.addAttribute((String)models.get(i), models.get(i+1));			
			}
		}
		else {
			//System.out.println("들림.");
			model.addAttribute("cmem", vo.getCmem());	
		}
		// 경로
		return "show_Career.jsp";
	}

	// [경력 추가]
	@RequestMapping("/mazer-main/dist/insertCare.do")
	public String insertCare(CareerInfoVO vo, Model model) {

		// 수행
		if(careService.insertCareer(vo)) {	
			//CareerInfoVO data = vo; // vo재활용	
			model.addAttribute("data", vo);

			// 경로
			return "getCareer.do?type=pass&cmem="+vo.getCmem();
		}

		// 수행오류
		return null;

	}

	// [경력 수정]
	@RequestMapping("/mazer-main/dist/updateCare.do")
	public String updateCare(CareerInfoVO vo, Model model, @RequestParam(value="pnum", required=true)int pnum) {
		System.out.println("updateCareer : "+vo);
		// 수행
		if(careService.updateCareer(vo)) {

			CareerInfoVO data = vo; // vo재활용
			data = careService.getData(vo); // 수행된 데이터 객체 전달받음

			model.addAttribute("data", data);

			// 경로
			return "getCareer.do?type=pass&cmem="+vo.getCmem()+"&pnum="+pnum;

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
	@RequestMapping("/mazer-main/dist/deleteCare.do")
	public String deleteCare(CareerInfoVO vo, @RequestParam(value="pnum")int pnum) {

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
		return "getCareer.do?type=check&cmem="+vo.getCmem()+"&pnum="+pnum;
		/*return "getCareer.do?type=check&cnum="+vo.getCnum()+"&pnum="+pnum;*/
	}






}
