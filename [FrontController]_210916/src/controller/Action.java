package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	// �������̽������� �߻�޼���� �ٵ� ������ �ʴ´�.
							// ���ڴ� �ڿ�(request, response)�� �޴´�.
	// ���� �������� �ǵ����־���Ѵ�. == ������ ���޹��, ��������(���)�� �� ������ �����־�� �Ѵ�.
	//							�� ������ �ΰ��� �ȵǴ�, �� �������� ��������� class�� �������Ѵ�. (==ActionForward)
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	
}
