package test;

public class GaPhone implements Phone{
	
	private Watch watch; // ���������� ���̱����ؼ� ���յ��� ���߱� ���� �θ� ��������� �ξ���.
	// �� �̸� �θ� �������̽��� �����غ���! (���յ��� ���߱� ����)
	
// ���յ��� �ʹ� ����. appleWatch�� ����ϰ� ���� ��, ��ü��ü�� ��ƴ�.
	//private SmartWatch sw;
	
	public GaPhone() {
		System.out.println("������ �⺻������ ȣ���");
	}
	// ���յ��� ���� �ڵ�
	// �ش� �����ڰ� �����ٸ�, new�� �����ʾ� �Ʒ� �޼��� ȣ��� �� �μ��ǿ����� �߻��ȴ�.
	public GaPhone(Watch watch) {
		this.watch = watch;
		System.out.println("������ ������ ȣ���");
	}
	/* ���յ��� ���� �ڵ�
	public GaPhone(SmartWatch watch) {
		this.watch = watch;
		System.out.println("������ ������ ȣ���");
	}
	*/
	
	@Override
	public void power() {
		System.out.println("������ ����!");
		
	}

	@Override
	public void soundUp() {
		//SmartWatch sw = new SmartWatch(); --> ������� ��ü
		watch.soundUp();
		//System.out.println("������ �Ҹ���!");
		// ����̶�� ���������� sw�� ��ü�Կ� ���� ȿ�������� ����� �����ϴ�.
		
	}

	@Override
	
	public void soundDown() {
		//SmartWatch sw = new SmartWatch(); --> ������� ��ü
		watch.soundDown();
		System.out.println("������ �Ҹ��ٿ�");
		
	}

}
