package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;
import model.board.BoardVO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		BoardVO data=dao.getBoard(vo);
		request.setAttribute("data", data);
	
		ModelAndView mav=new ModelAndView();
		mav.setViewName("getBoard.jsp");
		return mav;
	}

}
