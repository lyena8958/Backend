package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // @Component(컴포넌트)를 상속받은 어노테이션
@Aspect // 결합이 완료되었음을 알려줌
public class LogAdvice {
	/*@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void cPointcut() {} // id역할
*/	
	@Before("PointcutCommon.cPointcut()")
	public void printLog() {
		System.out.println("비즈니스 메서드를 수행하기 전에 출력되는 로그!");

	}
}

// 1. get*()수행시에만
// 2. 해당 핵심관심 이전에 수행될 수 있도록
// 3. LogAdvice의 pointLog()가! 
