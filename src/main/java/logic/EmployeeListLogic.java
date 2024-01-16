/**
 * 
 */
package logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmployeeBean;
import dao.EmployeeDao;


public class EmployeeListLogic {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		EmployeeDao employeeDao = new EmployeeDao();
		List<EmployeeBean> employeeList = employeeDao.findAll();
		request.setAttribute("employeeList", employeeList);
	}

}
