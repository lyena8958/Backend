package day42_0825;
//쌩 자바코드

//관심분리 현상 --> 스프링에서 한번 더 할거임
/*
: concern 분리
-> 기능을 따로따로 보관
 == 협업유리
 == 유지보수 편리
기능보관한 클래스파일 -> 모듈 == 컴포넌트 == 빈즈 : Model Part*/
public class Calc_1 {
	
	int result;
	
	// 누군가 이것을 생성했다면 멤버변수가 필요로한것이다. --> getter
	public Calc_1(int num1, int num2, String op) {		
		if(op.equals("+")) {
			result = num1+num2;
		}
		else if(op.equals("-")) {
			result = num1-num2;
		}
	}

	public int getResult() {
		return result;
	}
	
	
}
