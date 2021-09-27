package YN;

// 메인 --> 인스턴스화 및 메서드 호출
public class Person2 {
	public static void main(String[] args) {
		
	// 결합도 낮추기
		
	
		Oven oven = (Oven)new BeanFactory2().getBean(args[0]);
		
		oven.btnTime();
		oven.startSound();
		oven.endSound();
		
		
		
	}

	
	
}
