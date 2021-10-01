package test;

public class IPhone implements Phone{
	
	private Watch watch;
	private int num;
	// List ex)전화번호부
	
	
	// setter
	public void setNum(int num) {
		this.num = num;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	//Iphone
	public IPhone() {
		System.out.println("아이폰 기본생성자 호출됨");
	}
	
	@Override
	public void power() {
		System.out.println("아이폰 전원 : "+num);
		
	}

	@Override
	public void soundUp() {
		watch.soundUp();
		//System.out.println("아이폰 소리++");
		
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		//System.out.println("아이폰 소리--");
		
	}

}
