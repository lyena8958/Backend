package test;

public class AppleWatch implements Watch{

	public AppleWatch() {
		System.out.println("애플워치 기본생성자 호출됨");
	}
	
	
	@Override
	public void soundUp() {
		System.out.println("애플워치로 소리업!");
		
	}

	@Override
	public void soundDown() {
		System.out.println("애플워치로 소리다운!");
		
	}

}
