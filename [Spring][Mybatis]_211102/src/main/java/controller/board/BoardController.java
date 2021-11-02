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
	/*@RequestMapping("/main.do")     // dafaultValue: ���� �ȹ޾ƿ� �� �Է��� �� // 
	public ModelAndView getBoardList(HttpServletRequest request, BoardDAO bdao, BoardVO vo) {

		//System.out.println(condition+": "+keyword);
		System.out.println(vo.getCondition()+": "+vo.getContent());

		// �̸� ���߿� ������̼����� ��ü�� �� �ִ�. --> ���߿� �� ����
		if(vo.getCondition()==null) {
			vo.setCondition("title");
		}
		
		
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
	}*/
	// return : ModelandView
	// @RequestParam()String condition �� ��Ÿ parameter�޾ƿ� �� ����
	
	// view���Լ� name�� value�� �ޱ����� �ν��Ͻ�����
	
	
	//10.26
	// service�� ����Կ� ���� boardDAO�� �ʿ��������.
	// �������� �����Ͽ� dao ���� �ÿ��� POJO�� �ǵ帮���ʱ� �ϱ� ����
	@Autowired
	private BoardService boardService;
	
	
	
	@ModelAttribute("sm")
	public Map<String, String> searchMap(){
		Map<String, String> sm = new HashMap<String, String>();
		sm.put("����", "title");
		sm.put("�ۼ���", "writer");
		return sm;
	}
	
//BoardDAO Ŀ�ǵ� ���� ���� ����!!
	
	@RequestMapping("/main.do")     // dafaultValue: ���� �ȹ޾ƿ� �� �Է��� �� // 
	public String getBoardList(
			@RequestParam(value="condition", defaultValue="title", required=false)String condition 
			, @RequestParam(value="keyword",defaultValue="",required=false)String keyword 
			, HttpServletRequest request, BoardVO vo, Model model) {

		System.out.println(condition+": "+keyword);

		List<BoardVO> datas = boardService.getListBoard(vo);

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


		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("main.jsp");
		/*mav.addObject("datas", datas); // scope�� request�� ����.
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
	// �����Է�
	//System.out.println("1");
		MultipartFile fileupload = vo.getFileUpload();
		System.out.println("fileupload : "+vo.getFileUpload());
		
	//System.out.println("2");		
		
		
		// ������ �������� ���� ����
		if(!fileupload.isEmpty()) {
			String fileName = fileupload.getOriginalFilename(); // �����̸�
			System.out.println("�����̸� : "+fileName);
			fileupload.transferTo(new File("D:\\YN_0910_210929"+fileName)); //������ ����
		}
	//System.out.println("3");
		
		if(boardService.insertBoard(vo)){			
			return "redirect:main.do";
		}
		else{
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('����!'); history.go(-1); </script>");
			return null;
		}

	}
	
	// return ModelAndView
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, ModelAndView mav, Model model){ // Model : ������ �ش��ϴ� Ŭ����
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
			out.println("<script>alert('�����߻�!'); history.go(-1); </script>");
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
			out.println("<script>alert('�����߻�!'); history.go(-1); </script>");
			return null;
		}

	}
}
