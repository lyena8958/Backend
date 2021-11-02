package model.board;

public class Client {

	public static void main(String[] args) {


		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("제에목");
		vo.setWriter("작성자아");
		vo.setContent("내애용");
		
		dao.insertBoard(vo);

	}

}
