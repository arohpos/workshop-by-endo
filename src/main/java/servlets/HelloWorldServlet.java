package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloWorld")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//サーブレット内でhtmlを作成
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//実行時刻（時）を取得
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		int hour = Integer.parseInt(sdf.format(calender.getTime()));
		
		//実行時刻ごとの挨拶文言を設定
		String greeting = "";
		if(hour >= 0 && hour < 6) {
			greeting = "you should sleep!";
		}else if(hour < 11) {
			greeting = "good morning!";
		}else if(hour <16) {
			greeting = "hello!";
		}else if(hour < 20) {
			greeting = "good evening!";
		}else {
			greeting = "good night!";
		}
		
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>HelloWorld</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, world!!</h1>");
        out.println(greeting);
        out.println("</body>");
        out.println("</html>");
	}
}
