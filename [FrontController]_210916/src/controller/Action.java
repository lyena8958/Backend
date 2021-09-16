package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	// 인터페이스에서는 추상메서드로 바디를 만들지 않는다.
							// 인자는 자원(request, response)를 받는다.
	// 이후 페이지로 되돌려주어야한다. == 페이지 전달방식, 페이지명(경로)인 두 가지로 돌려주어야 한다.
	//							└ 리턴이 두개가 안되니, 두 데이터의 멤버변수인 class를 만들어야한다. (==ActionForward)
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	
}
