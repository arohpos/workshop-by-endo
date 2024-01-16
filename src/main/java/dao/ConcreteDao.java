/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AbstractBean;
import beans.ConcreteBean;

public class ConcreteDao extends AbstractDao{
	
	public ConcreteDao() {
		this.selectSql = "SELECT * FROM T_EMPLOYEE;";
	}

	@Override
	public AbstractBean getBean(ResultSet resultSet) {
		AbstractBean abstractBean = null;
		try {
			//取得結果をカラムごとに取得	
			int id = resultSet.getInt("EMPLOYEE_ID");
			String name = resultSet.getString("EMPLOYEE_NAME");
			int age = resultSet.getInt("AGE");
			String department = resultSet.getString("DEPARTMENT");
			//ConcreteBeanインスタンスを生成し、AbstractConcreteBean型として扱う
			abstractBean = new ConcreteBean(id, name, age, department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abstractBean;
	}

	

	
		
}
