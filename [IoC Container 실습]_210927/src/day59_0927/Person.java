package day59_0927;

public class Person {
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
	// 결합도가 매우 높은 상태.
		// 사용자 기존 휴대폰
		//IPhone iphone = new IPhone();
		/*iphone.powerOn();
		iphone.volumeUp();
		iphone.volumeOff();
		iphone.powerOff();*/
		
		// 사용자가 휴대폰을 바꿀 때 ↓
		/*GaPhone GaPhone = new GaPhone();
		GaPhone.turnOn();
		GaPhone.soundDown();
		GaPhone.soundUp();
		GaPhone.turnOff();*/
		
	// 결합도를 낮춘 상태		// 다형성적용 = new IPhone();로 적용가능!!! 
		//1) Phone phone= new IPhone();
		
		//2)
		Phone phone = (Phone)factory.getBean(args[0]); 
		phone.powerOn();
		phone.volumeDown();
		phone.volumeUp();
		phone.powerOff();
		
		
		
	}
}	
