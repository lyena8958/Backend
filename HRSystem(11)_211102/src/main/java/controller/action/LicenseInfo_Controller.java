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

		// ����¡ ó�� ȣ��
		ArrayList<Object> models = infoPaging.paging(datas, vo, lpnum, type);

		if(models != null) {
			// AL ¦Ȧ�� �ѹ����̹Ƿ�, i 2������
			for(int i = 0; i < models.size(); i+=2) {
				model.addAttribute((String)models.get(i), models.get(i+1));			
			}
		}
		else {
			//System.out.println("�鸲.");
			model.addAttribute("lmem", vo.getLmem());
		}
		// ���
		return "show_License.jsp";
	}

	// [�ڰ��� �߰�]
	@RequestMapping("/mazer-main/dist/insertLicen.do")
	public String insertLicense(LicenseInfoVO vo, Model model) {
		
		// ����
		if(licenseService.insertLicense(vo)) {
			model.addAttribute("data", vo);
			
			// ���
			return "getLicense.do?type=pass&lmem="+vo.getLmem();
		}
		
		// �������
		return null;

	
	}

	// [�ڰ��� ����]
	@RequestMapping("/mazer-main/dist/updateLicen.do")
	public String updateLicense(LicenseInfoVO vo, Model model, @RequestParam(value="pnum")int pnum) {

		if(licenseService.updateLicense(vo)) {
			
			model.addAttribute("data", vo);
			return "getLicense.do?type=pass&lmem="+vo.getLmem()+"&pnum="+pnum;
		}

		try {
			throw new Exception("LicenseInfo updateLicense �����߻�");
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	// [�ڰ��� ����]
	@RequestMapping("/mazer-main/dist/deleteLicen.do")
	public String deleteLicense(LicenseInfoVO vo, Model model, @RequestParam(value="pnum")int pnum) {

		if(!licenseService.deleteLicense(vo)) {
			try {
				throw new Exception("LicenseInfo deleteLicense �����߻�");
			} catch (Exception e) {			
				e.printStackTrace();
			}
			return null;
		}


		return "getLicense.do?type=check&lmem="+vo.getLmem()+"&pnum="+pnum;
	}
}
