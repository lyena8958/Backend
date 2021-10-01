package oven;

import java.util.Map;

//B사 오븐
public class B_Oven implements Oven{

	// 리모컨 멤버변수
	private App app;
	
	private Map map;
	
	// getter, setter
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void setApp(App app) {
		this.app = app;
	}
	//생성자
	public B_Oven(){
		System.out.println("★B오븐 기본생성자 켜집니다.★");
	}
	public B_Oven(App remote) {
		this.app = remote;
		System.out.println("★B오븐 생성자 켜집니다.★");
	}

	@Override
	public void startSound() {
		System.out.println("작동을 시작합니다.");

	}

	// 리모컨 작동(시간++)
	@Override
	public void btnTimePlus() {
		app.btnTimePlus();

	}
	// 리모컨 작동(시간--)
	@Override
	public void btnTimeMinus() {
		app.btnTimePlus();

	}

	@Override
	public void endSound() {
		System.out.println("작동이 종료됩니다.");

	}

}
