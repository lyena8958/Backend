package test;

import org.springframework.stereotype.Component;

//@Component("bow")	 // ������ ���� �ڵ��, xml ������ �����ؼ� �������!
//@Component() Ÿ���� Ȯ���ϹǷ� id�Է����� �ʾƵ� ����	
public class Bow implements Weapon{

	@Override
	public void attack() {
		System.out.println("���Ÿ� ����-");
		
	}

}
