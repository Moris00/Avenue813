package it.avenue813.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.avenue813.model.CarrelloBean;

/**
 * Servlet implementation class AcquistoServlet
 */
@WebServlet("/AcquistoServlet")
public class AcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AcquistoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
			HttpSession session = request.getSession();
			CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
			
			
	}

}
