package com.greatdigitallab.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBConnection
 */
@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBConnection() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Setup connection variables
		
		String username = "mysqladmin";
		String password = "mysqladmin";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/mysql_customer_db?useSSL=false";
		// String jdbcUrl = "jdbc:mysql://localhost:3306/mysql_customer_db?useSSL=false&serverTimezone=UTC"; -- Configuration for MySQL 8
		String driver = "com.mysql.jdbc.Driver";
				
		// Get Connection to Database
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database : " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConnection = DriverManager.getConnection(jdbcUrl, username, password);
		
			out.println("<br>Connection Success..!!");
			
			myConnection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}