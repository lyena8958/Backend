package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.board.BoardService;
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
	
	
	//10.26
	// service를 사용함에 따라 boardDAO가 필요없어진다.
	// 다형성을 적용하여 dao 변경 시에도 POJO를 건드리지않기 하기 위함
	@Autowired
	private BoardService boardService;
	
	
	
	@ModelAttribute("sm")
	public Map<String, String> searchMap(){
		Map<String, String> sm = new HashMap<String, String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
//BoardDAO 커맨드 변수 전부 제거!!
	
	@RequestMapping("/main.do")     // dafaultValue: 값을 안받아올 때 입력할 값 // 
	public String getBoardList(
			@RequestParam(value="condition", defaultValue="title", required=false)String condition 
			, @RequestParam(value="keyword",defaultValue="",required=false)String keyword 
			, HttpServletRequest request, BoardVO vo, Model model) {

		System.out.println(condition+": "+keyword);

		List<BoardVO> datas = boardService.getListBoard(vo);

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
	public String insertBoard(HttpServletResponse response, BoardVO vo) throws IOException {
	// 파일입력
	//System.out.println("1");
		MultipartFile fileupload = vo.getFileUpload();
		System.out.println("fileupload : "+vo.getFileUpload());
		
	//System.out.println("2");		
		
		
		// 파일을 가져왔을 때만 수행
		if(!fileupload.isEmpty()) {
			String fileName = fileupload.getOriginalFilename(); // 파일이름
			System.out.println("파일이름 : "+fileName);
			fileupload.transferTo(new File("D:\\YN_0910_210929"+fileName)); //파일을 넣음
		}
	//System.out.println("3");
		
		if(boardService.insertBoard(vo)){			
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
	public String getBoard(BoardVO vo, ModelAndView mav, Model model){ // Model : 정보에 해당하는 클래스
		vo = boardService.getBoard(vo);
		//mav.addObject("data", vo);
		//mav.setViewName("getBoard.jsp");
		model.addAttribute("data", vo);

		return "getBoard";
	}
	
	@RequestMapping("/updateBoard.do")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, BoardVO vo) throws Exception {

		if(!boardService.updateBoard(vo)){
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류발생!'); history.go(-1); </script>");
			return null;			
		}

		return "redirect:main.do";
		
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(HttpServletRequest request, HttpServletResponse response, BoardVO vo) throws IOException {

		vo.setId(Integer.parseInt(request.getParameter("id")));

		if(boardService.deleteBoard(vo)){
			
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
