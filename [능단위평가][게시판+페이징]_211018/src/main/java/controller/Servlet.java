package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.board.B_DELETE_Acion;
import controller.board.B_INSERT_Acion;
import controller.board.B_Main_Acion;
import controller.board.B_SELETEONE_Acion;
import controller.board.B_UPDATE_Acion;
import controller.member.M_DELETE_Action;
import controller.member.M_INSERT_Action;
import controller.member.M_LogIn_Action;
import controller.member.M_LogOut_Action;
import controller.member.M_UPDATE_Action;

/**
 * Servlet implementation class DispatchServlet
 */
// control.jsp의 역할
// FrontController 
// 서블릿 클래스
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
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
		System.out.println("adasd");
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length()+1);
		System.out.println("action : "+action);
		ActionForward forward;
		
		if(action.equals("login.do")) {
			forward = new M_LogIn_Action().doAction(request, response);
		}
		else if(action.equals("logout.do")) {
			forward = new M_LogOut_Action().doAction(request, response);
		}
		else if(action.equals("deleteMem.do")) {
			forward = new M_DELETE_Action().doAction(request, response);
		}
		else if(action.equals("editMem.do")) {
			forward = new M_UPDATE_Action().doAction(request, response);
		}
		else if(action.equals("signUp.do")) {
			forward = new M_INSERT_Action().doAction(request, response);
		}
		else if(action.equals("main.do")) {
			forward = new B_Main_Acion().doAction(request, response);
		}
		else if(action.equals("getBoard.do")) {
			forward = new B_SELETEONE_Acion().doAction(request, response);
		}
		else if(action.equals("insertBoard.do")) {
			forward = new B_INSERT_Acion().doAction(request, response);
		}
		else if(action.equals("updateBoard.do")) {
			forward = new B_UPDATE_Acion().doAction(request, response);
		}
		else if(action.equals("deleteBoard.do")) {
			forward = new B_DELETE_Acion().doAction(request, response);
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
			
		}
		
		
	}
	
}
