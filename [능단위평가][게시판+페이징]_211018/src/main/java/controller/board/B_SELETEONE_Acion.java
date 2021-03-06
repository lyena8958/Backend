package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

public class B_SELETEONE_Acion implements Action{

	@Override
	public ActionForward doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ActionForward forward = new ActionForward();
		
		// Set
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		
		// Selete One
		BoardVO data = dao.getBoard(vo);

		// request ????
		request.setAttribute("data", data);
		
		// ????
		forward.setRedirect(false);
		forward.setPath("getBoard.jsp");
		
		
		return forward;
	}

}
