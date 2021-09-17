package control.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.Main_Action;
import controller.action.Msg_Delete;
import controller.action.Msg_New;
import controller.action.Msg_Update;
import controller.action.Reply_Delete;
import controller.action.Reply_New;
import controller.action.Reply_Update;
import controller.action.UserInfo_LogOut;
import controller.action.UserInfo_Login;
import controller.action.UserInfo_SignUp;


/**
 * Servlet implementation class FrontController
 */
// ���ͺ��� ������̼��� �켱������ �����Ƿ� ���������̾ȵ�
@WebServlet("/FrontController") // ������� ��û�� ��� ���� ������̼�
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
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
	
	
	public void doAction (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ü uri
		String uri = request.getRequestURI();
		
		//��δ���
		String cp = request.getContextPath();
		
		// string ���� --> ��û�� ������ ����
		String action = uri.substring(cp.length()+1); // +1 == ������"/"���� sub�ϱ� ����
		
		ActionForward forward = null;		
		
		// [����]
		if(action.equals("main.do")) {
			forward = new Main_Action().execute(request, response);
				
		}
		// [ȸ������]
		else if(action.equals("signUp.do")) {
			//System.out.println("ȸ�����Կ��� �����ϴ�!");
			new UserInfo_SignUp().execute(request, response);
			return; // ���� ���� �̵������� �����Ƿ� ����
		}
		// [�α���]
		else if(action.equals("login.do")) {
			forward = new UserInfo_Login().execute(request, response);

		}
		// [�α׾ƿ�]
		else if(action.equals("logout.do")) {
			forward = new UserInfo_LogOut().execute(request, response);
			
		}
		// [����߰�]
		else if(action.equals("msgInsert.do")) {
			forward = new Msg_New().execute(request, response);
			
		}
		// [��ۻ���]
		else if(action.equals("msgDelete.do")) {
			forward = new Msg_Delete().execute(request, response);
			
		}
		// [��ۼ���]
		else if(action.equals("msgUpdate.do")) {
			forward = new Msg_Update().execute(request, response);
			
		}
		else if(action.equals("replyAdd.do")) {
			forward = new Reply_New().execute(request, response);
			
		}
		else if(action.equals("replyDelete.do")) {
			forward = new Reply_Delete().execute(request, response);
			
		}
		else if(action.equals("replyUpdate.do")) {
			forward = new Reply_Update().execute(request, response);
			
		}
		
		
		// redirect�� true == sendredirect���
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
		
		
		
	}
}
