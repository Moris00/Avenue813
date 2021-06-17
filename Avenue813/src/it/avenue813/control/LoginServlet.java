package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import it.avenue813.model.UserModelDS;
import it.avenue813.utils.Utility;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserModelDS user = new UserModelDS(ds);
		try {
			if(user.canLogin(username, password)) {
				Utility.print("Utente loggato!");
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("PaginaHome/homepage.html");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
