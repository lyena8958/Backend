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

	// [���� ��ȸ]
	@RequestMapping("/getCareer.do")
	public String getCare(HttpServletRequest request, @ModelAttribute("data")CareerInfoVO vo){

		vo = careService.getData(vo);

		// ���
		return "show_Career.jsp";
	}

	// [��� �߰�]
	@RequestMapping("/insertCare.do")
	public String insertCare(HttpServletRequest request, CareerInfoVO vo, Model model, CommonExceptionHandler excep) {

		// ����s
		if(careService.insertCareer(vo)) {	
			CareerInfoVO data = vo; // vo��Ȱ��
			data = careService.getData(vo); // ����� ������ ��ü ���޹���
			
			model.addAttribute("careerData", data);
			
			// ���
			return "show_Mem.jsp";

		}
		// �������
		else {
			//excep.handleException(e);
			return null;
		}
	}

	// [��� ����] --> ���� SPA�� ���� ����
	@RequestMapping("/updateCare.do")
	public String updateCare(HttpServletRequest request, CareerInfoVO vo, Model model) {

		// ����
		if(careService.updateCareer(vo)) {

			CareerInfoVO data = vo; // vo��Ȱ��
			data = careService.getData(vo); // ����� ������ ��ü ���޹���

			model.addAttribute("careerData", data);
			
			// ���
			return "show_Mem.jsp";

		}
		// �������
		else {
			try {
				throw new Exception("Career_updateCare ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}
	}

	// [��� ����] --> ���� SPA�� ���� ����
	@RequestMapping("/deleteCare.do")
	public String deleteCare(HttpServletRequest request, CareerInfoVO vo) {

		// �ݿ��� �ȵǾ��ٸ�
		if(!careService.deleteCareer(vo)) {
			try {
				throw new Exception("Career_deleteCare ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		// ���
		return "redirect:showMem.do";
	}






}
