package dbconnectionservlet;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/WebPages/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 9109954722562256562L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String contactNumber = request.getParameter("contactno");
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");
		try {

			Class.forName("com.mysql.jdbc.Driver");
//   // Setup the connection with the DB
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregister", "dbuser",
					"twinkle@1");
			PreparedStatement preparedStatement = connect.prepareStatement(
					"insert into userdetails (firstname,lastname,email,contactno,username,userpassword) values (?,?,?,?,?,?)");

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, contactNumber);
			preparedStatement.setString(5, username);
			preparedStatement.setString(6, password);

			preparedStatement.executeUpdate();
			response.sendRedirect("Success.jsp");

		} catch (Exception e2) {
			System.out.println(e2);
		}

//		out.close();
	}

}