package com.nokia.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nokia.common.bean.EmployeeBasicInfoBean;
import com.nokia.connection.manager.DBConnectionManager;
import com.nokia.service.enums.EnumEmployeeDetails;

public class EmployeeBasicInfoDAO {
	
	/**
	 * This method is to get basic info of an employee 
	 * @return EmployeeBasicInfoBean
	 * */
	public EmployeeBasicInfoBean getEmployeeBasicInfoByEmpId(String empId){
//		Proper logging technique goes here like log4j, java-logging, log4j2, etc...
		DBConnectionManager connectionManager = new DBConnectionManager();
		PreparedStatement preparedStatement = null;
		Connection connection = connectionManager.getNokiaDBBasicConnection();
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(
					EnumEmployeeDetails.QUERY_GET_EMPLOYEE_DETAILS_BY_EMP_ID.getValue());
			preparedStatement.setString(1, empId);
			resultSet = preparedStatement.executeQuery();
			List<EmployeeBasicInfoBean> results = mapDOToBean(resultSet);
			if(results.size() != 0){
				return results.get(0);
			}else{
//				we can throw custom exception of no data found or do another handling
				return null;
			}
		} catch (SQLException e) {
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		} catch (Exception e){
//			Proper handling exception goes here like notify the needed team about the exception
			e.printStackTrace();
		}finally {
			if(preparedStatement != null){
				try{
					connectionManager.closePreparedStatement(preparedStatement);
				} catch(SQLException e){
//					Proper handling exception goes here like notify the needed team about the exception
					e.printStackTrace();
				} catch(Exception e){
//					Proper handling exception goes here like notify the needed team about the exception
					e.printStackTrace();
				}
			}
			if(resultSet != null){
				try{
					connectionManager.closeResultSet(resultSet);
				} catch(SQLException e){
//					Proper handling exception goes here like notify the needed team about the exception
					e.printStackTrace();
				} catch(Exception e){
//					Proper handling exception goes here like notify the needed team about the exception
					e.printStackTrace();
				}
			}
			if(connection != null){
				try{
					connectionManager.closeConnection(connection);
				} catch(SQLException e){
//					Proper handling exception goes here like notify the needed team about the exception
					e.printStackTrace();
				} catch(Exception e){
//					Proper handling exception goes here like notify the needed team about the exception
					e.printStackTrace();
				}

			}

		}
		return null;
	}
	
	/**
	 * This generic is for mapping ResultSet object with EmployeeBasicInfoBean, this could be used by other methods as well. 
	 * @return List<EmployeeBasicInfoBean>
	 * */
	private List<EmployeeBasicInfoBean> mapDOToBean(ResultSet resultSet) throws SQLException{
		List<EmployeeBasicInfoBean> results = new ArrayList<EmployeeBasicInfoBean>();
		while(resultSet.next()){
			EmployeeBasicInfoBean employeeBasicInfoBean = new EmployeeBasicInfoBean();
			employeeBasicInfoBean.setEmpId(resultSet.getString(EnumEmployeeDetails.COL_EMP_ID.getValue()));
			employeeBasicInfoBean.setEmpName(resultSet.getString(EnumEmployeeDetails.COL_EMP_NAME.getValue()));
			employeeBasicInfoBean.setEmpSurename(resultSet.getString(EnumEmployeeDetails.COL_EMP_SURENAME.getValue()));
			employeeBasicInfoBean.setProduct(resultSet.getString(EnumEmployeeDetails.COL_PRODUCT.getValue()));
			employeeBasicInfoBean.setCompany(resultSet.getString(EnumEmployeeDetails.COL_COMPANY.getValue()));
			employeeBasicInfoBean.setDepartment(resultSet.getString(EnumEmployeeDetails.COL_DEPARTMENT.getValue()));
			results.add(employeeBasicInfoBean);
			employeeBasicInfoBean = null;
		}
		
		return results;
	}

}
