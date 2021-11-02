package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;



public class InfoDataPaging {
	
	public InfoDataPaging() {
		models = new ArrayList<Object>();
	}
	
	
	
	// ��ȯ�� datas
	private ArrayList<Object> models;
	
	public ArrayList<Object> paging(List datas, Object vo, int pnum, String type) {
		models.clear(); // �̱��� ���� ������ ���� clear

		// vo ����
		vo = (datas==null || pnum<1) ? null : datas.get(pnum-1);

		if(vo==null) {	
			return null;
		}
		
		// ��û�� Ÿ���� �ִٸ�
		if(type!=null && type.equals("pass")) {
			vo = datas.get(datas.size()-1); // ������������ ��ȯ
			pnum = datas.size(); // 54�� lastó���� ����
		}

		models.add("data");
		models.add(vo);

	
	// [����¡ ����]
		if(pnum==1&&datas.size()==1) { // �����Ͱ� �ϳ��� ������ ���,
			System.out.println("�鸲1");
			models.add("first");
			models.add(true);
			models.add("last");
			models.add(true);
		}

		else if(pnum==1) { // ù ��° �������� ���,
		System.out.println("�鸲2");
			// ù ���������
			//models.add(model.addAttribute("first", true));
			models.add("first");
			models.add(true);

		}
		else if(pnum==datas.size()) { // ������ �������� ���,
		System.out.println("�鸲3");
			// ������ ���������
			//models.add(model.addAttribute("last", true));
			models.add("last");
			models.add(true);

		}

		models.add("pnum");
		models.add(pnum);		

		return models;
	}
}


