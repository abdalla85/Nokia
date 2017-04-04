package com.nokia.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;

import com.nokia.connection.config.ConfigurationUtil;
import com.nokia.service.enums.EnumConnectionsConstants;

public class FileUtil {

	private FileUtil(){}

	private static FileUtil INSTANCE = new FileUtil();
	private static final String STANDARD_SEPERATOR = ",";
	private static final String NEW_LINE = "\n";
	
	public static FileUtil getInstance(){
		return INSTANCE;
	}
	
	public void filesTransfer(){
		FTPClient ftpClient = new FTPClient();
		FileInputStream fileInputStream = null;

		try {
		    ftpClient.connect(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.FTP_HOSTNAME_KEY.getValue()),21);
		    
		    ftpClient.login(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.FTP_USERNAME_KEY.getValue()), 
		    		ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.FTP_PASSWORD_KEY.getValue()));
		    fileInputStream = new FileInputStream(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.FTP_SOURCE_FILE_KEY.getValue()));
		    ftpClient.storeFile(ConfigurationUtil.getInstance().getValue(EnumConnectionsConstants.FTP_DESTINATION_FILE_KEY.getValue()), fileInputStream);
		    ftpClient.logout();
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (fileInputStream != null) {
		            fileInputStream.close();
		        }
		        ftpClient.disconnect();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}

	public void csvFileCreator(Writer w, List<String> values) throws IOException {
		boolean initialRow = true;
		StringBuilder stringBuffer = new StringBuilder();
		for (String value : values) {
			if (!initialRow) {
				stringBuffer.append(STANDARD_SEPERATOR);
			}
			stringBuffer.append(value);
			initialRow = false;
		}
		stringBuffer.append(NEW_LINE);
		w.append(stringBuffer.toString());
	}

}
