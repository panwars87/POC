package com.testing.pdev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;

import com.testing.pdev.exceptions.GoogleApiUtilException;

public class DBConnection {

	private static Connection connection;
	
	private DBConnection(){}
	
	public static Connection getConnection() throws GoogleApiUtilException{
		if(connection != null){
			return connection;
		}else{
			createConnection();
			return connection;
		}
	}

	private static void createConnection() throws GoogleApiUtilException {
		//create db connection
		String db_url = PropertiesUtil.getProperty(ConstantPool.DB_URL);
		String db_username = PropertiesUtil.getProperty(ConstantPool.DB_USERNAME);
		String db_pass = PropertiesUtil.getProperty(ConstantPool.DB_PASSWORD);
		String db_driver = PropertiesUtil.getProperty(ConstantPool.DB_DRIVER_CLASS);
		
		System.out.println(MessageFormat.format("URL {0} Username {1} password {2} driver {3}" , db_url, db_username, db_pass, db_driver));
		
		// Register JDBC driver
        try {
			Class.forName(db_driver);
			connection = DriverManager.getConnection(db_url, db_username, db_pass);
		} catch (SQLException | ClassNotFoundException sqle ) {
			//sqle.printStackTrace();
			throw new GoogleApiUtilException(sqle.getMessage(), sqle.getCause());
		}
	}
	
	public static void closeConnection() throws GoogleApiUtilException{
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new GoogleApiUtilException(e.getMessage(), e.getCause());
			}
		}
	}
}
