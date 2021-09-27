package day59_0927;

// 빈즈클래스
// DAO, VO 객체만들어 낼 때 썼던 액션태그 <jsp:useBean VO>

// DAO : 비즈니스 메서드를 갖고있는 객체
// == 모듈(기능을 갖고있는 당위)


public class BeanFactory { // 서블릿 컨테이너 톰캣과 유사하다. (servlet를 *.do로 설정할 때)
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
