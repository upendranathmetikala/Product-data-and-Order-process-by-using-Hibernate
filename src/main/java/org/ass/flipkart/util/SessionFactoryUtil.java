package org.ass.flipkart.util;

import org.ass.flipkart.entity.OrderEntity;
import org.ass.flipkart.entity.ProductEntity;
import org.ass.flipkart.entity.StockEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	
	private static SessionFactory productsessionFactory=null;
	
	private SessionFactoryUtil() {}
	
	public static SessionFactory getSessionFactory() {
		
		if(productsessionFactory==null) {
			
			Configuration cfg = new Configuration();
			cfg.setProperties(ConnectionPropertiesUtil.getMyDbProperties());
			cfg.addAnnotatedClass(ProductEntity.class);
			cfg.addAnnotatedClass(StockEntity.class);
			cfg.addAnnotatedClass(OrderEntity.class);
			return productsessionFactory = cfg.buildSessionFactory();
		}
		return productsessionFactory;	
	}

}
