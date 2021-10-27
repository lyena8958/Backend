
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

@RequestMapping("/main.do")     // dafaultValue: 값을 안받아올 때 입력할 값 // 
	public ModelAndView getBoardList(
			@RequestParam(value="condition", defaultValue="title", required=false)String condition 
			, @RequestParam(value="keyword",defaultValue="",required=false)String keyword 
			, HttpServletRequest request, BoardDAO bdao, BoardVO vo) {

		System.out.println(condition+": "+keyword);

		List<BoardVO> datas = bdao.getListBoard(vo);

		String indexStr =request.getParameter("index");
		int index = 0;

		// 사용자에게 출력할 Board list
		List<BoardVO> result = new ArrayList<BoardVO>();

		int boardIndex; // 페이징 총번호
		int limit = 0;
		if(!(indexStr==null||indexStr.equals("1"))) {
			// 인덱스 - 개발자 입장  // 2페이지 요청 -> datas.get(11 ~~ 20)까지 데이터add
			index = (Integer.parseInt(request.getParameter("index"))-1)*10;		

			//System.out.println("datas" + datas.size());
			//System.out.println("index "+index);

			for(int i = index; i < index+(datas.size()-index); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) { // 제한범위까지
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

		// 페이징 index
		ArrayList<Integer> j = new ArrayList<Integer>();
		j.add(1);
		for(int i = 1; i < datas.size(); i++) {
			if(i%10==0) {
				j.add(j.size()+1);
			}
		}

		// 81번 라인으로 변경
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

		// 사용자에게 출력할 Board list
		List<BoardVO> result = new ArrayList<BoardVO>();

		int boardIndex; // 페이징 총번호
		int limit = 0;
		if(!(indexStr==null||indexStr.equals("1"))) {
			// 인덱스 - 개발자 입장  // 2페이지 요청 -> datas.get(11 ~~ 20)까지 데이터add
			index = (Integer.parseInt(request.getParameter("index"))-1)*10;		

			//System.out.println("datas" + datas.size());
			//System.out.println("index "+index);

			for(int i = index; i < index+(datas.size()-index); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) { // 제한범위까지
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

		// 페이징 index
		ArrayList<Integer> j = new ArrayList<Integer>();
		j.add(1);
		for(int i = 1; i < datas.size(); i++) {
			if(i%10==0) {
				j.add(j.size()+1);
			}
		}

		// 81번 라인으로 변경
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

		// 사용자에게 출력할 Board list
		List<BoardVO> result = new ArrayList<BoardVO>();

		int boardIndex; // 페이징 총번호
		int limit = 0;
		if(!(indexStr==null||indexStr.equals("1"))) {
			// 인덱스 - 개발자 입장  // 2페이지 요청 -> datas.get(11 ~~ 20)까지 데이터add
			index = (Integer.parseInt(request.getParameter("index"))-1)*10;		

			System.out.println("datas" + datas.size());
			System.out.println("index "+index);

			for(int i = index; i < index+(datas.size()-index); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) { // 제한범위까지
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

		// 페이징 index
		ArrayList<Integer> j = new ArrayList<Integer>();
		j.add(1);
		for(int i = 1; i < datas.size(); i++) {
			if(i%10==0) {
				j.add(j.size()+1);
			}
		}

		// 81번 라인으로 변경
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