package test;
// 기능을 넣은 클래스 == 자바 빈즈
// M모델파트
public class CalcBean {
	
/*	// 외부의 접근을 막기위해 캡슐화하자
	private int mem;
	CalcBean(int mem){//무조건 mem을 초기화 해야 돼.
		this.mem = mem; 
	}
	public int getMem() {
		return mem;
	}
	public void setMem(int mem) {
		this.mem = mem;
	}
	// get, set로 접근해주는 태그가 있다..! --> NF 2
*/
	public CalcBean(){
		this.op="";
		this.result =0;
	}
	//Property를(변수명) 맟추려면! 설계가 중요하다.
	private int num1;
	private int num2;
	private String op;
	private int result;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}

	
	// 기능에 해당하는 부분
	// 이 기능을 수행해야 뷰에서 계싼결과를 봄 --> NF2
	public void calculate() {
		if(this.op.equals("+")) {
			this.result = this.num1+this.num2;
		}
		else if(this.op.equals("-")) {
			this.result = this.num1-this.num2;
		}
		
	}
	
	
	
	
	
	
}
