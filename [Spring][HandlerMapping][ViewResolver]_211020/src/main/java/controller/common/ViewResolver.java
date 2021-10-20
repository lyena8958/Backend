package controller.common;

// 핸들러맵핑은 생성자로 초기화로 하는 반면,
// ViewResolver는 Setter로 초기화한다.
public class ViewResolver {
	
	//머릿말
	public String prefix; // head
	//꼬릿말
	public String suffix; // tail
	
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// 컨트롤러가 수행을 마치면, 어디로 가야하는지 정보를 주는 것
	//  └컨트롤러의 결과물
	public String getView(String view) {
		return prefix+view+suffix;
	}
	
	
}
