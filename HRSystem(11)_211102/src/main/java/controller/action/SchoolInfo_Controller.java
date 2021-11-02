package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.InfoDataPaging;
import model.schoolInfo.SchoolInfoService;
import model.schoolInfo.SchoolInfoVO;

@Controller
public class SchoolInfo_Controller {
	@Autowired
	private SchoolInfoService schoolService;

	// [단일 조회]
	@RequestMapping("/mazer-main/dist/getSchool.do")
	public String getSchool(SchoolInfoVO vo, ArrayList<SchoolInfoVO> datas, Model model,
			@RequestParam(value="pnum", defaultValue="1", required=false)int pnum, @RequestParam(value="type", required=false)String type, InfoDataPaging infoPaging) {
		System.out.println("?");
		datas = (ArrayList<SchoolInfoVO>) schoolService.getList(vo);

		// 페이징 처리 호출
		ArrayList<Object> models = infoPaging.paging(datas, vo, pnum, type);

		if(models != null) {
			// AL 짝홀이 한묶음이므로, i 2씩증가
			for(int i = 0; i < models.size(); i+=2) {
				model.addAttribute((String)models.get(i), models.get(i+1));			
			}
		}
		else {
			//System.out.println("들림.");
			model.addAttribute("smem", vo.getSmem());	
		}

		// 경로
		return "show_School.jsp";
	}

	// [학력 추가]
	@RequestMapping("/mazer-main/dist/insertSch.do")
	public String insertSch(SchoolInfoVO vo, Model model) {

		if(schoolService.insertSchool(vo)) {
			model.addAttribute("data", vo);

			// 경로
			return "getSchool.do?type=pass&smem="+vo.getSmem();
		}

		// 수행오류
		return null;

	}

	// [학력 수정] --> 향후 SPA로 구현 예정
	@RequestMapping("/mazer-main/dist/updateSch.do")
	public String updateSch( SchoolInfoVO vo, Model model, @RequestParam(value="pnum")int pnum) {

		// 수행
		if(!schoolService.updateSchool(vo)) {
			try {
				throw new Exception("SchoolInfo_update 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

		vo = schoolService.getData(vo);

		model.addAttribute("data", vo);

		// 경로
		return "getSchool.do?type=pass&smem="+vo.getSmem()+"&pnum="+pnum;

	}

	// [학력 삭제]
	@RequestMapping("/mazer-main/dist/deleteSch.do")
	public String deleteSch(HttpServletRequest request, SchoolInfoVO vo,  @RequestParam(value="pnum")int pnum) {

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
		return "getSchool.do?type=check&smem="+vo.getSmem()+"&pnum="+pnum;
	}




}
