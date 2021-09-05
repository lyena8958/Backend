package model_menuVO;

public class Menu {
	public Menu(String menuName, int price){
		this.menuName = menuName;
		this.price = price;
	}
	
	private String menuName;
	private int price;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
