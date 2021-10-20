package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * Servlet implementation class DispatchServlet
 */
// control.jsp�� ����
// FrontController 
// ���� Ŭ����
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// heandlerMapping, viewResolver�� ���ʿ� �� �ѹ��� �����Ǹ� ����. 
	// �̱��� ������ �����ϱ� ���� "�� ����" ��üȭ�� ���ش�.-> init 
    private HandlerMapping heandlerMapping;
    private ViewResolver viewResolver;
    
	// �̱��� ���� �����ϱ� ����, ���� 1ȸ ��üȭ �޼���
	public void init() {
		heandlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length()+1);
		
//ActionForward forward;

 // DS->HM->C->VR
		
		// �ڵ鷯���ο��� ��û������ �ְ�, ��Ʈ�ѷ��� �޾ƿ´�.
		//  �� lookup == HM���� action���� ����, Controller ��ü�� ��ȯ�޴´�!
		// lookup(ex JNDI) -> �˻�, Ž��  == ��ü�� ã�ƴٴϴ� ����, lookup�ϴ� == ��ü
		// ������ 
		Controller controller = heandlerMapping.getController(action); // �α��� ��Ʈ�ѷ�, �α׾ƿ� ��Ʈ�ѷ� �� ��ü���� ��ȯ �ȴ�.
		
		//controller.execute(request, response); // ������ ����
   		  // ���� ���ε�  �����, ���������� ¢������ �ߴµ� ����̴ٸ� ��(���������� �����ϴ� ��ü�� �ٸ��� ������ �������ε� �̶�� �Ѵ�.) 
		
		// Ŭ���̾�Ʈ�� ��û�� ���������� �����ϴ� controller ��ü!
		// �� ����� "���"�� ����
		String view = controller.execute(request, response);
		
		// view�ȿ� .do�� ���ԵǾ��ִ�?
		if(!view.contains(".do")) { 
			// jsp�� ó���Ѵٴ� ���� �ǹ� == getView
			view = viewResolver.getView(view);
		}
		
		response.sendRedirect(view);
		
		/*if(action.equals("login.do")) { **
			forward = new M_LogIn_Controller().doAction(request, response);
		}
		else if(action.equals("logout.do")) { **
			forward = new M_LogOut_Controller().doAction(request, response);
		}
		else if(action.equals("deleteMem.do")) {
			forward = new M_DELETE_Controller().doAction(request, response);
		}
		else if(action.equals("editMem.do")) {
			forward = new M_UPDATE_Controller().doAction(request, response);
		}
		else if(action.equals("signUp.do")) {
			forward = new M_INSERT_Controller().doAction(request, response);
		}
		else if(action.equals("main.do")) {
			forward = new B_Main_Controller().doAction(request, response);
		}
		else if(action.equals("getBoard.do")) { **
			forward = new B_SELETEONE_Controller().doAction(request, response);
		}
		else if(action.equals("insertBoard.do")) {
			forward = new B_INSERT_Controller().doAction(request, response);
		}
		else if(action.equals("updateBoard.do")) {
			forward = new B_UPDATE_Controller().doAction(request, response);
		}
		else if(action.equals("deleteBoard.do")) {
			forward = new B_DELETE_Controller().doAction(request, response);
		}
		else {// �̿� ��û
			// 1-������ index.jsp���� �̵�
			// 2-����������
			System.out.println("�鸲!");
			forward= new ActionForward();
			forward.setPath("index.jsp");
			forward.setRedirect(true);
			return;
		}
		
		if(forward == null) {
			return;
		}
		
		// sendredirect���,
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else { // forward���,
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			
		}*/
		
		
	}
	
}
