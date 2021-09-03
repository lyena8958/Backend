package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.DataBean;

public class MsgTagHandler extends SimpleTagSupport{
	
	// 기존 커스텀태그(파일기반)에서 사용한 Attribute가
	//== 멤버변수 인 것이다.
	private String bgcolor;
	private String border;
	
	
	// 시작태그가 불러오면 호출되는 메서드 == doTag()
	public void doTag() throws IOException, JspException {
		//내장객체가 out이니 이름을 맞춰주자
		JspWriter out = getJspContext().getOut(); 
		//out은 출력하는 용도로 자바에서System==콘솔에서 out 쓰겠다는 것이고
		// 여기서는 http 내에서 사용하겠다 라는 것이다.
		// 객체명은 지정해서 사용해도 상관없으나, 모두 출력용도로는 out을 쓰기 때문에 권장!!
		
		//태그바디를 가져오는 메서드 == getJspBody
		JspFragment body = getJspBody();
		
		//태그바디가 있다면,(사용자가 쓸 수도있고, 안쓸 수도 있다. (안쓰면 invoke에서 오류남)
		if(body!=null) { 
			// out이라는 내장객체에 body내용을 넣겠다.
			
			out.println("<h1>");
			
			body.invoke(null); // out으로 작성할 text가 없기때문에 null로 대체
			//└> body.invoke(Writer out); //writer를 안넣기 때문에 null로 대체
			// null == 사용자가 입력한 바디태그 내용을 그대로 쓴다는 의미
			// body가 수행 하는 것이니 여기서 body가 null이면 널포인트인셉션 오류가 발생하므로 위에서 if문을 걸러준 것이다.
			
			out.println("</h1>");
		}
		
		
		
		DataBean db = new DataBean();
		
		// 스트링버퍼를 이용해보자! -> 일의 효율성, 성능 ↑↑
				//버퍼 : str사용시 println으로 버퍼 정리해준 것과 같은 의미의 버퍼
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=").append(border).append(" bgcolor=").append(bgcolor).append(">");
		out.println(sb.toString());
		
		// ※ 주의사항 : 실 HTML코드처럼 "속성 앞"에 띄어쓰기를 지키자
		/*
		out.println("");
		out.println(border);
		out.println(" bgcolor=");     --> 45Line 대체
		out.println(bgcolor);
		out.println(">");*/
		for(String v: db.getDataList()) {
			out.println("<tr><td>"+v+"</td></tr>");
		}
		//out.println("</table>");
	}
	
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	public String getBorder() {
		return border;
	}
	public void setBorder(String border) {
		this.border = border;
	}
	
	
}
