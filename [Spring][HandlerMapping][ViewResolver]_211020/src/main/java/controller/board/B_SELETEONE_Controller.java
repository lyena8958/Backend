package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class B_SELETEONE_Controller implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
//ActionForward forward = new ActionForward();
		
		// Set
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		
		// Selete One
		BoardVO data = dao.getBoard(vo);

		// request 전송
		request.setAttribute("data", data);
		
		// 경로
//forward.setRedirect(false);
//forward.setPath("getBoard.jsp");
		
		
		return "getBoard";
	}

}
