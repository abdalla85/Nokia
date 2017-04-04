package com.nokia.common.ws;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.nokia.common.request.EmployeeSalaryMsgRequest;
import com.nokia.connection.config.ConfigurationUtil;
import com.nokia.service.enums.EnumConnectionsConstants;

public class EmployeeSalaryWSCaller {

	/**
	 * Call fake web-service and return employee salary response message 
	 * @return SAOPMessage
	 * */
	public static SOAPMessage employeeSalaryOperation(String empId) {
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		SOAPMessage employeeSalarySoapResponse = null;  
		try {
			SOAPConnection employeeSalarySoapConnection = getSoapConnectionFactory().createConnection();

			employeeSalarySoapResponse = employeeSalarySoapConnection.call(EmployeeSalaryMsgRequest.createSOAPRequest(empId),
					ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_URL_KEY.getValue()));

			employeeSalarySoapConnection.close();
		} catch (Exception e) {
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		}
		return employeeSalarySoapResponse ;
	}
	
	/**
	 * Connection factory method
	 * @return SOAPConnectionFactory
	 * */
	private static SOAPConnectionFactory getSoapConnectionFactory() throws SOAPException {
		return SOAPConnectionFactory.newInstance();
	}
}
