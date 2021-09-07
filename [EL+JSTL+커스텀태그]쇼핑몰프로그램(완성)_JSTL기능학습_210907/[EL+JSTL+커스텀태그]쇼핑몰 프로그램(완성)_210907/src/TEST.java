import java.util.ArrayList;

import model.product.ProductVO;

public class TEST {

	public static void main(String[] args) {
			ArrayList<String> data = new ArrayList<String>();
			
			data.add("11");
			data.add("22");
			data.add("33");
			
			for(String vo : data) {
				System.out.println(vo);
			}
			System.out.println("====================");
			data.remove(0);
			
			for(String vo : data) {
				System.out.println(vo);
			}
	}

}
