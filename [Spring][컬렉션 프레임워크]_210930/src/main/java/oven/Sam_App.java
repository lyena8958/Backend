package oven;

public class Sam_App implements App{
	

	public Sam_App(){ // 기본생성자
		System.out.println("sam 앱 실행~!!!");
	}

	@Override
	public void btnTimePlus() {
		System.out.println("S_5분 추가됩니다.");
		
	}

	@Override
	public void btnTimeMinus() {
		System.out.println("S_5분 감소됩니다.");
		
	}

}
