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

import it.avenue813.model.UserBean;
import it.avenue813.model.UserModelDS;
import it.avenue813.utils.Utility;

/**
 * Servlet implementation class UpdateDatiServlet
 */
@WebServlet("/UpdateDatiServlet")
public class UpdateDatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateDatiServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModelDS userModel = new UserModelDS((DataSource) getServletContext().getAttribute("DataSource"));
		
		HttpSession userSession = request.getSession();
		
		String username = (String) userSession.getAttribute("username");
		String password = (String) userSession.getAttribute("passw");
		String email = null;
		
		
		
		UserBean user = new UserBean();
		try {
			user = userModel.canLogin(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String nome =request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String new_password = request.getParameter("password");
		
		
		UserBean bean = new UserBean();
		
		Utility.print(request.getParameter("username"));
		if(!(request.getParameter("email").equals(user.getEmail())) && !(request.getParameter("username").equals(user.getUsername()))) {
			
			email = request.getParameter("email");
			username = request.getParameter("username");
			try {
				if(userModel.isNew(bean) == "") {
					email = request.getParameter("email");
					username = request.getParameter("username");
				}else {
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			
			if(request.getParameter("email").equals(user.getEmail())){
				email = request.getParameter("email");
		} else
			try {
				if(userModel.isFreeEmail(request.getParameter("email"))){
					Utility.print("email libera");
					email = request.getParameter("email");
				}else {
					//Manda errore!!
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(request.getParameter("username").equals(user.getUsername())){
				username = request.getParameter("username");
			} else
				try {
					if(userModel.isFreeUsername(request.getParameter("username"))){
						Utility.print("username libero");
						username = request.getParameter("username");
					}else {
						//Manda errore!!
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		
		
		Utility.print(email);
		
		bean.setUsername(username);
		bean.setName(nome);
		bean.setSecond_name(cognome);
		bean.setPassword(new_password);
		bean.setEmail(email);
		
		String username_current = (String)userSession.getAttribute("username");
		String passw_current = (String)userSession.getAttribute("passw");
		
		try {
			userModel.toUpdate(bean, username_current, passw_current);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		userSession.setAttribute("username", username);
		userSession.setAttribute("passw", new_password);
		
		response.sendRedirect(response.encodeRedirectURL("/Avenue813/LogoutServlet"));
		
	}	
	
	

}
