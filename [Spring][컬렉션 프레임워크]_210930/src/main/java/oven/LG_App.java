package oven;

public class LG_App implements App{
	public LG_App(){
		System.out.println("LG 앱 실행~!!!");
	}

	@Override
	public void btnTimePlus() {
		System.out.println("L_5분 추가");
		
	}

	@Override
	public void btnTimeMinus() {
		System.out.println("L_5분 감소");
		
	}

}
