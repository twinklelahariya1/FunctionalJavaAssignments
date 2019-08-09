package dbconnectionservlet;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/Register")
public class RegisterUserServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String contactNumber = request.getParameter("contactno");
		String dob = request.getParameter("dateofbirth");
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");
		try {
//Class.forName("oracle.jdbc.driver.OracleDriver");  
//Connection con=DriverManager.getConnection(  
//"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  

			Class.forName("com.mysql.jdbc.Driver");
//   // Setup the connection with the DB
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregister", "dbuser",
					"twinkle@1");
			PreparedStatement preparedStatement = connect.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?)");

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, contactNumber);
			preparedStatement.setString(5, dob);
			preparedStatement.setString(6, username);
			preparedStatement.setString(7, password);
			
			int i = preparedStatement.executeUpdate();
			if (i > 0)
				response.sendRedirect("success.jsp");

				
		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}