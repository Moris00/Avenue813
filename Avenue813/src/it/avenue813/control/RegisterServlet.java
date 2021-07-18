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

import it.avenue813.model.UserBean;
import it.avenue813.model.UserModelDS;
import it.avenue813.utils.Utility;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
			UserBean newUser = new UserBean(); 
			UserModelDS userDS = new UserModelDS(ds);
			
			response.setContentType("text/html");  
 
			
			newUser.setName(request.getParameter("name"));
			newUser.setSecond_name(request.getParameter("secondname"));
			newUser.setPassword(request.getParameter("password"));
			newUser.setDate(request.getParameter("date"));
			newUser.setEmail(request.getParameter("email"));
			newUser.setUsername(request.getParameter("username"));
			
			try {
				if(userDS.isNew(newUser) == "") {
					userDS.toSave(newUser);
					request.setAttribute("errorLogin", null);
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("../PaginaHome/homepage.html");
					dispatcher.forward(request, response);
				}else {
					request.setAttribute("errorLogin", userDS.isNew(newUser));
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAutenticazione/register.jsp");
					dispatcher.forward(request, response);
				}
			}catch(SQLException e) {
				Utility.print(e);
			}
			
	}

}
