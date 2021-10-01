package test;

import org.springframework.stereotype.Component;

// 컴포넌트 스캔에 따른 어노테이션 설정(컴포넌트 스캔하게 되어 S아이콘이 붙는다.)
//@Component() == <bean class="test.Sword"> > id가없어서 부를 수 없다.
/*@Component("sword")*/	// <bean class="test.Sword" id="sword"> // 변경이 잦은 코드로, xml 빈으로 설정해서 사용하자!
public class Sword implements Weapon{

	@Override
	public void attack() {
		System.out.println("검으로 공격");
		
	}

}
