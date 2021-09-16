package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message.MessageDAO;
import model.message.MsgSet;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;
//day56_0916_YN
public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		// ����¡ó�� -- ��û ��ϰ��� Ȯ��
		//String mcntStr = request.getParameter("mcnt");
		int mcnt = 100;
/*			if(mcntStr!=null){
				
				mcnt = Integer.parseInt(mcntStr);
			}
		String url = "control.jsp?action=main&mcnt=";
		url = url + mcnt;
				*/
		// ����� ���ۺ��� ��û Ȯ��
		//String id = "";
		//System.out.println(request.getParameter("user"));
/*		if(request.getParameter("user")!=null){
			mcnt =  100;
			id = request.getParameter("user");
			url = url + "&user=" + id;
		}*/

		MessageDAO messageDAO = new MessageDAO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
			
		// ��۸�� ��ü��� 
		ArrayList<MsgSet> msgDatas = messageDAO.msg_SELECT_ALL(mcnt, "");
			
		// ȸ����� ��ü���
		ArrayList<UserInfoVO> userDatas = userInfoDAO.user_SELECT_ALL(); 
			
		request.setAttribute("msgDatas", msgDatas);
		request.setAttribute("mcnt", mcnt);
		request.setAttribute("userDatas", userDatas);
			
		
		// ������ �̵�����
		forward.setRedirect(false); // false == forward
		forward.setPath("main.jsp"); 
		
		return forward;
	}
	

	
}

