
/*package controller.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.board.BoardDAO;
import model.board.BoardVO;	

@Controller
public class B_Main_Controller{

@RequestMapping("/main.do")     // dafaultValue: ���� �ȹ޾ƿ� �� �Է��� �� // 
	public ModelAndView getBoardList(
			@RequestParam(value="condition", defaultValue="title", required=false)String condition 
			, @RequestParam(value="keyword",defaultValue="",required=false)String keyword 
			, HttpServletRequest request, BoardDAO bdao, BoardVO vo) {

		System.out.println(condition+": "+keyword);

		List<BoardVO> datas = bdao.getListBoard(vo);

		String indexStr =request.getParameter("index");
		int index = 0;

		// ����ڿ��� ����� Board list
		List<BoardVO> result = new ArrayList<BoardVO>();

		int boardIndex; // ����¡ �ѹ�ȣ
		int limit = 0;
		if(!(indexStr==null||indexStr.equals("1"))) {
			// �ε��� - ������ ����  // 2������ ��û -> datas.get(11 ~~ 20)���� ������add
			index = (Integer.parseInt(request.getParameter("index"))-1)*10;		

			//System.out.println("datas" + datas.size());
			//System.out.println("index "+index);

			for(int i = index; i < index+(datas.size()-index); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) { // ���ѹ�������
					break;
				}
			}
			boardIndex = index+1;

		}
		else {
			limit = 0;
			for(int i = 0; i < datas.size(); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) {
					break;
				}
			}
			boardIndex= 1;
		}

		// ����¡ index
		ArrayList<Integer> j = new ArrayList<Integer>();
		j.add(1);
		for(int i = 1; i < datas.size(); i++) {
			if(i%10==0) {
				j.add(j.size()+1);
			}
		}

		// 81�� �������� ����
		request.setAttribute("indexx", j);
		request.setAttribute("datas", result);
		request.setAttribute("boardIndex", boardIndex); 

		ModelAndView mav = new ModelAndView();
		//mav.setViewName("main.jsp");
		mav.addObject("datas", datas);
		mav.addObject("indexx", j);
		mav.addObject("boardIndex", boardIndex);
		
		mav.setViewName("main");
		
		return mav;
		
		//return "main";
	}
	
	@RequestMapping("/main.do")
	public ModelAndView getBoardList(HttpServletRequest request, BoardDAO bdao, BoardVO vo) {


		// board List
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> datas = bdao.getListBoard(vo);

		String indexStr =request.getParameter("index");
		int index = 0;

		// ����ڿ��� ����� Board list
		List<BoardVO> result = new ArrayList<BoardVO>();

		int boardIndex; // ����¡ �ѹ�ȣ
		int limit = 0;
		if(!(indexStr==null||indexStr.equals("1"))) {
			// �ε��� - ������ ����  // 2������ ��û -> datas.get(11 ~~ 20)���� ������add
			index = (Integer.parseInt(request.getParameter("index"))-1)*10;		

			//System.out.println("datas" + datas.size());
			//System.out.println("index "+index);

			for(int i = index; i < index+(datas.size()-index); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) { // ���ѹ�������
					break;
				}
			}
			boardIndex = index+1;

		}
		else {
			limit = 0;
			for(int i = 0; i < datas.size(); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) {
					break;
				}
			}
			boardIndex= 1;
		}

		// ����¡ index
		ArrayList<Integer> j = new ArrayList<Integer>();
		j.add(1);
		for(int i = 1; i < datas.size(); i++) {
			if(i%10==0) {
				j.add(j.size()+1);
			}
		}

		// 81�� �������� ����
		request.setAttribute("indexx", j);
		request.setAttribute("datas", result);
		request.setAttribute("boardIndex", boardIndex); 

		forward.setRedirect(false);
		forward.setPath("main.jsp");

		ModelAndView mav = new ModelAndView();
		//mav.setViewName("main.jsp");
		mav.addObject("datas", datas);
		mav.addObject("indexx", j);
		mav.addObject("boardIndex", boardIndex);
		
		mav.setViewName("main");
		
		return mav;
		
		//return "main";
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//ActionForward forward = new ActionForward();

		// board List
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> datas = bdao.getListBoard(new BoardVO());

		String indexStr =request.getParameter("index");
		int index = 0;

		// ����ڿ��� ����� Board list
		List<BoardVO> result = new ArrayList<BoardVO>();

		int boardIndex; // ����¡ �ѹ�ȣ
		int limit = 0;
		if(!(indexStr==null||indexStr.equals("1"))) {
			// �ε��� - ������ ����  // 2������ ��û -> datas.get(11 ~~ 20)���� ������add
			index = (Integer.parseInt(request.getParameter("index"))-1)*10;		

			System.out.println("datas" + datas.size());
			System.out.println("index "+index);

			for(int i = index; i < index+(datas.size()-index); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) { // ���ѹ�������
					break;
				}
			}
			boardIndex = index+1;

		}
		else {
			limit = 0;
			for(int i = 0; i < datas.size(); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) {
					break;
				}
			}
			boardIndex= 1;
		}

		// ����¡ index
		ArrayList<Integer> j = new ArrayList<Integer>();
		j.add(1);
		for(int i = 1; i < datas.size(); i++) {
			if(i%10==0) {
				j.add(j.size()+1);
			}
		}

		// 81�� �������� ����
		request.setAttribute("indexx", j);
		request.setAttribute("datas", result);
		request.setAttribute("boardIndex", boardIndex); 

		forward.setRedirect(false);
		forward.setPath("main.jsp");

		ModelAndView mav = new ModelAndView();
		//mav.setViewName("main.jsp");
		mav.addObject("datas", datas);
		mav.addObject("indexx", j);
		mav.addObject("boardIndex", boardIndex);
		
		mav.setViewName("main");
		
		return mav;
		
		//return "main";
	}



}
*/