package com.lee.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
//ProceedingJoinPoint�� aop:config���� �����������?
// �׽����� �� �ַ� ���� (�ڿ�Ȯ��, ����ð�(6������~10������)
public class AroundAdvice { //Ŭ���̾�Ʈ�� ����ϴ� �޼���(�ٽɰ���)�� ����è -> �Ű������� �޾ƾ� �Ѵ�. 
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("pjp���ڸ� ���� �޼��忡�� ����ϴ� ����-1");
		System.out.println("�޼����: "+pjp.getSignature().getName());
		
		StopWatch sw = new StopWatch(); // �����������ӿ�ũ���� ����
		
		sw.start(); // 1. ����
		
		//�޼��� ������ ��ȯ���� �ްԵȴ�.
		Object obj = pjp.proceed(); // ���⼭ DAO�� �����ϰ� �ȴ�. // 2. ����
		//System.out.println(pjp);
		sw.stop(); // 3. ����
		
		System.out.println("�ҿ�ð� : "+sw.getTotalTimeMillis()); // ����ð� Ȯ��
		System.out.println("pjp���ڸ� ���� �޼��忡�� ����ϴ� ����-2");
		return obj;
	}
}
