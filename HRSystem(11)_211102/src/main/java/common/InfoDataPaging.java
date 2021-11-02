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
	
	
	
	// 반환할 datas
	private ArrayList<Object> models;
	
	public ArrayList<Object> paging(List datas, Object vo, int pnum, String type) {
		models.clear(); // 싱글톤 패턴 유지를 위한 clear

		// vo 설정
		vo = (datas==null || pnum<1) ? null : datas.get(pnum-1);

		if(vo==null) {	
			return null;
		}
		
		// 요청온 타입이 있다면
		if(type!=null && type.equals("pass")) {
			vo = datas.get(datas.size()-1); // 마지막데이터 반환
			pnum = datas.size(); // 54번 last처리를 위함
		}

		models.add("data");
		models.add(vo);

	
	// [페이징 설정]
		if(pnum==1&&datas.size()==1) { // 데이터가 하나만 존재한 경우,
			System.out.println("들림1");
			models.add("first");
			models.add(true);
			models.add("last");
			models.add(true);
		}

		else if(pnum==1) { // 첫 번째 페이지인 경우,
		System.out.println("들림2");
			// 첫 페이지라면
			//models.add(model.addAttribute("first", true));
			models.add("first");
			models.add(true);

		}
		else if(pnum==datas.size()) { // 마지막 페이지인 경우,
		System.out.println("들림3");
			// 마지막 페이지라면
			//models.add(model.addAttribute("last", true));
			models.add("last");
			models.add(true);

		}

		models.add("pnum");
		models.add(pnum);		

		return models;
	}
}


