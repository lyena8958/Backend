package oven;

import java.util.List;

// A�� ����
public class A_Oven implements Oven{
	
	// ������ �������
	private App app;
	// �÷��� �����ӿ�ũ 
	private List<String> list; // ���� ��뿹�� �޴���
	
	
	
	// getter, setter
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
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
