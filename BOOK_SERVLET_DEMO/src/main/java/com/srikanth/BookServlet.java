package com.srikanth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookID = request.getParameter("bookId");
		String bookName = request.getParameter("bookName");
		String bookPrice = request.getParameter("bookPrice");

		System.out.println(bookID);
		System.out.println(bookName);
		System.out.println(bookPrice);

		PrintWriter writer = response.getWriter();
		writer.write("Forms Submitted!!");

		// INSERT RECORD INTO DATABASE USING JDBC

		
		try {
			  

			  Connection con = ConnectionFactory.getConnection();
			String sql = "INSERT INTO BOOKS VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bookID));
			pstmt.setString(2, bookName);
			pstmt.setDouble(3, Double.parseDouble(bookPrice));

			int count = pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
