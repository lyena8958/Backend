package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Action -> Controller
public interface Controller {
//ActionForward doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	// 요청헤더를 인자로 받아서, 화면 네비게이션을 수행할 수 있다.
	
}
