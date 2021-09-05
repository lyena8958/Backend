package day42_0825;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// NF.jsp 연결

@WebServlet("/CalcServlet") // HttpServlet를 상속 받음에 따라 doGet,doPost 등 기능들이 무료 제공되는 것이다.(method에 따라 자동호출)
public class CalcServlet_1 extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	// 객체직렬화를 위함 ↑
       
    public CalcServlet_1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// response.getWriter().append를 통해 Served at: 를 입력하게 됨
		
	//이제 doPost에서 호출되지않아 doGet에서 할 것이 없으니 dopost로 호출하여 보내줄 것임
	// 사용자가 잘못해서 get으로 들어왔어도 post로 보내주는 형식
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);// 기본정의가 없어서 get메서드로 호출하여 보내주도록 기본설정되어있음
		
		// contentType는 jsp파일안에 %안에있는 contenttype을 의미한다.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");

		//int result = calc(num1, num2, op); // 서블릿 내부에 메서드를 둔 것
		
		// 클래스를 분리하여 사용 == 관심분리 현상
		Calc_1 calc = new Calc_1(num1, num2, op);
		int result=calc.getResult();
		// └> 관심분리 현상 --> 스프링에서 한번 더 할거임
		
		
		
		out.println("<HTML>"); //개발자 간의 코드 가독성을 위해 ln으로 써주는게 좋다.
		out.println("<head><title>계산기 서블릿</title></head>");
		out.println("<body>");
		out.println("<h2>계산결과: ");
		out.println(num1+" "+op+" "+num2+" = "+result); // 화면출력 구성
		out.println("</h2>");
		out.println("</body></HTML>");
		
		
	} // doPost
	
	//메서드생성
	public int calc(int num1, int num2, String op) {
		int result=0;
		
		if(op.equals("+")) {
			result = num1+num2;
		}
		else if(op.equals("-")) {
			result = num1-num2;
		}
		return result;
	}

}
