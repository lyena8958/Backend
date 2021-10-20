package controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class B_Main_Controller implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println();

//ActionForward forward = new ActionForward();

		// board List
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> datas = bdao.getListBoard(new BoardVO());

		String indexStr =request.getParameter("index");
		int index = 0;
		
		// ����ڿ��� ����� Board list
		List<BoardVO> result = new ArrayList<BoardVO>();

		int boardIndex; // ����¡ �ѹ�ȣ
		int limit = 0;
		if(!(indexStr==null||indexStr.equals("1"))) {
			// �ε��� - ������ ����  // 2������ ��û -> datas.get(11 ~~ 20)���� ������add
			index = (Integer.parseInt(request.getParameter("index"))-1)*10;		

			System.out.println("datas" + datas.size());
			System.out.println("index "+index);
			
			for(int i = index; i < index+(datas.size()-index); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) { // ���ѹ�������
					break;
				}
			}
			boardIndex = index+1;

		}
		else {
			limit = 0;
			for(int i = 0; i < datas.size(); i++) {
				result.add(datas.get(i));
				limit++;
				if(limit==10) {
					break;
				}
			}
			boardIndex= 1;
		}

		// ����¡ index
		ArrayList j = new ArrayList();
		j.add(1);
		for(int i = 1; i < datas.size(); i++) {
			if(i%10==0) {
				j.add(j.size()+1);
			}
		}

		request.setAttribute("indexx", j);
		request.setAttribute("datas", result);
		request.setAttribute("boardIndex", boardIndex);

/*forward.setRedirect(false);
forward.setPath("main.jsp");*/


		return "main";
	}

}
