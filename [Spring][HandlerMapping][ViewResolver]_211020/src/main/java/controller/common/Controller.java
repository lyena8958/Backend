package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Action -> Controller
public interface Controller {
//ActionForward doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	// ��û����� ���ڷ� �޾Ƽ�, ȭ�� �׺���̼��� ������ �� �ִ�.
	
}
