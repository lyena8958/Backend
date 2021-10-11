package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/*�ٽɰ��� "��"�� ȣ���
Ȥ�ö� �ٽɰ����߿� ���ܰ� �߻��ص� ȣ���*/

// �����������̳ʰ� JoinPoint�� ��ü�� �����
// �޼��� ������ü�� jp�� �ްԵȴ�.
//JoinPoint���� ��� ���ε庯���̴�.
@Service // @Component(������Ʈ)�� ��ӹ��� ������̼�
@Aspect // ������ �Ϸ�Ǹ� aspect�� �ۼ��Ͽ� �ν��ϰ� �ȴ�. // ������ �Ϸ�Ǿ����� �˷���
public class AfterAdvice {
	
	// aspect�� ����Ϸ���  >>����Ʈ�ư� �����̽��� �����Ͽ����Ѵ�.<<
	// �� �����̽��� �غ񰡵Ǿ� ����Ʈ�Ƹ� ������ �����ָ� �ȴ�.
	//					��
	// ���� �޼��� -> ���� Ŭ������ ���� (PointcutCommon)
	// �����̽��� ����Ʈ���� "�ĺ�"�ϱ����� �ۼ� (����Ʈǥ���� ����)
	// �ĺ��� �����̸�, ������ �ۼ����ʿ�xxx. {}�ٵ���� �������
/*	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {} // ������ �ʿ���� ������ ��ü�� �ۼ�
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {} // ������ �ʿ���� ������ ��ü�� �ۼ�
	*/
	// �����
	//@After(pointcut="bPointcut()")�� �����Ǿ��ִ���
	//@After("bPointcut()") // � ���۰� �������Ʈ���� �������� �ۼ�
	@After("PointcutCommon.bPointcut()")
	public void printLog(JoinPoint jp) {
		//jp.getSignature()
/*		Object[] args = jp.getArgs(); //20% ���
		String name = jp.getSignature().getName(); //80% ��� - getSignature == ��ǲ, �ƿ�ǲ�� �� �� �ְԵ�
		
		
		System.out.println("�޼���� : "+ name);
		System.out.println("�Ű��������� : "+ args[0]);*/
		System.out.println("�ٽɰ��� �Ŀ� ȣ���");
		
	}
}
// �Լ��� �޸𸮸� �����ִ�.