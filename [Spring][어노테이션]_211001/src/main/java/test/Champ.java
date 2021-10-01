package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// implements함으로써 아래 두가지 방안이 있다.
// 	1) 추상클래스화(자식에게 강제할 수 있음) - 다만 추상클래스는 객체화가 불가하다.
// 	2) 오버라이딩

// 기본 생성자가 있는 상황 (디폴트)
@Component("champ") // 이름으로 의존성을 부여해준다.
public class Champ implements ChampAction{
	
	// 인스턴스 변수
	private String name; // 닉네임
	private List<String> inven; // 인벤토리
	//@Autowired //컨테이너는 자신이 만들어 두었던 객체들의 "타입"을 확인! ★의존성주입(객체간의 결합관계를 컨테이너가 관리)★
	// 이름으로 구분했으면 좋겠다 해서 Resource 등장
	@Resource(name="bow") // 타입과 이름을 구분하게된다. xml - @ 병행설정
	private Weapon weapon; // 무기
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInven() {
		return inven;
	}
	public void setInven(List<String> inven) {
		this.inven = inven;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	@Override
	public void attack() {
		// 개발자 입장에서는 널포인터익셉션(예외) 발생우려가 있으니, new를 했어야 했다
		// 	-> 멤버변수로 처리, 생성자(인젝션) 주입
		//	-> setter 주입으로 변경(기본 생성자가 필요!)
		weapon.attack();
		
	}
	@Override
	public void print() {
		System.out.println(name);
		
		for(String v:inven) {
			System.out.println(v);
		}
	}
	
	
	
	
}
