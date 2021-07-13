package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.avenue813.utils.Utility;

/**
 * Servlet implementation class ViewProductServlet
 */
@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			response.sendRedirect("/Avenue813/PaginaAutenticazione/login.jsp");
		}else {
		
		
		
		String query = request.getQueryString();
		query = query.replaceAll("\\D+", "");
		Utility.print(query);
		Utility.print((String)session.getAttribute("Sesso"));
		String sesso = (String) session.getAttribute("Sesso");
			response.sendRedirect("/Avenue813/PaginaShop/user/product.jsp?id="+query+"&Sesso="+sesso);
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
