package YN;

// A�� ����
public class A_Oven implements Oven{

	@Override
	public void startSound() {
		System.out.println("����");
		
	}

	@Override
	public void btnTime() {
		System.out.println("+=1");
		
	}

	@Override
	public void endSound() {
		System.out.println("���");
		
	}

}
