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

	// [���� ��ȸ]
	@RequestMapping("/getSchool.do")
	public String getCare(HttpServletRequest request, @ModelAttribute("data")SchoolInfoVO vo, Model model){

		vo = schoolService.getData(vo);

		// ���
		return "show_School.jsp";
	}

	// [�з� �߰�]
	@RequestMapping("/insertSch.do")
	public String insertCare(HttpServletRequest request, SchoolInfoVO vo, Model model) {

		// ����Ͻ��޼��� ���� ���� ��
		if(!schoolService.insertSchool(vo)) {	

			try {
				throw new Exception("HRAdmin_updateHRAdmin ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		// ������ ������ �� ��� �̵�
		SchoolInfoVO data = vo; // vo��Ȱ��
		data = schoolService.getData(vo); // ����� ������ ��ü ���޹���

		model.addAttribute("careerData", data);

		// ���
		return "show_Mem.jsp";
	}

	// [�з� ����] --> ���� SPA�� ���� ����
	@RequestMapping("/updateSch.do")
	public String updateCare(HttpServletRequest request, SchoolInfoVO vo, Model model) {

		// ����
		if(!schoolService.updateSchool(vo)) {
			try {
				throw new Exception("SchoolInfo_update ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

	    SchoolInfoVO data = vo; // vo��Ȱ��
		data = schoolService.getData(vo); // ����� ������ ��ü ���޹���
		model.addAttribute("careerData", data);
		model.addAttribute("snum", vo.getSnum()); // ���� ����¡
		
		// ���
		return "show_School.jsp";

	}

	// [�з� ����]
	@RequestMapping("/deleteSch.do")
	public String deleteCare(HttpServletRequest request, SchoolInfoVO vo) {

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
		return "redirect:showMem.do";
	}




}
