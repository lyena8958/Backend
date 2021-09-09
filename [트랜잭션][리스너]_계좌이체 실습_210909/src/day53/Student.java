package day53;

//VO격
public class Student {
	// 생성자에서 멤버변수를 설정하므로 setter는 사용 xx
	public Student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	private String name;
	private int score;
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

}
