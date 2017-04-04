package com.nokia.service.enums;

public enum EnumConnectionsConstants {
	
	CONFIG_PATH("C:\\SM\\JBoss\\Nokia\\NokiaCommonProject\\src\\config\\commonConfig.config"),
//	DB Keys
	CONNECTION_URL_KEY("nokia.connection.url"),
	DB_USERNAME_KEY("nokia.connection.username"),
	DB_PASSWORD_KEY("nokia.connection.password"),
	
//	WS Keys
	WS_URL_KEY("nokia.ws.url"),
	WS_GET_EMP_SALAR_OPERATION_KEY("nokia.ws.salary.operation"),
	WS_URI_KEY("nokia.ws.uri"),
	WS_WEB_NAMESPACE_KEY("nokia.ws.web.namespace"),
	WS_EMP_ID_NAMESPACE_KEY("nokia.ws.empId.namespace"),
	WS_SALARY_NAMESPACE_KEY("nokia.ws.salary.namespace"),
	
//	FTP Keys
	FTP_HOSTNAME_KEY("nokia.ftp.hostname"),
	FTP_PORT_KEY("nokia.ftp.port"),
	FTP_USERNAME_KEY("nokia.ftp.username"),
	FTP_PASSWORD_KEY("nokia.ftp.password"),
	FTP_SOURCE_FILE_KEY("nokia.ftp.source.file"),
	FTP_DESTINATION_FILE_KEY("nokia.ftp.destination.file");
	
	
	;
	
	private String value;
	
	EnumConnectionsConstants (String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}

}
