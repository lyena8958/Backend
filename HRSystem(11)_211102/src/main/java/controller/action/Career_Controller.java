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

	// [��ȸ]
	@RequestMapping("/mazer-main/dist/getCareer.do")
	public String getCare(CareerInfoVO vo, ArrayList<CareerInfoVO> datas, Model model,
			@RequestParam(value="pnum", defaultValue="1", required=false)int cpnum, @RequestParam(value="type", required=false)String type, InfoDataPaging infoPaging){
		datas = (ArrayList<CareerInfoVO>) careService.getList(vo);

		// ����¡ ó�� ȣ��
		ArrayList<Object> models = infoPaging.paging(datas, vo, cpnum, type);

		if(models != null) {
			// AL ¦Ȧ�� �ѹ����̹Ƿ�, i 2������
			for(int i = 0; i < models.size(); i+=2) {
				model.addAttribute((String)models.get(i), models.get(i+1));			
			}
		}
		else {
			//System.out.println("�鸲.");
			model.addAttribute("cmem", vo.getCmem());	
		}
		// ���
		return "show_Career.jsp";
	}

	// [��� �߰�]
	@RequestMapping("/mazer-main/dist/insertCare.do")
	public String insertCare(CareerInfoVO vo, Model model) {

		// ����
		if(careService.insertCareer(vo)) {	
			//CareerInfoVO data = vo; // vo��Ȱ��	
			model.addAttribute("data", vo);

			// ���
			return "getCareer.do?type=pass&cmem="+vo.getCmem();
		}

		// �������
		return null;

	}

	// [��� ����]
	@RequestMapping("/mazer-main/dist/updateCare.do")
	public String updateCare(CareerInfoVO vo, Model model, @RequestParam(value="pnum", required=true)int pnum) {
		System.out.println("updateCareer : "+vo);
		// ����
		if(careService.updateCareer(vo)) {

			CareerInfoVO data = vo; // vo��Ȱ��
			data = careService.getData(vo); // ����� ������ ��ü ���޹���

			model.addAttribute("data", data);

			// ���
			return "getCareer.do?type=pass&cmem="+vo.getCmem()+"&pnum="+pnum;

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
	@RequestMapping("/mazer-main/dist/deleteCare.do")
	public String deleteCare(CareerInfoVO vo, @RequestParam(value="pnum")int pnum) {

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
		return "getCareer.do?type=check&cmem="+vo.getCmem()+"&pnum="+pnum;
		/*return "getCareer.do?type=check&cnum="+vo.getCnum()+"&pnum="+pnum;*/
	}






}
