package oven;

// Interface --> 각 오븐사 마다 기능을 통합하기 위함
public interface Oven {
	void startSound();
	void btnTimePlus();
	void btnTimeMinus();
	void endSound();
	
}
