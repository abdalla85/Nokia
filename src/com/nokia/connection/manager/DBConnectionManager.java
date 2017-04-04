package com.nokia.connection.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nokia.connection.config.ConfigurationUtil;
import com.nokia.service.enums.EnumConnectionsConstants;

public class DBConnectionManager {
	
	private DataSource dataSource;
	
	/**
	 * This method is used to lookup for a data source which is defined in the application server.
	 * @throws NamingException 
	 * */
	private void databaseDsLookup(String jndi) throws NamingException{
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		InitialContext initialContext = new InitialContext();
		dataSource = (DataSource)initialContext.lookup(jndi);
	}
	/**
	 * This method returns connection object, if the connection null, it means an exception
	 * occurred during the creation, it will be handled in the upper layer to do custom exception handling.
	 * @return Connection object
	 * */
	public Connection getNokiaDBConnection(){
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		try {
			if(dataSource == null)
				databaseDsLookup(null/*Required data source id, list of ids will be defined in an enum*/);
			return dataSource.getConnection();
		} catch (SQLException e) {
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		} catch (Exception e){
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection connection) throws SQLException{
		connection.close();
	}
	
	public void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException{
		preparedStatement.close();
	}
	
	public void closeResultSet(ResultSet resultSet) throws SQLException{
		resultSet.close();
	}
	
	public Connection getNokiaDBBasicConnection(){
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.CONNECTION_URL_KEY.getValue()), 
					ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.DB_USERNAME_KEY.getValue())
					, ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.DB_PASSWORD_KEY.getValue()));
		} catch (ClassNotFoundException e) {
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		} catch (SQLException e) {
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		}
		return null;
	}

}
