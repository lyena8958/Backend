package model;

public class ProductBean {

   private String[] product= {"아이폰","에어팟","갤럭시", "버즈"};
   private int[] price= {10000,5000,7000,4000};
   private int total=0;
   
   public String[] getProduct() {
      return product;
   }
   public String getIndexProduct(int index) {
	      return product[index];
   }
   
   public int[] getPrice() {
      return price;
   }
   public int getIndexPrice(int index) {
	      return price[index];
   }
   
   public void totalPrice(String name,int cnt) {
		
		for(int i = 0; i <product.length; i++) {
			if(product[i].equals(name)) {
				this.total += price[i]*cnt;
			}
			System.out.println(total);
		}
      
   }
   
	public int getTotal() {
		return this.total;
	}
   
}