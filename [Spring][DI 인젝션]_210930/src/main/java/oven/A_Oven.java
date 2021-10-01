package oven;

// A�� ����
public class A_Oven implements Oven{
	
	// ������ �������
	private App app;
	
	public void setApp(App app) {
		this.app = app;
	}
	//������
	public A_Oven(){
		System.out.println("��A���� �⺻������ �����ϴ�.��");
	}
	public A_Oven(App app) {
		this.app = app;
		System.out.println("��A���� ������ �����ϴ�.��");
	}
	
	
	
	@Override
	public void startSound() {
		System.out.println("����");
		
	}

	// ������ �۵�(�ð�++)
	@Override
	public void btnTimePlus() {
		app.btnTimePlus();
		
	}

	// ������ �۵�(�ð�--)
	@Override
	public void btnTimeMinus() {
		app.btnTimeMinus();
		
	}
	
	@Override
	public void endSound() {
		System.out.println("���");
		
	}

}
