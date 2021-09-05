package test;
//[ Servlet (서블릿) ] --> 단독으로 사용할 때도 있지만 보완된 언어인 JSP를 활용하여 후에 서블릿으로 자동변환해주는 쪽으로 사용 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ : 어노테이션, 애너테이션, 에너테이션 --> Spring에서 배울예정
@WebServlet("/Test")//url 맵핑 ex(*.com)으로하면 모든 .com을 불러옴
// == url에(/Test) 대한 설정을 애너테이션을 했다
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 객체 직렬화
	// 자바 내 클래스의 상태 정보를 그대로 저장해서 파일로 저장하는 방법
	// 파일이 필요할 때 다시 객체화하여 메서드,멤버를 이용할 수 있게됨 == serialVersionUID
	

    public Test() { //모든 servlet(서블릿) 에서는 기본생성자들 반드시 필요로 함
        super();
    }
    //request 사용자가 보낼것
    //response 다시 반환해줄것
    // get, post == html에서 form method= "get", "post" 사용한것과 같다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식이라면 이렇게 처리할거야. (==서버측 프로그램)
		//response.getWriter().append("Served at: ").append(request.getContextPath()); // 기본제공
		// 페이지에 작성할 것을 생성할거야
		
		response.setContentType("text/html;cherset=UTF-8"); // 글씨가 깨지면 cherset=UTF-8로 설정해주어야함 https://www.google.com/search?q=cherset%3DUTF-8+%EC%84%A4%EC%A0%95%EB%B0%A9%EB%B2%95&oq=cherset%3DUTF-8+%EC%84%A4%EC%A0%95%EB%B0%A9%EB%B2%95&aqs=chrome..69i57j0i333l5.2669j0j15&sourceid=chrome&ie=UTF-8
		PrintWriter out=response.getWriter(); //response.getWriter(); 통해 out객체를 만듦
		
		//OUT객체는 서블릿에서 html코드를 작성할 수 있다.
	      out.println("<HTML>");
	      out.println("<HEAD><TITLE>서블릿 예제</TITLE><HEAD>");
	      out.println("<BODY><H1>서블릿 실습이다!~~</H1></BODY>");
	      out.println("</HTML>");
	// newline이(ln) 있던없던 똑같이 나옴 -> out이라는 객체가 사용하는게 html기준으로 페이지를 쓰기때문(==개발자 가독성) -> 페이지에서 쓰는거는 html태그인것이다. 
	      
	      /*서블릿은 패키지가없으면 실행이안된다. 반드시있어야함
	      	객체 직렬화를 위해 private static final long serialVersionUID = 1L;ㄱ ㅏ반드시있어야한다.
	      	기본생성자가 있어야한다.
	      get, post 형식별 두가지 사항에 대한 메서드가 있어야 한다.
	      	사용자로부터 넘어온 데이터는 request 내가 사용자에게 줄 response -> html문구 37~40번라인*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식이라면 이렇게 처리할거야. (==서버측 프로그램)
		doGet(request, response); // 기본 제공
		// Post방식으로 요청해도, Get으로 처리하겠다~  // request 사용자가 보내는 것 		

		
		//String name = request.getParameter("name");
		/*<form method="post">
		 <input type="text" name="name"> html의 태그가 이거인 경우*/
		
		//if(name.equals("김효경")) {
		//	System.out.println("관리자");
		//}
		
		
	}

}
