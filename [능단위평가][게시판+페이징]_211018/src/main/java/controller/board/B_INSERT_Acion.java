package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

public class B_INSERT_Acion implements Action{

	@Override
	public ActionForward doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = null;
		
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		vo.setWriter(request.getParameter("writer"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		if(dao.insertBoard(vo)){
			
			forward = new ActionForward();
			
			forward.setRedirect(true);
			forward.setPath("main.do");

		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('½ÇÆÐ!'); history.go(-1); </script>");
		}
		
		return forward;
	}

}
