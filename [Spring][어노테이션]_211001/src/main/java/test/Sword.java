package test;

import org.springframework.stereotype.Component;

// ������Ʈ ��ĵ�� ���� ������̼� ����(������Ʈ ��ĵ�ϰ� �Ǿ� S�������� �ٴ´�.)
//@Component() == <bean class="test.Sword"> > id����� �θ� �� ����.
/*@Component("sword")*/	// <bean class="test.Sword" id="sword"> // ������ ���� �ڵ��, xml ������ �����ؼ� �������!
public class Sword implements Weapon{

	@Override
	public void attack() {
		System.out.println("������ ����");
		
	}

}
