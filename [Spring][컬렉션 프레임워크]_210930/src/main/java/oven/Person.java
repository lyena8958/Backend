package oven;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Person {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Oven oven = (Oven)factory.getBean("oven");
		System.out.println("--------------------------------------\n\n");
		
		oven.startSound();
		oven.btnTimePlus();
		oven.btnTimeMinus();
		oven.endSound();
		System.out.println("사용예시 메뉴판\n\n");
		
		// List
		/*for(String v: ((A_Oven)oven).getList()) {
			System.out.println(v);
		}
		*/
		// Map
		System.out.println(((B_Oven)oven).getMap());
		
	}

	
	
}
