package com.lee.app.common;

//공통로직을 따로 빼두어 관점을 분리하자
// 로깅처리를 할 때마다 사용할 Class
public class LogAdvice { // Advice를 보고 로그를처리하는 횡단관심임을 알 수 있게됨
	public void printLog() {
		System.out.println("비즈니스 메서드를 수행하기 전에 출력되는 로그!");
		// 직접입력한 로깅은 대문자로 바꾸라하면 n개를 모두 수정해야한다.
		//  → 멘트를 바꾸고싶을 때 메서드에서만 변경하면 모두 바뀐다 -> 높은 응집도
		//    → 하지만 태생적으로 객체지향프로그램(OOP)이기 때문에, 멤버변수 개념을 쓸적에 바뀔 수 밖에없고 그때문에 호출한 부분에서는 바뀌어야할 게많다.
	}
}
// 로깅을 할 때, 출력문구를 변경해야 할일이있으면 하나씩 변경해야하기 때문에
// 이를 클래스로 정의하여 결합도를 낮추자!