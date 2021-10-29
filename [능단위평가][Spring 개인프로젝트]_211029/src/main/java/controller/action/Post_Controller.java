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

	// [���� ����Ʈ]
	@RequestMapping("/getPost.do")
	public String getPost(PostVO vo, Model model, PrintWriter out, HttpServletResponse response) throws IOException{
		PostVO data = postService.getData(vo);

		//����ڰ� �Է��� pw��, DB pw�� ���ٸ� �� ������ ��ȯ
		if(data.getPassword()==vo.getPassword()) {
			model.addAttribute("data", data);
			return "showPost.jsp";
		}
		
		// ���� �ʴٸ�, ���� ������ �̵�
		out = response.getWriter();
		out.print("<script>alert('��й�ȣ�� ���� �ʽ��ϴ�.'); history.go(-1); </script>");
		return null;

	}

	// [��ü ����Ʈ]
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
			out.println("<script>alert('�Ű������� ���������� �Ϸ�Ǿ����ϴ�.'); history.go(-1); </script>");
		}
		else {
			//�����������̵�
		}

		return null;
	}


}
