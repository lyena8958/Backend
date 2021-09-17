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
// 필터보다 어노테이션이 우선순위가 높으므로 필터적용이안됨
@WebServlet("/FrontController") // 사용자의 요청을 모두 받을 어노테이션
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
		
		//전체 uri
		String uri = request.getRequestURI();
		
		//경로대상명
		String cp = request.getContextPath();
		
		// string 제거 --> 요청값 데이터 정리
		String action = uri.substring(cp.length()+1); // +1 == 슬래시"/"까지 sub하기 위함
		
		ActionForward forward = null;		
		
		// [메인]
		if(action.equals("main.do")) {
			forward = new Main_Action().execute(request, response);
				
		}
		// [회원가입]
		else if(action.equals("signUp.do")) {
			//System.out.println("회원가입에서 보냅니다!");
			new UserInfo_SignUp().execute(request, response);
			return; // 가입 이후 이동페이지 없으므로 종료
		}
		// [로그인]
		else if(action.equals("login.do")) {
			forward = new UserInfo_Login().execute(request, response);

		}
		// [로그아웃]
		else if(action.equals("logout.do")) {
			forward = new UserInfo_LogOut().execute(request, response);
			
		}
		// [댓글추가]
		else if(action.equals("msgInsert.do")) {
			forward = new Msg_New().execute(request, response);
			
		}
		// [댓글삭제]
		else if(action.equals("msgDelete.do")) {
			forward = new Msg_Delete().execute(request, response);
			
		}
		// [댓글수정]
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
		
		
		// redirect가 true == sendredirect라면
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
		
		
		
	}
}
