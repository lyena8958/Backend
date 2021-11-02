package controller.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.InfoDataPaging;
import model.careerInfo.CareerInfoVO;
import model.licenseInfo.LicenseInfoService;
import model.licenseInfo.LicenseInfoVO;

@Controller
public class LicenseInfo_Controller {

	@Autowired
	private LicenseInfoService licenseService;

	// [get]
	@RequestMapping("/mazer-main/dist/getLicense.do")
	public String getLicense(LicenseInfoVO vo, ArrayList<LicenseInfoVO> datas, Model model,
			@RequestParam(value="pnum", defaultValue="1", required=false)int lpnum, @RequestParam(value="type", required=false)String type, InfoDataPaging infoPaging) {

		datas = (ArrayList<LicenseInfoVO>) licenseService.getList(vo);

		// 페이징 처리 호출
		ArrayList<Object> models = infoPaging.paging(datas, vo, lpnum, type);

		if(models != null) {
			// AL 짝홀이 한묶음이므로, i 2씩증가
			for(int i = 0; i < models.size(); i+=2) {
				model.addAttribute((String)models.get(i), models.get(i+1));			
			}
		}
		else {
			//System.out.println("들림.");
			model.addAttribute("lmem", vo.getLmem());
		}
		// 경로
		return "show_License.jsp";
	}

	// [자격증 추가]
	@RequestMapping("/mazer-main/dist/insertLicen.do")
	public String insertLicense(LicenseInfoVO vo, Model model) {
		
		// 수행
		if(licenseService.insertLicense(vo)) {
			model.addAttribute("data", vo);
			
			// 경로
			return "getLicense.do?type=pass&lmem="+vo.getLmem();
		}
		
		// 수행오류
		return null;

	
	}

	// [자격증 수정]
	@RequestMapping("/mazer-main/dist/updateLicen.do")
	public String updateLicense(LicenseInfoVO vo, Model model, @RequestParam(value="pnum")int pnum) {

		if(licenseService.updateLicense(vo)) {
			
			model.addAttribute("data", vo);
			return "getLicense.do?type=pass&lmem="+vo.getLmem()+"&pnum="+pnum;
		}

		try {
			throw new Exception("LicenseInfo updateLicense 오류발생");
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	// [자격증 삭제]
	@RequestMapping("/mazer-main/dist/deleteLicen.do")
	public String deleteLicense(LicenseInfoVO vo, Model model, @RequestParam(value="pnum")int pnum) {

		if(!licenseService.deleteLicense(vo)) {
			try {
				throw new Exception("LicenseInfo deleteLicense 오류발생");
			} catch (Exception e) {			
				e.printStackTrace();
			}
			return null;
		}


		return "getLicense.do?type=check&lmem="+vo.getLmem()+"&pnum="+pnum;
	}
}
