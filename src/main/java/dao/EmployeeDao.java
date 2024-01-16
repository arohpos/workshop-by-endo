/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.EmployeeBean;

public class EmployeeDao {

	public List<EmployeeBean> findAll() {
		List<EmployeeBean> list  = new ArrayList<>();
		final String URL = "jdbc:mySQL://localhost:3306/sample";
		final String USER = "root";
		final String PASS = "";

		String selectSql = "SELECT * FROM T_EMPLOYEE;";
		
		Connection connection = null;
		ResultSet  resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				//取得結果をカラムごとに取得	
				int id = resultSet.getInt("EMPLOYEE_ID");
				String name = resultSet.getString("EMPLOYEE_NAME");
				int age = resultSet.getInt("AGE");
				String department = resultSet.getString("DEPARTMENT");
				//Employeeインスタンスを生成し、Listに追加する
				EmployeeBean employee = new EmployeeBean(id, name, age, department);
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.setAutoCommit(true);
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
