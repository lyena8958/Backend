package day59_0927;

// ����Ŭ����
// DAO, VO ��ü����� �� �� ��� �׼��±� <jsp:useBean VO>

// DAO : ����Ͻ� �޼��带 �����ִ� ��ü
// == ���(����� �����ִ� ����)


public class BeanFactory { // ���� �����̳� ��Ĺ�� �����ϴ�. (servlet�� *.do�� ������ ��)
	public Object getBean(String beanName) {
		if(beanName.equals("Ga")) {
			return new GaPhone();
		}
		else if(beanName.equals("I")) {
			return new IPhone();
		}
		return null;
		
	}
	
	
}
