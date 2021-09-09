package day53;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestServlet
 */
//@WebServlet(urlPatterns= {"/TestServlet"})
//@WebServlet(urlPatterns= {"/TestServlet", "/abc"}) // abc로 쳐도 해당 사이트가 보이게
//↕ ==
//@WebServlet("/TestServlet")										// name="action", value="select" ==
@WebServlet(urlPatterns= {"/TestServlet","/abc"},initParams= {@WebInitParam(name="name1",value="ari"),@WebInitParam(name="name2",value="timo")})// 특수한 컨테이너로 서블릿임을 정확하게 전달 == @어노테이션


public class TestServlet extends HttpServlet { // 상속받고있다.
	private static final long serialVersionUID = 1L; // 파일화에 필요한 데이터
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {//기본생성자
        super();
        // TODO Auto-generated constructor stub
    }

    
    
 // 요청을 나타내는 메서드
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()); // 지금의 경로를 작성할 수있도록 write
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */ //post로 부르면 get으로 전송
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//out==내장객체 대체
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8"); // jsp에 나온대로 셋컨텐트타입 지정
		out.println("<html><body>");
		out.println(getInitParameter("name1")+"<br>");
		out.println(getInitParameter("name2")+"<br>");
		out.println(getServletContext().getInitParameter("name3")+"<br>"); // getServletContext().로 web.xml에 설정을 접근할 수가 있게 됨
		out.println(getServletContext().getInitParameter("encoding")+"<br>");
		out.println("</body></html>");
	}

}





