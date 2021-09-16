package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//control.jsp를 사용하다가
//어차피 sevlet를 바뀌는데 파일 용량이 너무 커서
//하나의 서블릿에서 요청을 class로 수행할 것임
//control class에서 인자 반환의 기준 틀을 만들기 위해 --> 인터페이스를 만들어보자! 

// 요청방식 흐름
/*
 *  V - 					- C - V
 *  V -						- C - V
 *  V -    FrontController  - C - V
 *  V -						- C - V
 *  V -  					- C - V
 * */

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController") // 사용자의 모든 요청(V) 잡아줌 --- 요청을 가로 채야한다.
//@WebServlet("*.do") // 사용자의 모든 요청(V) 잡아줌 --- 요청을 가로 채야한다.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
		//System.out.println("확인");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	//action분리를 위한 메서드 추가
	// requst, response를 받아야 하기 때문에 기존 deGet, doPost 형태와 같아야한다.
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 1. 사용자의 요청을 분석하는 메서드 
		//   └String action = request.getParameter("action");
		
		String uri = request.getRequestURI(); // 문자로 반환
		//System.out.println("uri : "+uri); // /day56_0916_FrontController/main.do
		
		String cp = request.getContextPath();
		//System.out.println("cp : "+cp); // /day56_0916_FrontController
		
		String action = uri.substring(cp.length());
		//System.out.println("action : "+action); // /main.do 
		
		//페이지 이동방식, 경로 class
		ActionForward forward = null;
		
		
		// 2. control을 매핑(연결)하는 역할  
		//   └action.equals 역할
		if(action.equals("/main.do")) {
			forward = new MainAction().execute(request, response);
		}
		else {//위의 forward가 실행되지않았다면 == 오류
			System.out.println("오류");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("NewFile1.jsp"); // error.jsp
		}
		
		
		// 3. 사용자에게 처리된 데이터를 출력(V전달) --- 결과를 보여줄 때에 action클래스에서 request가 유지되어야한다 ==dispatcher
		// true라면 redirect
		if(forward.isRedirect()) {
			// 다음 요청이 되면 request가 다바뀌지만
			response.sendRedirect(forward.getPath());
		}
		else {//false라면 forward
			///// pageContext.forward("main.jsp"); 를 쓰지않고 디스패처 활용
			
																	// 인자는 최종경로를 입력해야한다.
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			// 디스패처 - 클라이언트(브라우저,사용자) 들어온 요청을 처리하고, 다시 결과를 돌려보내주는 역할
			//	└ 컨트롤러 역할
			
			//pageContext 대신에 dispatcher를 사용하는 이유가뭔가욤??
			// └ 여러개의 컨트롤러를 겹치니 (길게이어져야한다.) 헤더를
			
			//action클래스에서 → frontcontrol 아동하면서 데이터를 받아내는데 그것을 dispatcher에서하는군요


		}
		
	}

}
