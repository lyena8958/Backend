package day59_0927;
/* 결합도가 낮은 상태
public class GaPhone {
	public void soundUp() {
		System.out.println("소리 +=10");
	}
	public void soundDown() {
		System.out.println("소리 -=10");		
	}
	public void turnOn() {
		System.out.println("전원 켜짐");
	}
	public void turnOff() {
		System.out.println("전원 꺼짐");
	}
}
*/


public class GaPhone implements Phone {
	@Override
	public void powerOn() {
		System.out.println("전원 켜짐");
	}
	@Override
	public void powerOff() {
		System.out.println("전원 꺼짐");
	}
	@Override
	public void volumeUp() {
		System.out.println("소리 +=10");
	}
	public void volumeDown() {
		System.out.println("소리 -=10");
	}

}