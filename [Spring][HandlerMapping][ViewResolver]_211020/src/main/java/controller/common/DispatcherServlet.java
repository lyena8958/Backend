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
// control.jsp의 역할
// FrontController 
// 서블릿 클래스
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// heandlerMapping, viewResolver은 최초에 단 한번만 생성되면 좋다. 
	// 싱글톤 패턴을 유지하기 위해 "한 번만" 객체화를 해준다.-> init 
    private HandlerMapping heandlerMapping;
    private ViewResolver viewResolver;
    
	// 싱글톤 패턴 유지하기 위한, 최초 1회 객체화 메서드
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
		
		// 핸들러맵핑에게 요청정보를 주고, 컨트롤러를 받아온다.
		//  └ lookup == HM에게 action값을 전달, Controller 객체를 반환받는다!
		// lookup(ex JNDI) -> 검색, 탐색  == 객체를 찾아다니는 행위, lookup하다 == 객체
		// 다형성 
		Controller controller = heandlerMapping.getController(action); // 로그인 컨트롤러, 로그아웃 컨트롤러 등 객체류가 반환 된다.
		
		//controller.execute(request, response); // 다형성 실현
   		  // 동적 바인딩  고양이, 강아지에게 짖어봐라고 했는데 대답이다른 것(실질적으로 수행하는 주체가 다르기 때문에 동적바인딩 이라고 한다.) 
		
		// 클라이언트의 요청을 실직적으로 수행하는 controller 객체!
		// 그 결과로 "경로"를 리턴
		String view = controller.execute(request, response);
		
		// view안에 .do가 포함되어있니?
		if(!view.contains(".do")) { 
			// jsp로 처리한다는 것을 의미 == getView
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
		else {// 이외 요청
			// 1-무조건 index.jsp으로 이동
			// 2-에러페이지
			System.out.println("들림!");
			forward= new ActionForward();
			forward.setPath("index.jsp");
			forward.setRedirect(true);
			return;
		}
		
		if(forward == null) {
			return;
		}
		
		// sendredirect라면,
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else { // forward라면,
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			
		}*/
		
		
	}
	
}
