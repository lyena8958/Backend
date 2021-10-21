package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;
import model.board.BoardVO;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		List<BoardVO> datas=dao.getBoardList(new BoardVO());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;
	}

}
