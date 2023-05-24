package org.ass.flipkart.repository;

import java.util.Date;

import org.ass.flipkart.dto.OrderDto;
import org.ass.flipkart.entity.OrderEntity;
import org.ass.flipkart.entity.ProductEntity;
import org.ass.flipkart.entity.StockEntity;
import org.ass.flipkart.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrderRepository {
	
	public void saveOrUpdate(OrderEntity orderEntity) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(orderEntity);
		transaction.commit();
	}
	
	public OrderEntity findById(long id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		OrderEntity entity = session.get(OrderEntity.class, id);
		return entity;
	}
	
	public void updateOrder(OrderDto orderDto) {
		OrderEntity orderEntity = findById(orderDto.getAltKey());
		if(orderEntity!=null) {
			orderEntity.setProductId(orderDto.getProductId());
			orderEntity.setQuantity(orderDto.getQuantity());
			orderEntity.setPaymentMode(orderDto.getPaymentMode());
			saveOrUpdate(orderEntity);
		}
	}
	
	public void saveOrderInfo(OrderDto orderDto) {
		ProductEntity productEntity = new ProductRepository().findProductById(orderDto.getProductId());
		StockEntity stockEntity = new ProductRepository().findStockById(orderDto.getProductId());
		if(productEntity!=null && orderDto.getQuantity()<=stockEntity.getQuantity()) {
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setProductId(orderDto.getProductId());
			orderEntity.setQuantity(orderDto.getQuantity());
			orderEntity.setTotalPrice(productEntity.getPrice()*orderDto.getQuantity());
			orderEntity.setSoldDate(new Date());
			orderEntity.setPaymentMode(orderDto.getPaymentMode());
			saveOrUpdate(orderEntity);
			
			stockEntity.setQuantity(stockEntity.getQuantity()-orderDto.getQuantity());
			new ProductRepository().saveOrupdate(stockEntity);
		}
	}
	
}
