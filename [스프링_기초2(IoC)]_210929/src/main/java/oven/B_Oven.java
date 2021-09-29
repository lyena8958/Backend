package oven;

//B�� ����
public class B_Oven implements Oven{

	// ������ �������
	private App remote;

	//������
	public B_Oven(){
		System.out.println("��B���� �⺻������ �����ϴ�.��");
	}
	public B_Oven(App remote) {
		this.remote = remote;
		System.out.println("��B���� ������ �����ϴ�.��");
	}

	@Override
	public void startSound() {
		System.out.println("�۵��� �����մϴ�.");

	}

	// ������ �۵�(�ð�++)
	@Override
	public void btnTimePlus() {
		remote.btnTimePlus();

	}
	// ������ �۵�(�ð�--)
	@Override
	public void btnTimeMinus() {
		remote.btnTimePlus();

	}

	@Override
	public void endSound() {
		System.out.println("�۵��� ����˴ϴ�.");

	}

}
