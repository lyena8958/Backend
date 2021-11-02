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

//Component�� ������ �� �� ó�� ��ӹ��� ������̼� �߿�, controller���� �˸���
//@Controller ������̼��� ��������ν� ��Ʈ�ѷ����� �ν��ϱ� ������ implements�� ���� �־ �ȴ�. 


//������̼��� ��������ν� implements�� ���� ����
//implements Controller�� �ϰ� �Ǹ� �� import�� �����ϴµ� web.servlet.mvc��, POJO�� �ƴϴ�.(servlet)
//�� �Ϻ��� POJO Ŭ���� �̴�.
//�� ���xxx, �߻�޼����� ������xxx �� �Լ��� input, output "�Լ��� ������ �����ϴ�."

@Controller // import org.springframework.stereotype.Controller;
public class B_INSERT_Controller{

	// insertBoard�� ������ ��, �ʿ���� ������ input�� response�� ������ �� �ִ�.
	
	@RequestMapping("/insertBoard.do") // �Ӽ��� �߰��ؾ� �Ѵٸ�, value="/insertBoard.do"�� �����غ� �� �ִ�.
	public String insertBoard(HttpServletRequest request, HttpServletResponse response, BoardVO vo, BoardDAO dao) throws IOException {
																					// pjp ���ε庯������ == BoardVO,DAO
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
			out.println("<script>alert('����!'); history.go(-1); </script>");
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
			out.println("<script>alert('����!'); history.go(-1); </script>");
			return null;
		}

		//return forward;
	}



}
*/