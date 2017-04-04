package com.nokia.tester;

import java.io.FileWriter;
import java.util.Arrays;

import javax.xml.soap.SOAPMessage;

import com.nokia.common.bean.EmployeeBasicInfoBean;
import com.nokia.common.dao.EmployeeBasicInfoDAO;
import com.nokia.common.response.EmployeeSalaryMsgResponse;
import com.nokia.common.util.FileUtil;
import com.nokia.common.ws.EmployeeSalaryWSCaller;
import com.nokia.connection.config.ConfigurationUtil;
import com.nokia.service.enums.EnumConnectionsConstants;

public class RequirementTester {
	

	public static void main(String[] args) {
		String empId = "2";
		EmployeeBasicInfoDAO basicInfoDAO = new EmployeeBasicInfoDAO();
		
		try {
			EmployeeBasicInfoBean employeeBasicInfoBean = basicInfoDAO.getEmployeeBasicInfoByEmpId(empId); 
			SOAPMessage soapMessageResponse = EmployeeSalaryWSCaller.employeeSalaryOperation(empId); 
			if(employeeBasicInfoBean != null){

				employeeBasicInfoBean.setEmployeeSalary(new EmployeeSalaryMsgResponse().getEmployeeSalary(soapMessageResponse)); 
				FileWriter writer = new FileWriter(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.FTP_SOURCE_FILE_KEY.getValue()));
//				we can return flag with the status of operation
				FileUtil.getInstance().csvFileCreator(writer, Arrays.asList(employeeBasicInfoBean.getEmpId(), employeeBasicInfoBean.getEmpName(), employeeBasicInfoBean.getEmpSurename(),
						employeeBasicInfoBean.getCompany(),employeeBasicInfoBean.getDepartment(),employeeBasicInfoBean.getProduct(),employeeBasicInfoBean.getEmployeeSalary()));
				writer.flush();
				writer.close();
			}
//			we can return flag with the status of operation
			FileUtil.getInstance().filesTransfer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
