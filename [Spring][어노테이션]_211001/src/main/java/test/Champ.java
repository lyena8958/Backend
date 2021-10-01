package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// implements�����ν� �Ʒ� �ΰ��� ����� �ִ�.
// 	1) �߻�Ŭ����ȭ(�ڽĿ��� ������ �� ����) - �ٸ� �߻�Ŭ������ ��üȭ�� �Ұ��ϴ�.
// 	2) �������̵�

// �⺻ �����ڰ� �ִ� ��Ȳ (����Ʈ)
@Component("champ") // �̸����� �������� �ο����ش�.
public class Champ implements ChampAction{
	
	// �ν��Ͻ� ����
	private String name; // �г���
	private List<String> inven; // �κ��丮
	//@Autowired //�����̳ʴ� �ڽ��� ����� �ξ��� ��ü���� "Ÿ��"�� Ȯ��! ������������(��ü���� ���հ��踦 �����̳ʰ� ����)��
	// �̸����� ���������� ���ڴ� �ؼ� Resource ����
	@Resource(name="bow") // Ÿ�԰� �̸��� �����ϰԵȴ�. xml - @ ���༳��
	private Weapon weapon; // ����
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInven() {
		return inven;
	}
	public void setInven(List<String> inven) {
		this.inven = inven;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	@Override
	public void attack() {
		// ������ ���忡���� ���������ͼ���(����) �߻������ ������, new�� �߾�� �ߴ�
		// 	-> ��������� ó��, ������(������) ����
		//	-> setter �������� ����(�⺻ �����ڰ� �ʿ�!)
		weapon.attack();
		
	}
	@Override
	public void print() {
		System.out.println(name);
		
		for(String v:inven) {
			System.out.println(v);
		}
	}
	
	
	
	
}
