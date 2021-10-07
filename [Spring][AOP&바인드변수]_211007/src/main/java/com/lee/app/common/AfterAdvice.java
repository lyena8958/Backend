package com.lee.app.common;

// aspectj -> ������� ������ ��(pom.xml)
import org.aspectj.lang.JoinPoint;

/*�ٽɰ��� "��"�� ȣ���
Ȥ�ö� �ٽɰ����߿� ���ܰ� �߻��ص� ȣ���*/

// �����������̳ʰ� JoinPoint�� ��ü�� �����
// �޼��� ������ü�� jp�� �ްԵȴ�.
//JoinPoint���� ��� ���ε庯���̴�.
public class AfterAdvice {
	public void printLog(JoinPoint jp) { // JoinPoint �ٽɰ��� ������ �� �� ����
		//jp.getSignature()
		Object[] args = jp.getArgs(); //20% ���
		String name = jp.getSignature().getName(); //80% ��� - getSignature == ��ǲ, �ƿ�ǲ�� �� �� �ְԵ�
		
		
		System.out.println("�޼���� : "+ name);
		System.out.println("�Ű��������� : "+ args[0]);
		System.out.println("�ٽɰ��� �Ŀ� ȣ���");
	}
}
// �Լ��� �޸𸮸� �����ִ�.