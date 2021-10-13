package com.lee.app.common;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import model.member.MemberVO;

@Service
@Aspect
public class AfterReturning {

	@org.aspectj.lang.annotation.AfterReturning(pointcut="PointcutCommon.cPointcut()", returning="obj")
	public void printLog(Object obj) {
		
		if(obj instanceof MemberVO) {
			MemberVO data = (MemberVO)obj;
			
			if(data.getRole().equals("USER")) {
				System.out.println("����� �α���");
			}
			else {
				System.out.println("������ �α���");
			}
		}
		
		
	}
	
}
