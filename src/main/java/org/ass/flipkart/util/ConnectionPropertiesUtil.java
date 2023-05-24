package org.ass.flipkart.util;

import java.util.Properties;

public class ConnectionPropertiesUtil {
	
public static Properties getMyDbProperties() {
		
		Properties properties = new Properties();
		properties.setProperty("connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/config_db");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "tiger");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
}
