package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BodyTagHandler extends SimpleTagSupport {
	
	private String bgcolor;
	private String fontSize;

	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	
	public void doTag() throws IOException, JspException {
		
		JspWriter out = getJspContext().getOut();
		JspFragment body = getJspBody();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<h4 style='background-color:").append(bgcolor).append("; font-size:").append(fontSize).append(";'>");
		out.println(sb.toString());
		
		//사용자가 태그바디를 입력했다면 → 제목 출력 
		if(body!=null) {
			System.out.println(sb.toString());
			body.invoke(null);
		}
				
		out.println("</h4>");
		
	}

}
