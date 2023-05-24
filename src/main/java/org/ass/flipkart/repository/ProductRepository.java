package org.ass.flipkart.repository;

import org.ass.flipkart.dto.ProductDto;
import org.ass.flipkart.entity.ProductEntity;
import org.ass.flipkart.entity.StockEntity;
import org.ass.flipkart.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductRepository {
	
	public Object saveOrupdate(ProductEntity productEntity) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object object = session.merge(productEntity);
		transaction.commit();
		return object;
	}
	
	public Object saveOrupdate(StockEntity stockEntity) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object object = session.merge(stockEntity);
		transaction.commit();
		return object;
	}
	
	public ProductEntity findProductById(long id) {
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		ProductEntity entity = session.get(ProductEntity.class, id);
		return entity;
	}
	
	public StockEntity findStockById(long id) {
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		StockEntity entity = session.get(StockEntity.class, id);
		return entity;
	}
	
//	
//	public void update(ProductDto productDto) {
//		ProductEntity productEntity = findProductById(productDto.getAltKey());
//		if(productEntity!=null) {
//			productEntity.setName(productDto.getName());
//			productEntity.setProductType(productDto.getProductType());
//			productEntity.setPrice(productDto.getPrice());
//			productEntity.setDescription(productDto.getDescription());
//			productEntity.setManufactureDate(productDto.getManufactureDate());
//			saveOrupdate(productEntity);
//		}
//	}
//	
//	public void delete(ProductDto productDto) {
//		ProductEntity productEntity = findProductById(productDto.getAltKey());
//		if(productEntity!=null) {
//			SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
//			Session session = sessionFactory.openSession();
//			Transaction transaction = session.beginTransaction();
//			session.delete(productEntity);
//			transaction.commit();
//		}
//	}
	
	public void prepareProductAndStockInfo(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productDto.getName());
		productEntity.setProductType(productDto.getProductType());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setDescription(productDto.getDescription());
		productEntity.setManufactureDate(productDto.getManufactureDate());
		Object object = saveOrupdate(productEntity);
		
		StockEntity stockEntity = new StockEntity();
		stockEntity.setProductId(((ProductEntity)object).getAltKey());
		stockEntity.setQuantity(productDto.getQuantity());
		
		saveOrupdate(stockEntity);
	}
	
}
