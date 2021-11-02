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

	// [���� ��ȸ]
	@RequestMapping("/mazer-main/dist/getSchool.do")
	public String getSchool(SchoolInfoVO vo, ArrayList<SchoolInfoVO> datas, Model model,
			@RequestParam(value="pnum", defaultValue="1", required=false)int pnum, @RequestParam(value="type", required=false)String type, InfoDataPaging infoPaging) {
		System.out.println("?");
		datas = (ArrayList<SchoolInfoVO>) schoolService.getList(vo);

		// ����¡ ó�� ȣ��
		ArrayList<Object> models = infoPaging.paging(datas, vo, pnum, type);

		if(models != null) {
			// AL ¦Ȧ�� �ѹ����̹Ƿ�, i 2������
			for(int i = 0; i < models.size(); i+=2) {
				model.addAttribute((String)models.get(i), models.get(i+1));			
			}
		}
		else {
			//System.out.println("�鸲.");
			model.addAttribute("smem", vo.getSmem());	
		}

		// ���
		return "show_School.jsp";
	}

	// [�з� �߰�]
	@RequestMapping("/mazer-main/dist/insertSch.do")
	public String insertSch(SchoolInfoVO vo, Model model) {

		if(schoolService.insertSchool(vo)) {
			model.addAttribute("data", vo);

			// ���
			return "getSchool.do?type=pass&smem="+vo.getSmem();
		}

		// �������
		return null;

	}

	// [�з� ����] --> ���� SPA�� ���� ����
	@RequestMapping("/mazer-main/dist/updateSch.do")
	public String updateSch( SchoolInfoVO vo, Model model, @RequestParam(value="pnum")int pnum) {

		// ����
		if(!schoolService.updateSchool(vo)) {
			try {
				throw new Exception("SchoolInfo_update ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

		vo = schoolService.getData(vo);

		model.addAttribute("data", vo);

		// ���
		return "getSchool.do?type=pass&smem="+vo.getSmem()+"&pnum="+pnum;

	}

	// [�з� ����]
	@RequestMapping("/mazer-main/dist/deleteSch.do")
	public String deleteSch(HttpServletRequest request, SchoolInfoVO vo,  @RequestParam(value="pnum")int pnum) {

		// �ݿ��� �ȵǾ��ٸ�
		if(!schoolService.deleteSchool(vo)) {
			try {
				throw new Exception("SchoolInfo_delete ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// ���
		return "getSchool.do?type=check&smem="+vo.getSmem()+"&pnum="+pnum;
	}




}
