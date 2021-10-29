package controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.licenseInfo.LicenseInfoService;
import model.licenseInfo.LicenseInfoVO;

@Controller
public class LicenseInfo_Controller {

	@Autowired
	private LicenseInfoService licenseService;

	// [get]
	@RequestMapping("/getLicense.do")
	public String getLicense(@ModelAttribute("data")LicenseInfoVO vo) {

		vo = licenseService.getData(vo);

		return "show_License.jsp";
	}

	// [insert]
	@RequestMapping("/insertLicen.do")
	public String insertLicense(LicenseInfoVO vo, Model model) {

		if(!licenseService.insertLicense(vo)) {
			try {
				throw new Exception("LicenseInfo getLicense 오류발생");
			} catch (Exception e) {			
				e.printStackTrace();
			}
			return null;
		}

		vo = licenseService.getData(vo);

		model.addAttribute("data", vo);


		return "show_License.jsp";
	}

	// [update]
	@RequestMapping("/updateLicen.do")
	public String updateLicense(LicenseInfoVO vo, Model model) {

		if(!licenseService.updateLicense(vo)) {
			try {
				throw new Exception("LicenseInfo updateLicense 오류발생");
			} catch (Exception e) {			
				e.printStackTrace();
			}
			return null;
		}

		vo = licenseService.getData(vo);

		model.addAttribute("data", vo);


		return "show_License.jsp";
	}
	// [delete]
	@RequestMapping("/deleteLicen.do")
	public String deleteLicense(LicenseInfoVO vo, Model model) {

		if(!licenseService.deleteLicense(vo)) {
			try {
				throw new Exception("LicenseInfo deleteLicense 오류발생");
			} catch (Exception e) {			
				e.printStackTrace();
			}
			return null;
		}


		return "redirect:showMem.do";
	}
}
