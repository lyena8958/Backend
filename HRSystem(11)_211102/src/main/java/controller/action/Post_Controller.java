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
	@RequestMapping("/mazer-main/dist/getPost.do")
	public String getPost(PostVO vo, Model model) throws IOException{
		PostVO data = postService.getData(vo);

		model.addAttribute("data", data);
		
		return "show_Post.jsp";
		
		//사용자가 입력한 pw와, DB pw가 같다면 → 데이터 반환
		/*if(data.getPassword()==vo.getPassword()) {
					
					
		}*/
		/*// 맞지 않다면, 이전 페이지 이동
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("<script>alert('비밀번호가 맞지 않습니다.'); history.go(-1); </script>");
		return null;*/

	}

	// [전체 포스트]
	@RequestMapping("/mazer-main/dist/getListPost.do")
	public String getPostList(PostVO vo, Model model){
		//PostVO data = postService.getData(vo);

		List<PostVO> datas = postService.getList(vo);
		
		for(PostVO v: datas) {
			v.setWdate(v.getWdate().substring(0,19));
			System.out.println("v : "+v);
		}

		model.addAttribute("datas", datas);
		
		return "show_ListPost.jsp";

	}
	
	@RequestMapping("/mazer-main/dist/insertPost.do")
	public String insertPost(PostVO vo, HttpServletResponse response) throws IOException {
		System.out.println("들림!#!#");

		if(postService.insertPost(vo)) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("<script> alert('정상적으로 완료되었습니다. 접수해 주셔서 감사드립니다.'); location.href='loginHRAdmin.do'; </script>");
		}

		return null;
	}
	
	@RequestMapping("/mazer-main/dist/updatePost.do")
	public String updatePost(PostVO vo, HttpServletResponse response) throws IOException {

		if(postService.updatePost(vo)) {
			return "redirect:getListPost.do";
		}
		
		return null;
		
	}



}
