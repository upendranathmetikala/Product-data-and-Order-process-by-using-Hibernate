package org.ass.flipkart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="stock_info")
public class StockEntity implements Serializable{
	
	@Id
	@GenericGenerator(name="auto_gen", strategy="increment")
	@GeneratedValue(generator = "auto_gen")
	@Column(name="alt_key")
	private long altKey;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="quantity")
	private int quantity;

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long l) {
		this.productId = l;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "StockEntity [altKey=" + altKey + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
}
