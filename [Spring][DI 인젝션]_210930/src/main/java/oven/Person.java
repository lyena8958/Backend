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
		
		
	}

	
	
}
