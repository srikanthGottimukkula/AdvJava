package com.srikanth.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srikanth.dao.BookDAO;
import com.srikanth.dto.BookDTO;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// capture the data from form.
			String name = req.getParameter("bookName");
			int bookId = Integer.parseInt(req.getParameter("bookId"));

			double bookPrice = Double.parseDouble(req.getParameter("bookPrice"));

			BookDTO dto = new BookDTO();
			dto.setBookId(bookId);
			dto.setBookName(name);
			dto.setBookPrice(bookPrice);

			
			// call dao method by giving from data.
			BookDAO dao = new BookDAO();
			boolean status = dao.saveBook(dto);

			// send request to the Client

			String response = null;
			if (status) {
				response = "Record is inserted!!";
			} else {
				response = "Record is not inserted!!";
			}
			PrintWriter writer = resp.getWriter();
			writer.append(response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
