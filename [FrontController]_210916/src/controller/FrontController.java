package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//control.jsp�� ����ϴٰ�
//������ sevlet�� �ٲ�µ� ���� �뷮�� �ʹ� Ŀ��
//�ϳ��� �������� ��û�� class�� ������ ����
//control class���� ���� ��ȯ�� ���� Ʋ�� ����� ���� --> �������̽��� ������! 

// ��û��� �帧
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
@WebServlet("/FrontController") // ������� ��� ��û(V) ����� --- ��û�� ���� ä���Ѵ�.
//@WebServlet("*.do") // ������� ��� ��û(V) ����� --- ��û�� ���� ä���Ѵ�.
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
		//System.out.println("Ȯ��");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	//action�и��� ���� �޼��� �߰�
	// requst, response�� �޾ƾ� �ϱ� ������ ���� deGet, doPost ���¿� ���ƾ��Ѵ�.
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 1. ������� ��û�� �м��ϴ� �޼��� 
		//   ��String action = request.getParameter("action");
		
		String uri = request.getRequestURI(); // ���ڷ� ��ȯ
		//System.out.println("uri : "+uri); // /day56_0916_FrontController/main.do
		
		String cp = request.getContextPath();
		//System.out.println("cp : "+cp); // /day56_0916_FrontController
		
		String action = uri.substring(cp.length());
		//System.out.println("action : "+action); // /main.do 
		
		//������ �̵����, ��� class
		ActionForward forward = null;
		
		
		// 2. control�� ����(����)�ϴ� ����  
		//   ��action.equals ����
		if(action.equals("/main.do")) {
			forward = new MainAction().execute(request, response);
		}
		else {//���� forward�� ��������ʾҴٸ� == ����
			System.out.println("����");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("NewFile1.jsp"); // error.jsp
		}
		
		
		// 3. ����ڿ��� ó���� �����͸� ���(V����) --- ����� ������ ���� actionŬ�������� request�� �����Ǿ���Ѵ� ==dispatcher
		// true��� redirect
		if(forward.isRedirect()) {
			// ���� ��û�� �Ǹ� request�� �ٹٲ�����
			response.sendRedirect(forward.getPath());
		}
		else {//false��� forward
			///// pageContext.forward("main.jsp"); �� �����ʰ� ����ó Ȱ��
			
																	// ���ڴ� ������θ� �Է��ؾ��Ѵ�.
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			// ����ó - Ŭ���̾�Ʈ(������,�����) ���� ��û�� ó���ϰ�, �ٽ� ����� ���������ִ� ����
			//	�� ��Ʈ�ѷ� ����
			
			//pageContext ��ſ� dispatcher�� ����ϴ� ������������??
			// �� �������� ��Ʈ�ѷ��� ��ġ�� (����̾������Ѵ�.) �����
			
			//actionŬ�������� �� frontcontrol �Ƶ��ϸ鼭 �����͸� �޾Ƴ��µ� �װ��� dispatcher�����ϴ±���


		}
		
	}

}
