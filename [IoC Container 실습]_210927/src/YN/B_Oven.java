package YN;

//B�� ����
public class B_Oven implements Oven{

	@Override
	public void startSound() {
		System.out.println("�۵��� �����մϴ�.");
		
	}

	@Override
	public void btnTime() {
		System.out.println("+=5");
		
	}

	@Override
	public void endSound() {
		System.out.println("�۵��� ����˴ϴ�.");
		
	}
	
}
