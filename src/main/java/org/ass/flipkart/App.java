package org.ass.flipkart;

import org.ass.flipkart.dto.OrderDto;
import org.ass.flipkart.dto.ProductDto;
import org.ass.flipkart.repository.OrderRepository;
import org.ass.flipkart.repository.ProductRepository;

public class App {
	public static void main(String[] args) {
		
//		ProductDto dto = new ProductDto();
//		dto.setName("jeans");
//		dto.setProductType("cotton");
//		dto.setPrice("900");
//		dto.setDescription("good fabric");
//		dto.setManufactureDate("25/8/2010");
//		dto.setQuantity("20");
//		
//		ProductRepository repository = new ProductRepository();
//		repository.prepareProductAndStockInfo(dto);
		
		OrderDto dto = new OrderDto();
		dto.setProductId(1);
		dto.setQuantity(2);
		dto.setPaymentMode("online");
		
		OrderRepository repository = new OrderRepository();
		repository.saveOrderInfo(dto);
		
	}
}