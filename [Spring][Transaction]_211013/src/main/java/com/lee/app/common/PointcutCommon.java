package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* model..*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model..*Impl.*(..))") // model 하위 모두 설정
	public void bPointcut() {}
	
	@Pointcut("execution(* model.member.*Impl.getMember*(..))") // model 하위 모두 설정
	public void cPointcut() {}
}
