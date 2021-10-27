/*package controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class B_SELETEONE_Controller{

	@RequestMapping("/getBoard.do")
	public ModelAndView handleRequest(BoardDAO dao, BoardVO vo, ModelAndView mav){
	// request ���ڸ� ���� �� �ְ� �ȴ�.

		// Set
		//BoardDAO dao = new BoardDAO();
		//BoardVO vo = new BoardVO();
		//vo.setId(Integer.parseInt(request.getParameter("id")));

		// Selete One
		vo = dao.getBoard(vo);

		// request ����
		//request.setAttribute("data", data);

		// ���
		//forward.setRedirect(false);
		//forward.setPath("getBoard.jsp");

		//ModelAndView mav = new ModelAndView();
		mav.addObject("data", vo);
		mav.setViewName("getBoard.jsp");
		return mav;
		
		//return "getBoard";
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {


		//ActionForward forward = new ActionForward();

		// Set
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));

		// Selete One
		BoardVO data = dao.getBoard(vo);

		// request ����
		//request.setAttribute("data", data);

		// ���
		//forward.setRedirect(false);
		//forward.setPath("getBoard.jsp");

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", data);
		mav.setViewName("getBoard.jsp");
		return mav;
		
		//return "getBoard";
	}


}
*/