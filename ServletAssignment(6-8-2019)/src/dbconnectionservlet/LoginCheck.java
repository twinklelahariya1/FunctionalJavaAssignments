package dbconnectionservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet(urlPatterns = { "/WebPages/LoginCheck" })
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregister", "dbuser",
					"twinkle@1");

			PreparedStatement preparedStatement = (PreparedStatement) connect.prepareStatement(
					"select USERNAME,USERPASSWORD from userdetails where USERNAME=? and USERPASSWORD=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// Creating two cookies
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				// setting session to expiry in 30 mins

				session.setMaxInactiveInterval(30 * 60);
				Cookie userName = new Cookie("username", username);
				response.addCookie(userName);
				String encodedURL = response.encodeRedirectURL("SessionProductList.jsp");
				response.sendRedirect(encodedURL);

//				String user = null;
//				if (session.getAttribute("name") == null) {
//					response.sendRedirect("index.jsp");
//				} else
//					user = (String) session.getAttribute("name");
//				String userName = null;
//				String sessionID = null;
//				String from, to, date;
//				Cookie[] cookies = request.getCookies();
//				if (cookies != null) {
//					userName = session.getAttribute("name").toString();
//					from = session.getAttribute("from").toString();
//					to = session.getAttribute("to").toString();
//					date = session.getAttribute("date").toString();
//					for (Cookie cookie : cookies) {
//						if (cookie.getName().equals("name"))
//							userName = cookie.getValue();
//						if (cookie.getName().equals("JSESSIONID"))
//							sessionID = cookie.getValue();
//					}
//				} else {
//					sessionID = session.getId();
//					userName = session.getAttribute("name").toString();
//					from = session.getAttribute("from").toString();
//					to = session.getAttribute("to").toString();
//					date = session.getAttribute("date").toString();
//				}

				return;
			}

			response.sendRedirect("Login.jsp");
			return;

		} catch (Exception e2) {
			System.out.println(e2);
		}

//		if (userName.equals() && password.equals()) {
//			response.sendRedirect("Success.jsp");
//		} else {
//			response.sendRedirect("Error.jsp");
//		}

	}

}
