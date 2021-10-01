package test;

import org.springframework.stereotype.Component;

//@Component("bow")	 // 변경이 잦은 코드로, xml 빈으로 설정해서 사용하자!
//@Component() 타입을 확인하므로 id입력하지 않아도 가능	
public class Bow implements Weapon{

	@Override
	public void attack() {
		System.out.println("원거리 공격-");
		
	}

}
