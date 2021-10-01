package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class Client {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 			부모									자식
		
		Champ champ = (Champ)factory.getBean("champ");
		champ.attack();
		/*champ.print();*/
		
		
		factory.close();//안닫아주어도 좋지만 성능상 닫아주는 것이 좋다(가비지컬렉터)
		
	}
}
