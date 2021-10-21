package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;
import model.board.BoardVO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		dao.insertBoard(vo);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("main.do");
		return mav;
	}

}
