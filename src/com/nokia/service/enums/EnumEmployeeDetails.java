package com.nokia.service.enums;

public enum EnumEmployeeDetails {

	COL_EMP_ID("EMP_ID"),
	COL_EMP_NAME("EMP_NAME"),
	COL_EMP_SURENAME("EMP_SURENAME"),
	COL_COMPANY("COMPANY"),
	COL_PRODUCT("PRODUCT"),
	COL_DEPARTMENT("DEPARTMENT"),
	QUERY_GET_EMPLOYEE_DETAILS_BY_EMP_ID("SELECT EMP_ID,EMP_NAME,EMP_SURENAME,COMPANY,PRODUCT,DEPARTMENT FROM NOKIA.EMP_BASIC_INFO WHERE EMP_ID = ?");
	
	private String value;

	EnumEmployeeDetails (String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}
}
