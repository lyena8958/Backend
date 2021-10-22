package controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.board.BoardDAO;
import model.board.BoardVO;

@Controller
public class BoardController {		
	/*@RequestMapping("/main.do")     // dafaultValue: 값을 안받아올 때 입력할 값 // 
	public ModelAndView getBoardList(HttpServletRequest request, BoardDAO bdao, BoardVO vo) {

		//System.out.println(condition+": "+keyword);
		System.out.println(vo.getCondition()+": "+vo.getContent());

		// 이를 나중에 어노테이션으로 대체할 수 있다. --> 나중에 할 예정
		if(vo.getCondition()==null) {
			vo.setCondition("title");
		}
		
		
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
	}*/
	// return : ModelandView
	// @RequestParam()String condition → 기타 parameter받아올 수 있음
	
	// view에게서 name과 value를 받기위한 인스턴스변수
	@ModelAttribute("sm")
	public Map<String, String> searchMap(){
		Map<String, String> sm = new HashMap<String, String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
	@RequestMapping("/main.do")     // dafaultValue: 값을 안받아올 때 입력할 값 // 
	public String getBoardList(
			@RequestParam(value="condition", defaultValue="title", required=false)String condition 
			, @RequestParam(value="keyword",defaultValue="",required=false)String keyword 
			, HttpServletRequest request, BoardDAO bdao, BoardVO vo, Model model) {

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


		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("main.jsp");
		/*mav.addObject("datas", datas); // scope가 request와 같다.
		mav.addObject("indexx", j);
		mav.addObject("boardIndex", boardIndex);*/		
		//mav.setViewName("main");
		
		model.addAttribute("datas", datas);
		model.addAttribute("indexx", j);
		model.addAttribute("boardIndex", boardIndex);
		
		
		return "main.jsp";
	}
	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpServletResponse response, BoardVO vo, BoardDAO dao) throws IOException {

		if(dao.insertBoard(vo)){			
			return "redirect:main.do";
		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('실패!'); history.go(-1); </script>");
			return null;
		}

	}
	
	// return ModelAndView
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDAO dao, BoardVO vo, ModelAndView mav, Model model){ // Model : 정보에 해당하는 클래스
		vo = dao.getBoard(vo);
		//mav.addObject("data", vo);
		//mav.setViewName("getBoard.jsp");
		model.addAttribute("data", vo);

		return "getBoard";
	}
	
	@RequestMapping("/updateBoard.do")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, BoardVO vo, BoardDAO dao) throws Exception {

		if(!dao.updateBoard(vo)){
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류발생!'); history.go(-1); </script>");
			return null;			
		}

		return "redirect:main.do";
		
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();

		vo.setId(Integer.parseInt(request.getParameter("id")));

		if(dao.deleteBoard(vo)){
			
			return "main.do";

		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류발생!'); history.go(-1); </script>");
			return null;
		}

	}
}
