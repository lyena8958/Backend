package oven;

import java.util.Map;

//B�� ����
public class B_Oven implements Oven{

	// ������ �������
	private App app;
	
	private Map map;
	
	// getter, setter
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void setApp(App app) {
		this.app = app;
	}
	//������
	public B_Oven(){
		System.out.println("��B���� �⺻������ �����ϴ�.��");
	}
	public B_Oven(App remote) {
		this.app = remote;
		System.out.println("��B���� ������ �����ϴ�.��");
	}

	@Override
	public void startSound() {
		System.out.println("�۵��� �����մϴ�.");

	}

	// ������ �۵�(�ð�++)
	@Override
	public void btnTimePlus() {
		app.btnTimePlus();

	}
	// ������ �۵�(�ð�--)
	@Override
	public void btnTimeMinus() {
		app.btnTimePlus();

	}

	@Override
	public void endSound() {
		System.out.println("�۵��� ����˴ϴ�.");

	}

}
