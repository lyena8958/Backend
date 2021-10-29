package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.post.PostService;
import model.post.PostVO;

@Controller
public class Post_Controller {

	@Autowired
	private PostService postService;

	// [단일 포스트]
	@RequestMapping("/getPost.do")
	public String getPost(PostVO vo, Model model, PrintWriter out, HttpServletResponse response) throws IOException{
		PostVO data = postService.getData(vo);

		//사용자가 입력한 pw와, DB pw가 같다면 → 데이터 반환
		if(data.getPassword()==vo.getPassword()) {
			model.addAttribute("data", data);
			return "showPost.jsp";
		}
		
		// 맞지 않다면, 이전 페이지 이동
		out = response.getWriter();
		out.print("<script>alert('비밀번호가 맞지 않습니다.'); history.go(-1); </script>");
		return null;

	}

	// [전체 포스트]
	@RequestMapping("/getListPost.do")
	public String getPost(PostVO vo, Model model){
		PostVO data = postService.getData(vo);

		List<PostVO> datas = postService.getList(vo);
		
		model.addAttribute("datas", datas);
		
		return "showListPost.jsp";

	}
	
	@RequestMapping("/insertPost.do")
	public String insertPost(PostVO vo, PrintWriter out, HttpServletResponse response) throws IOException {

		if(postService.insertPost(vo)) {
			out = response.getWriter();
			out.println("<script>alert('신고접수가 정상적으로 완료되었습니다.'); history.go(-1); </script>");
		}
		else {
			//에러페이지이동
		}

		return null;
	}


}
