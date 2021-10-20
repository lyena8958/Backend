package controller.common;

import java.util.HashMap;
import java.util.Map;

import controller.board.B_DELETE_Controller;
import controller.board.B_INSERT_Controller;
import controller.board.B_Main_Controller;
import controller.board.B_SELETEONE_Controller;
import controller.board.B_UPDATE_Controller;
import controller.member.M_DELETE_Controller;
import controller.member.M_INSERT_Controller;
import controller.member.M_LogIn_Controller;
import controller.member.M_LogOut_Controller;
import controller.member.M_UPDATE_Controller;

// getController를 쓰는게 핸들러맵핑의 핵심이다.
// 핸들러맵핑은 디스패처 서블릿에게 요청정보를 주고, 컨트롤러를 받아온다.
public class HandlerMapping {
	// 컬렉션 프레임워크 Map이용 (어떤경로가, 어떤 컨트롤을 행하는지 정의)
	private Map<String, Controller> mappings;
	
	// 생성자 (로 초기화함)
	// 핸들러맵핑은 생성자로 초기화로 하는 반면,
	// ViewResolver는 Setter로 초기화한다.
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("login.do", new M_LogIn_Controller());
		mappings.put("logout.do", new M_LogOut_Controller());
		mappings.put("deleteMem.do", new M_DELETE_Controller());
		mappings.put("editMem.do", new M_UPDATE_Controller());
		mappings.put("signUp.do", new M_INSERT_Controller());
		mappings.put("main.do", new B_Main_Controller());
		mappings.put("getBoard.do", new B_SELETEONE_Controller());
		mappings.put("deleteBoard.do", new B_DELETE_Controller());
		mappings.put("updateBoard.do", new B_UPDATE_Controller());
		mappings.put("insertBoard.do", new B_INSERT_Controller());
		// 요청이 들어올 때 마다 바뀌는 부분 -> 특히 디스패처 서블릿이 안바뀌게 된다!
		// 매번 핸들러 맵핑을 부를 때마다 new를 하므로 → 나중에 Spring Container에게 처리하여, 싱글톤 패턴을 유지할 예정
		

		
	}
	
	// URL요청을 인자로 받아서, Controller 객체를 반환(수행의 핵심, 수행에 주체) -> 실질적으로 컨트롤 수행의 객체를 반환해주게 된다.
	public Controller getController(String path) {		
		return mappings.get(path);
	}
	
	
}
