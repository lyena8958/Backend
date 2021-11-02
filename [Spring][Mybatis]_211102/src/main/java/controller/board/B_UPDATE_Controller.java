/*package controller.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class B_UPDATE_Controller{

	@RequestMapping("updateBoard.do")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();


		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();

		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));

		if(!dao.updateBoard(vo)){
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류발생!'); history.go(-1); </script>");
			return null;			
		}



		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		
		return "redirect:main.do";
		
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();


		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();

		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));

		if(!dao.updateBoard(vo)){
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류발생!'); history.go(-1); </script>");
			return null;			
		}


		forward.setRedirect(true);
				forward.setPath("main.do");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		
		return mav;
		
		//return "main.do";
	}


}
*/