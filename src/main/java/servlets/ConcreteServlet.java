package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.SampleLogic;

@WebServlet("/employeeListWithAbstract")
public class ConcreteServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SampleLogic logic = new SampleLogic();
		logic.execute(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/abstractSample.jsp");
		dispatcher.forward(request, response);
	}
}
