/*package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class B_DELETE_Controller{

	@RequestMapping("/deleteBoard.do")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//ActionForward forward = new ActionForward();


		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();

		vo.setId(Integer.parseInt(request.getParameter("id")));

		if(dao.deleteBoard(vo)){
			//ModelAndView mav = new ModelAndView();
			//mav.setViewName("redirect:main.do"); 
			
			//return mav;
			
			return "main.do";

		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류발생!'); history.go(-1); </script>");
			return null;
		}


		//return forward;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = new ActionForward();


		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();

		vo.setId(Integer.parseInt(request.getParameter("id")));

		if(dao.deleteBoard(vo)){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:main.do"); 
			
			return mav;
			
			//return "main.do";
			
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
*/