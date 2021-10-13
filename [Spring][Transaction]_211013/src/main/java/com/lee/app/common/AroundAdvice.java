package com.lee.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

	@Around("PointcutCommon.bPointcut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		
		StopWatch sw = new StopWatch();
		
		sw.start();
	
		Object obj = pjp.proceed();
	
		sw.stop();
		
		System.out.println("����ð� : "+sw.getTotalTimeSeconds()+"\n"); // start~stop������ �ҿ�ð�
		
		
		return obj;
	}
	
}
