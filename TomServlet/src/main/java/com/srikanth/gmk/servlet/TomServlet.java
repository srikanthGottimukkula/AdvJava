package com.srikanth.gmk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srikanth.gmk.dao.TomDAO;
import com.srikanth.gmk.dto.TomDTO;

@WebServlet("/welcome")
public class TomServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// capture the form data
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		// Call DTO LAYER
		TomDTO dto = new TomDTO();
		dto.setId(Integer.parseInt(id));
		dto.setName(name);

		// Call DAO LAYER
		TomDAO dao = new TomDAO();
		try {
			boolean status = dao.saveTom(dto);

			String result = null;
			if (status) {

				result = "Record inserted successfully!!";
			} else {
				result = "Record Not inserted!!";
			}

			PrintWriter writer = response.getWriter();
			writer.append("<html><body><h3>Welcome Login page</h3></body></html>");
			writer.append(result);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
