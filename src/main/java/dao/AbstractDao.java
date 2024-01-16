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

import beans.AbstractBean;


public abstract class AbstractDao {
	
	//必ず子クラスのコンストラクタで値をいれる
	//TODO：finalってつかえないんだっけ。必ずどこかで設定するように制限をかけたい。
	protected String selectSql;
	//ResultSetの各レコードをAbstractBean型に格納する
	public abstract AbstractBean getBean(ResultSet resultSet);

	//AbstractBean型に格納したSELECT結果のリストを返す
	public List<AbstractBean> findAll() {
		List<AbstractBean> list  = new ArrayList<>();
		final String URL = "jdbc:mySQL://localhost:3306/sample";
		final String USER = "root";
		final String PASS = "";
		
		Connection connection = null;
		ResultSet  resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			preparedStatement = connection.prepareStatement(selectSql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				//レコードの取得方法は子クラスの実装に任せる
				AbstractBean abstractBean = this.getBean(resultSet);
				list.add(abstractBean);
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
