package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.avenue813.model.ProductBean;
import it.avenue813.model.ProductModelDS;
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
		
		ProductModelDS productModel = new ProductModelDS((DataSource) getServletContext().getAttribute("DataSource"));
		
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			response.sendRedirect("/Avenue813/PaginaAutenticazione/login.jsp");
		}else {
		
		
		
		String query = request.getQueryString();
		query = query.replaceAll("\\D+", "");
		ProductBean product = null;
		try {
			product = productModel.doRetrieveById(Integer.parseInt(query));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
			response.sendRedirect("/Avenue813/PaginaShop/user/product.jsp?id="+query+"&Sesso="+product.getSesso());
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
