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

// getController�� ���°� �ڵ鷯������ �ٽ��̴�.
// �ڵ鷯������ ����ó �������� ��û������ �ְ�, ��Ʈ�ѷ��� �޾ƿ´�.
public class HandlerMapping {
	// �÷��� �����ӿ�ũ Map�̿� (���ΰ�, � ��Ʈ���� ���ϴ��� ����)
	private Map<String, Controller> mappings;
	
	// ������ (�� �ʱ�ȭ��)
	// �ڵ鷯������ �����ڷ� �ʱ�ȭ�� �ϴ� �ݸ�,
	// ViewResolver�� Setter�� �ʱ�ȭ�Ѵ�.
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
		// ��û�� ���� �� ���� �ٲ�� �κ� -> Ư�� ����ó ������ �ȹٲ�� �ȴ�!
		// �Ź� �ڵ鷯 ������ �θ� ������ new�� �ϹǷ� �� ���߿� Spring Container���� ó���Ͽ�, �̱��� ������ ������ ����
		

		
	}
	
	// URL��û�� ���ڷ� �޾Ƽ�, Controller ��ü�� ��ȯ(������ �ٽ�, ���࿡ ��ü) -> ���������� ��Ʈ�� ������ ��ü�� ��ȯ���ְ� �ȴ�.
	public Controller getController(String path) {		
		return mappings.get(path);
	}
	
	
}
