package control.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;

public interface Action {
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
