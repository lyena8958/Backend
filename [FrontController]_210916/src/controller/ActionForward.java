package controller;

// 페이지전달방식, 경로(페이지명)
public class ActionForward {
	
	// 페이지 전달방식
	private boolean redirect; //redirect는 정보를 주로 안넣을 때 사용된다. (정보를 줄 때에는 url Query를 이용하면 됨 control.jsp?action...)
	// true
	// false == forward방식을 사용(전달할 정보가 많을 때 request사용 등)
	
	// 경로
	private String path;
	
	
	//boolean은 get이 아닌 is로 명칭이 상이하다. (기존 자바에서 isEmpty..도 이런경우!)
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
