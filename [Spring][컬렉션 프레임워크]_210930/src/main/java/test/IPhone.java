package test;

public class IPhone implements Phone{
	
	private Watch watch;
	private int num;
	// List ex)��ȭ��ȣ��
	
	
	// setter
	public void setNum(int num) {
		this.num = num;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	//Iphone
	public IPhone() {
		System.out.println("������ �⺻������ ȣ���");
	}
	
	@Override
	public void power() {
		System.out.println("������ ���� : "+num);
		
	}

	@Override
	public void soundUp() {
		watch.soundUp();
		//System.out.println("������ �Ҹ�++");
		
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		//System.out.println("������ �Ҹ�--");
		
	}

}
