package day59_0927;

public class Person {
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
	// ���յ��� �ſ� ���� ����.
		// ����� ���� �޴���
		//IPhone iphone = new IPhone();
		/*iphone.powerOn();
		iphone.volumeUp();
		iphone.volumeOff();
		iphone.powerOff();*/
		
		// ����ڰ� �޴����� �ٲ� �� ��
		/*GaPhone GaPhone = new GaPhone();
		GaPhone.turnOn();
		GaPhone.soundDown();
		GaPhone.soundUp();
		GaPhone.turnOff();*/
		
	// ���յ��� ���� ����		// ���������� = new IPhone();�� ���밡��!!! 
		//1) Phone phone= new IPhone();
		
		//2)
		Phone phone = (Phone)factory.getBean(args[0]); 
		phone.powerOn();
		phone.volumeDown();
		phone.volumeUp();
		phone.powerOff();
		
		
		
	}
}	
