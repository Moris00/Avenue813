package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.avenue813.model.CarrelloBean;
import it.avenue813.model.UserBean;
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
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		Utility.print(username);
		Utility.print(password);
		
		UserModelDS user = new UserModelDS(ds);
		
		try {
			UserBean userL = user.canLogin(username, password);
			if(userL != null) {
				Utility.print("Utente loggato!");
				
				HttpSession userSession = request.getSession();
				userSession.setAttribute("username", userL.getUsername());
				userSession.setAttribute("passw", userL.getPassword());
				userSession.setAttribute("numero_ordini", String.valueOf(userL.getNumero_ordini()));
				userSession.setAttribute("carrello", userL.getCarrello());
				userSession.setAttribute("role", userL.getRole());
			
					
				request.setAttribute("errorLogin", null);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaHome/home.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("errorLogin", "Login errato!");
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAutenticazione/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
