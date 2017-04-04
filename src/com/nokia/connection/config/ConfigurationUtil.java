package com.nokia.connection.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.nokia.service.enums.EnumConnectionsConstants;

public class ConfigurationUtil {

	/**
	 * Prevent making new instances
	 * */
	private ConfigurationUtil(){};
	
	private static ConfigurationUtil INSTANCE = new ConfigurationUtil();
	private static Properties PROPERTIES = new Properties();
	
	/**
	 * @return ConnectionConfigUtil instance
	 * */
	public static ConfigurationUtil getInstance(){
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		return INSTANCE;
	}
	
	private void initPropertiesFile(){
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		try {
			/*The below path should be on OS level or application server one*/
			String fileName = EnumConnectionsConstants.CONFIG_PATH.getValue();            
			InputStream is;
			is = new FileInputStream(fileName);
			PROPERTIES.load(is);
		} catch (FileNotFoundException e) {
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		} catch (IOException e) {
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		} catch(Exception e){
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		}
	}
	
	
	public String getValue(String key){
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		if(getProperties().isEmpty())
			initPropertiesFile();
		return getProperties().getProperty(key);
	}
	
	private Properties getProperties(){
		return PROPERTIES;
	}
	
}
