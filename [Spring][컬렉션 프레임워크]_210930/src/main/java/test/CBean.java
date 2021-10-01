package test;

import java.util.List;
import java.util.Map;

public class CBean {
	
	// 컬렉션 프레임워크로 활용해보자!
	private List<String> list;
	private Map<String,String> map;
	
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	
}
