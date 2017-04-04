package com.nokia.common.request;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import com.nokia.connection.config.ConfigurationUtil;
import com.nokia.service.enums.EnumConnectionsConstants;

public class EmployeeSalaryMsgRequest {

	public static SOAPMessage createSOAPRequest(String empId) throws Exception {
        MessageFactory employeeSalaryMessageFactory = MessageFactory.newInstance();
        SOAPMessage employeeSalarySoapMessage = employeeSalaryMessageFactory.createMessage();
        SOAPPart employeeSalarySoapPart = employeeSalarySoapMessage.getSOAPPart();
        // SOAP Envelope
        SOAPEnvelope employeeSalaryEnvelope = employeeSalarySoapPart.getEnvelope();
        employeeSalaryEnvelope.addNamespaceDeclaration(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_WEB_NAMESPACE_KEY.getValue()), ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_URI_KEY.getValue()));

        
        // SOAP Body
        SOAPBody employeeSalarySoapBody = employeeSalaryEnvelope.getBody();
        SOAPElement employeeSalarySoapBodyMainElem = employeeSalarySoapBody.addChildElement(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_GET_EMP_SALAR_OPERATION_KEY.getValue()), ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_WEB_NAMESPACE_KEY.getValue()));//Fake calling !
        SOAPElement employeeSalarySoapBodySubElem = employeeSalarySoapBodyMainElem.addChildElement(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_EMP_ID_NAMESPACE_KEY.getValue()), ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.WS_WEB_NAMESPACE_KEY.getValue()));
        employeeSalarySoapBodySubElem.addTextNode(empId);
        
        employeeSalarySoapMessage.saveChanges();

        return employeeSalarySoapMessage;
    }
}
