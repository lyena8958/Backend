package oven;

import java.util.List;

// A사 오븐
public class A_Oven implements Oven{
	
	// 리모컨 멤버변수
	private App app;
	// 컬렉션 프레임워크 
	private List<String> list; // 오븐 사용예시 메뉴판
	
	
	
	// getter, setter
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void setApp(App app) {
		this.app = app;
	}
	
	
	//생성자
	public A_Oven(){
		System.out.println("★A오븐 기본생성자 켜집니다.★");
	}
	public A_Oven(App app) {
		this.app = app;
		System.out.println("★A오븐 생성자 켜집니다.★");
	}
	
	
	
	@Override
	public void startSound() {
		System.out.println("삐이");
		
	}

	// 리모컨 작동(시간++)
	@Override
	public void btnTimePlus() {
		app.btnTimePlus();
		
	}

	// 리모컨 작동(시간--)
	@Override
	public void btnTimeMinus() {
		app.btnTimeMinus();
		
	}
	
	@Override
	public void endSound() {
		System.out.println("삑삑");
		
	}

}
