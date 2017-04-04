package com.nokia.common.response;

import javax.xml.soap.SOAPMessage;

import org.w3c.dom.NodeList;

import com.nokia.connection.config.ConfigurationUtil;
import com.nokia.service.enums.EnumConnectionsConstants;

public class EmployeeSalaryMsgResponse {
	/**
	 * Very simple function that navigate through the response message's nodes and get the value of required tag 
	 * */
	public String getEmployeeSalary(SOAPMessage soapResponse) throws Exception {
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		String empSalary = null;
		NodeList nodeList = soapResponse.getSOAPPart().getElementsByTagName(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_WEB_NAMESPACE_KEY.getValue())+":"+ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_SALARY_NAMESPACE_KEY.getValue()));
		for(int i=0;i<nodeList.getLength(); i++) {
			empSalary = nodeList.item(i).getFirstChild().getNodeValue();
		}
		return empSalary;
	}
}
