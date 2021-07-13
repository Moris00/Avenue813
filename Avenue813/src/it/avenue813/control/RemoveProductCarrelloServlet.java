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

import it.avenue813.model.CarrelloBean;
import it.avenue813.model.ProductBean;
import it.avenue813.model.ProductModelDS;
import it.avenue813.utils.Utility;

/**
 * Servlet implementation class RemoveProductCarrelloServlet
 */
@WebServlet("/RemoveProductCarrelloServlet")
public class RemoveProductCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveProductCarrelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utility.print("Fase di remove");
		response.setContentType("text/html");
		
		ProductModelDS productModel = new ProductModelDS((DataSource) getServletContext().getAttribute("DataSource"));
		HttpSession session = request.getSession();
		
		String name_product = request.getParameter("name_product");
		Utility.print(name_product);
		
		try {
			ProductBean product = productModel.doRetrieveByKey(name_product);
			CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
			System.out.print(carrello.getSizeList());
			carrello.removeProduct(product);
			System.out.print(carrello.getSizeList());
			session.setAttribute("carrello", carrello);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/Avenue813/PaginaShop/carrello.jsp");
	}	

}
