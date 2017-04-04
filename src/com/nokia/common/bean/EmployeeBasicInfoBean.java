package com.nokia.common.bean;

import java.io.Serializable;

public class EmployeeBasicInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String empId;
	private String empName;
	private String empSurename;
	private String company;
	private String product;
	private String department;
	private String employeeSalary;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSurename() {
		return empSurename;
	}
	public void setEmpSurename(String empSurename) {
		this.empSurename = empSurename;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
}
