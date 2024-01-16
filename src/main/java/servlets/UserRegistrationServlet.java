package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Gender;
import beans.UserBean;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/userRegistration")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/userRegistration.html");
        dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォームからパラメータを取得
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		Gender gender = request.getParameter("gender").equals("male") ? Gender.MALE : Gender.FEMALE; 
		
		//UserBeanインスタンスにパラメータを格納し、インスタンスごとAttributeにつめる。
		UserBean userBean = new UserBean();
		userBean.setName(name);
		userBean.setAge(age);
		userBean.setGender(gender);
		request.setAttribute("user", userBean);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userRegistrationResult.jsp");
		dispatcher.forward(request, response);		
	}
}