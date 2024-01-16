package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subjectRegistration")
public class SubjectRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/subjectRegistration.html");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String URL = "jdbc:mySQL://localhost:3306/sample";
		final String USER = "root";
		final String PASS = "";

		// 遷移元で入力されたパラメータを元に、SQLを作成する
		String subjectName = request.getParameter("subjectName");
		String insertSql = "INSERT INTO T_SUBJECT (SUBJECT_NAME) VALUES ('" + subjectName + "');";
		
		Connection connection = null;
		Statement statement = null;

		try {
			// jarの中のcom.mysql.jdbcディレクトリにあるDriver.javaのクラスオブジェクトを取得
			// java標準のクラスファイルではないため、クラスパスの追加が必要
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			// AutoCommit解除
			connection.setAutoCommit(false);

			// この辺でautocommitを外しておく。例外処理とか入れておく。保守と同様の処理になるように。
			// https://qiita.com/white_tiger/items/2868a44aec6add385e04
			statement = connection.createStatement();
			int count = statement.executeUpdate(insertSql);
			System.out.println(count + "件行を追加しました。");

			// トランザクションのコミット
			connection.commit();
		} catch (SQLException e) {
			try {
				// トランザクションのrollback
				connection.rollback();
			} catch (SQLException e2) {
				// rollbackも失敗したらスタックトレースを出力
				e2.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.setAutoCommit(true);
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}