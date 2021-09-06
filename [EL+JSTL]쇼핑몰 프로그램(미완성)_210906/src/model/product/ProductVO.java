package model.product;

public class ProductVO {
	
	private int pnum; // PK
	private String pName; // 상품명
	private int price; // 가격
	private int cnt; // 재고
	private int totalPay;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public int getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(int totalPay) {
		this.totalPay += totalPay;
	}
	
	@Override
	public String toString() {
		return "ProductVO [pnum=" + pnum + ", pName=" + pName + ", price=" + price + ", cnt=" + cnt + ", totalPay="
				+ totalPay + ", getPnum()=" + getPnum() + ", getpName()=" + getpName() + ", getPrice()=" + getPrice()
				+ ", getCnt()=" + getCnt() + ", getTotalPay()=" + getTotalPay() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
