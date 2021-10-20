package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class B_DELETE_Controller implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//ActionForward forward = new ActionForward();
		
		
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		vo.setId(Integer.parseInt(request.getParameter("id")));
		
		if(dao.deleteBoard(vo)){
			return "main.do";
//forward.setRedirect(true);
//forward.setPath("main.do");
			
		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류발생!'); history.go(-1); </script>");
			return null;
		}

		
//return forward;
	}

}
