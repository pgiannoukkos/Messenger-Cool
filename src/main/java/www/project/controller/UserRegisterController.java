package www.project.controller;

import www.project.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class UserRegisterController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		LocalDate birthDate = LocalDate.parse(request.getParameter("birth-date"));

		HttpSession session = request.getSession(true);
		try {
			UserDAO userDAO = new UserDAO();
			userDAO.createUser(firstName, lastName, username, email, password, birthDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
