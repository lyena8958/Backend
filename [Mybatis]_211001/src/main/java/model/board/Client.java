package model.board;

public class Client {

	public static void main(String[] args) {


		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("������");
		vo.setWriter("�ۼ��ھ�");
		vo.setContent("���ֿ�");
		
		dao.insertBoard(vo);

	}

}
