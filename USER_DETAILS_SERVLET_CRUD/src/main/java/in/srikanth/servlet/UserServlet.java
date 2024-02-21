package in.srikanth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.srikanth.dao.Userdao;
import in.srikanth.dto.UserDTO;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// To get data from form
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");

			// To call dto layer
			UserDTO userdto = new UserDTO();
			userdto.setUserName(name);
			userdto.setUserEmail(email);
			userdto.setUserPhno(Integer.parseInt(phno));

			// To call dao layer
			Userdao userdao = new Userdao();
			boolean saveUser = userdao.saveUser(userdto);

			String msg = null;
			if (saveUser) {
				msg = "User Record is Inserted!!";
			} else {
				msg = "User Record is not Inserted!!";
			}

			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Userdao userDao = new Userdao();
		try {
			List<UserDTO> users = userDao.getUsers();
			req.setAttribute("users", users);
			req.getRequestDispatcher("/viewRecords.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		
		//DTO LAYER
		UserDTO userdto = new UserDTO();
		userdto.setUserName(name);
		userdto.setUserEmail(email);
		userdto.setUserPhno(Integer.parseInt(phno));
		
		//DAO LAYER
		Userdao userdao = new Userdao();
		boolean isUpdated =userdao.updateUser(userdto);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		
		
		
	}

}
