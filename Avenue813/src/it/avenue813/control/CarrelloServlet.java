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
 * Servlet implementation class CarrelloServlet
 */
@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarrelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		ProductModelDS productModel = new ProductModelDS((DataSource) getServletContext().getAttribute("DataSource"));
		HttpSession session = request.getSession();
		
		String name = request.getParameter("product_name");
		String size = request.getParameter("size");	
			
		Utility.print(name);
		Utility.print(size);

		try {
			ProductBean product = productModel.doRetrieveByKey(name);
			if(product.getStocks() <= 0) {
				//Pagina Errore è vuoto!
			}else {
				Utility.print((String) session.getAttribute("username"));
					if(session.getAttribute("carrello") == null) {
						CarrelloBean carrello = new CarrelloBean();
						carrello.addProduct(product);
						session.setAttribute("carrello", carrello);		
					}
					else{
						CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
						carrello.addProduct(product);
					}
				response.sendRedirect("/Avenue813/PaginaShop/shop.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
