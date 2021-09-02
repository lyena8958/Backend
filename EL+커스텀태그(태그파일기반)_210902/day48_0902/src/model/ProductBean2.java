package model;

// 강사님
public class ProductBean2 {

   private String[] product= {"아메리카노","카페라떼","프라푸치노"};
   private int[] price= {2000,2500,5000};
   public String[] getProduct() {
      return product;
   }
   public int[] getPrice() {
      return price;
   }
   
   public int calc(String name,int cnt) {
      int total=0; // 사용자가 직접입력하지않는 데이터 -> 초기화 필수대상!
      
      for(int i=0;i<product.length;i++) {
         if(product[i].equals(name)) {
            total=price[i]*cnt;
         }
      }   
      
      return total;
   }
   
}