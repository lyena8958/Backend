package day59_0927;
/* ���յ��� ���� ����
public class GaPhone {
	public void soundUp() {
		System.out.println("�Ҹ� +=10");
	}
	public void soundDown() {
		System.out.println("�Ҹ� -=10");		
	}
	public void turnOn() {
		System.out.println("���� ����");
	}
	public void turnOff() {
		System.out.println("���� ����");
	}
}
*/


public class GaPhone implements Phone {
	@Override
	public void powerOn() {
		System.out.println("���� ����");
	}
	@Override
	public void powerOff() {
		System.out.println("���� ����");
	}
	@Override
	public void volumeUp() {
		System.out.println("�Ҹ� +=10");
	}
	public void volumeDown() {
		System.out.println("�Ҹ� -=10");
	}

}