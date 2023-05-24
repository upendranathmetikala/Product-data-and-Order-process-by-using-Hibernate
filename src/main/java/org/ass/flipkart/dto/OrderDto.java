package org.ass.flipkart.dto;

import java.io.Serializable;

public class OrderDto implements Serializable{
	
	private long altKey;
	
	private int productId;
	
	private int quantity;
	
	private String paymentMode;

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quatity) {
		this.quantity = quatity;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "OrderDto [altKey=" + altKey + ", productId=" + productId + ", quantity=" + quantity + ", paymentMode="
				+ paymentMode + "]";
	}
	
	
}
