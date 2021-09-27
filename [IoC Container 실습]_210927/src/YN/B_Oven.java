package YN;

//B사 오븐
public class B_Oven implements Oven{

	@Override
	public void startSound() {
		System.out.println("작동을 시작합니다.");
		
	}

	@Override
	public void btnTime() {
		System.out.println("+=5");
		
	}

	@Override
	public void endSound() {
		System.out.println("작동이 종료됩니다.");
		
	}
	
}
