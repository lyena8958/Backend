package tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//커스텀태그를 처리하는 자바클래스를 상속하여 구현(extends)
//	└SimpleTagSupport 클래스를 상속
public class TestTagHandler extends SimpleTagSupport {
	
	//개발자가 정의한 메서드는 사용하지 않는다.
	//SimpleTagSupport에서 상속받은 기능(메서드)들만 사용을한다.
	// 왜냐하면 tld를 사용하기 위해서 만든 클래스이기 때문이다.
	
	
	// 실제 태그의 기능을 정의하는 메서드 >>기능적으로 시작태그를 만나자마자 호출을 해주는 방식이다.<<
	// 시작태그를 만나면 호출됨		// 호출한 쪽에서 예외처리 미루기
	public void doTag() throws IOException{
		
		// JSP로부터 정보를 받아올 수 있게하는 메서드 == getJSPContext
		// getJSPContext에서 가장많이 사용하는 메서드는 getOut() 이다.
		// getOut() : out객체를 참조할 때 사용
		// 이때 JspWriter로 반환을 해준다.
		JspWriter out = getJspContext().getOut();
		out.println("태그 핸들러 클래스기반 실습중!");
				
	}
	
}
