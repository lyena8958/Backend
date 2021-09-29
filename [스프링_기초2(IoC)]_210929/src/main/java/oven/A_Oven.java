package oven;

// A사 오븐
public class A_Oven implements Oven{
	
	// 리모컨 멤버변수
	private App remote;
	
	//생성자
	public A_Oven(){
		System.out.println("★A오븐 기본생성자 켜집니다.★");
	}
	public A_Oven(App remote) {
		this.remote = remote;
		System.out.println("★A오븐 생성자 켜집니다.★");
	}
	
	
	
	@Override
	public void startSound() {
		System.out.println("삐이");
		
	}

	// 리모컨 작동(시간++)
	@Override
	public void btnTimePlus() {
		remote.btnTimePlus();
		
	}

	// 리모컨 작동(시간--)
	@Override
	public void btnTimeMinus() {
		remote.btnTimeMinus();
		
	}
	
	@Override
	public void endSound() {
		System.out.println("삑삑");
		
	}

}
