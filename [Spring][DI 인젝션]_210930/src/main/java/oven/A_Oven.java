package oven;

// A사 오븐
public class A_Oven implements Oven{
	
	// 리모컨 멤버변수
	private App app;
	
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
