package test;

public class AppleWatch implements Watch{

	public AppleWatch() {
		System.out.println("���ÿ�ġ �⺻������ ȣ���");
	}
	
	
	@Override
	public void soundUp() {
		System.out.println("���ÿ�ġ�� �Ҹ���!");
		
	}

	@Override
	public void soundDown() {
		System.out.println("���ÿ�ġ�� �Ҹ��ٿ�!");
		
	}

}
