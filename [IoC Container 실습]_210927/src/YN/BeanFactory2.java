package YN;

public class BeanFactory2 {
	public Object getBean(String ovenName) {
		if(ovenName.equals("A")) { // A사 오븐인 경우 → A객체 반환
			return new A_Oven();
		}
		else if(ovenName.equals("B")) { // B사 오븐인 경우 → B객체 반환
			return new B_Oven();
		}
		else { // 이 외, null 반환
			return null;
		}
		
	}
}
