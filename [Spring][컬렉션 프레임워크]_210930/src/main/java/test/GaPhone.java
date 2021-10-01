package test;

public class GaPhone implements Phone{
	
	private Watch watch; // 유지보수를 높이기위해서 결합도를 낮추기 위해 부모를 멤버변수로 두었다.
	// ↑ 이를 부모 인터페이스로 수정해보자! (결합도를 낮추기 위함)
	
// 결합도가 너무 높다. appleWatch로 사용하고 싶을 때, 객체교체가 어렵다.
	//private SmartWatch sw;
	
	public GaPhone() {
		System.out.println("갤럭시 기본생성자 호출됨");
	}
	// 결합도가 낮은 코드
	// 해당 생성자가 없었다면, new가 되지않아 아래 메서드 호출시 널 인셉션오류가 발생된다.
	public GaPhone(Watch watch) {
		this.watch = watch;
		System.out.println("갤럭시 생성자 호출됨");
	}
	/* 결합도가 높은 코드
	public GaPhone(SmartWatch watch) {
		this.watch = watch;
		System.out.println("갤럭시 생성자 호출됨");
	}
	*/
	
	@Override
	public void power() {
		System.out.println("갤럭시 전원!");
		
	}

	@Override
	public void soundUp() {
		//SmartWatch sw = new SmartWatch(); --> 멤버변수 대체
		watch.soundUp();
		//System.out.println("갤럭시 소리업!");
		// 기능이라고 생각했을때 sw로 대체함에 따라 효율적으로 사용이 가능하다.
		
	}

	@Override
	
	public void soundDown() {
		//SmartWatch sw = new SmartWatch(); --> 멤버변수 대체
		watch.soundDown();
		System.out.println("갤럭시 소리다운");
		
	}

}
