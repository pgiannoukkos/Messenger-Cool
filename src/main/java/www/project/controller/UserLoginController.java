package www.project.controller;

import org.hibernate.HibernateException;
import www.project.bean.User;
import www.project.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class UserLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);

		try {
			UserDAO userDAO = new UserDAO();
			if (userDAO.checkUserLogin(userName, password)) {
				request.setAttribute("message", "Wrong username or password!");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				User user = userDAO.getUser(userName);
				response.addCookie(new Cookie("userId", user.getId().toString()));
				response.sendRedirect("./main.jsp");
			}

		} catch (HibernateException ex) {
			response.getWriter().append(ex.getMessage());
		}
	}
}
