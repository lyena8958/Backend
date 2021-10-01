package test;

// 챔프는 모두 동일한 기능을 부여 하기위함--> Interface
//  └낮은결합도, 로직분리, *유지보수 용이
public interface ChampAction {
	void attack();
	void print();
}
