package test;

public class Member {
	// 생성자 오버로딩
	public Member() {
		name="홍길동";
		email="hong@naver.com";
	}
	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	private String name;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
