package controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.board.BoardService;
import model.board.BoardVO;

@Controller
@SessionAttributes("data")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
	/*@RequestMapping("/main.do")
	public String getBoardList(@RequestParam(value="condition",defaultValue="title",required=false)String condition,@RequestParam(value="keyword",defaultValue="",required=false)String keyword,BoardVO vo,Model model) {
		System.out.println("검색로깅: "+condition+" / "+keyword);
		List<BoardVO> datas=boardService.getBoardList(vo);
		model.addAttribute("datas", datas);
		return "main.jsp";
	}*/
	@RequestMapping("/main.do")
	public String getBoardList(BoardVO vo,Model model) {
		if(vo.getCondition()==null) {
			vo.setCondition("title");
		}
		if(vo.getKeyword()==null) {
			vo.setKeyword("");
		}
		List<BoardVO> datas=boardService.getBoardList(vo);
		model.addAttribute("datas", datas);
		return "main.jsp";
	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo,Model model) {
		model.addAttribute("data", boardService.getBoard(vo));		
		return "getBoard.jsp";
	}
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:main.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:main.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo) {
		System.out.println("로깅: "+vo.getWriter());
		boardService.updateBoard(vo);
		return "redirect:main.do";
	}
}
