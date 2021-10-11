package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import model.member.MemberVO;

/*get()�� �Բ� ����(return�̹Ƿ� getter���� ����� �ȴ�.)
after���� ���� �����*/

// new�� ���ߴµ� new�� �Ǿ��ִ°�, ���ε庯���̴�. jp, obj
@Service // @Component(������Ʈ)�� ��ӹ��� ������̼�
@Aspect
public class AfterReturningAdvice {
	
	// ����Ʈ �� ����
/*	@Pointcut("execution(* model.member.*Impl.get*(..))")
	public void cPointcut() {}
	*/
	
	// 
	//����� @After(pointcut="bPointcut()")�� �����Ǿ��ִ����� �ٽ� Ǯ��� ->  ��? ���ε庯������ ���Ǹ� ���־���ϱ� ����
	@AfterReturning(pointcut="PointcutCommon.cPointcut()", returning="obj")
	public void printLog(JoinPoint jp, Object obj) {
		
		String name = jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		//System.out.println(obj);
		// �����̽��� ��Ŷ� ����Ǿ� ������ �𸣱� ������, �׷��� �̸� ���������� (����������!!)
		
		if(obj instanceof MemberVO) { // ĳ���� ���ɿ��� instanceof
			MemberVO data = (MemberVO)obj;
			// ĳ������ �����ϸ� �Ʒ� ����
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			}
			else {
				System.out.println("�Ϲݻ���� �α���");
			}
		}
		

		System.out.println("get()�� ���յǴ� returning");
	}
}
