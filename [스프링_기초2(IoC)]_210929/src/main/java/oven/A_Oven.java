package oven;

// A�� ����
public class A_Oven implements Oven{
	
	// ������ �������
	private App remote;
	
	//������
	public A_Oven(){
		System.out.println("��A���� �⺻������ �����ϴ�.��");
	}
	public A_Oven(App remote) {
		this.remote = remote;
		System.out.println("��A���� ������ �����ϴ�.��");
	}
	
	
	
	@Override
	public void startSound() {
		System.out.println("����");
		
	}

	// ������ �۵�(�ð�++)
	@Override
	public void btnTimePlus() {
		remote.btnTimePlus();
		
	}

	// ������ �۵�(�ð�--)
	@Override
	public void btnTimeMinus() {
		remote.btnTimeMinus();
		
	}
	
	@Override
	public void endSound() {
		System.out.println("���");
		
	}

}
