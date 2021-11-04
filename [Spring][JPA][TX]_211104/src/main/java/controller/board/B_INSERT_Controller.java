/*package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.board.BoardDAO;
import model.board.BoardVO;

//@Service
//@Repository

//Component이 있지만 → 위 처럼 상속받은 어노테이션 중에, controller임을 알리자
//@Controller 어노테이션을 사용함으로써 컨트롤러임을 인식하기 때문에 implements를 안해 주어도 된다. 


//어노테이션을 사용함으로써 implements를 갖는 의의
//implements Controller를 하게 되면 → import를 수행하는데 web.servlet.mvc로, POJO가 아니다.(servlet)
//① 완벽한 POJO 클래스 이다.
//② 상속xxx, 추상메서드의 강제성xxx → 함수의 input, output "함수명 변경이 가능하다."

@Controller // import org.springframework.stereotype.Controller;
public class B_INSERT_Controller{

	// insertBoard를 수행할 때, 필요없는 인자인 input의 response를 제거할 수 있다.
	
	@RequestMapping("/insertBoard.do") // 속성을 추가해야 한다면, value="/insertBoard.do"로 설정해볼 수 있다.
	public String insertBoard(HttpServletRequest request, HttpServletResponse response, BoardVO vo, BoardDAO dao) throws IOException {
																					// pjp 바인드변수마냥 == BoardVO,DAO
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();

		vo.setWriter(request.getParameter("writer"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));

		if(dao.insertBoard(vo)){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("main.do"); 
			
			return "redirect:main.do";
			//return mav;

		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('실패!'); history.go(-1); </script>");
			return null;
		}

		//return forward;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//ActionForward forward = null;

		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();

		vo.setWriter(request.getParameter("writer"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));

		if(dao.insertBoard(vo)){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("main.do"); 
			return mav;
			forward = new ActionForward();

		forward.setRedirect(true);
		forward.setPath("main.do");

		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('실패!'); history.go(-1); </script>");
			return null;
		}

		//return forward;
	}



}
*/