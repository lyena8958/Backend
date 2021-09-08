package model;

public class MemberBean {
	String id[] = {"1234", "5678", "봄", "피글렛", "푸우"};
	String pw[] = {"1234", "5678", "spr", "pi", "p"};
	
	
	//로그인 체크
	public boolean loginCheck(String id, String pw) {
		
		for(int i = 0; i < id.length(); i++) {
			if(this.id[i].equals(id)&& this.pw[i].equals(pw)) {
				return true;
			}
			
		}
		
		return false;
	}
}

