package YN;

public class BeanFactory2 {
	public Object getBean(String ovenName) {
		if(ovenName.equals("A")) { // A�� ������ ��� �� A��ü ��ȯ
			return new A_Oven();
		}
		else if(ovenName.equals("B")) { // B�� ������ ��� �� B��ü ��ȯ
			return new B_Oven();
		}
		else { // �� ��, null ��ȯ
			return null;
		}
		
	}
}
