package YN;

// ���� --> �ν��Ͻ�ȭ �� �޼��� ȣ��
public class Person2 {
	public static void main(String[] args) {
		
	// ���յ� ���߱�
		
	
		Oven oven = (Oven)new BeanFactory2().getBean(args[0]);
		
		oven.btnTime();
		oven.startSound();
		oven.endSound();
		
		
		
	}

	
	
}
