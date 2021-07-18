package it.avenue813.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.avenue813.model.CarrelloBean;
import it.avenue813.model.OrderBean;
import it.avenue813.model.OrderModelDS;
import it.avenue813.model.ProductBean;
import it.avenue813.model.UserBean;
import it.avenue813.model.UserModelDS;
import it.avenue813.utils.Utility;

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
			OrderModelDS modelOrder = new OrderModelDS(ds);
			UserModelDS modelUser = new UserModelDS(ds);
			UserBean bean = new UserBean();
			
			HttpSession session = request.getSession();
			
			bean.setUsername( (String) session.getAttribute("username"));
			bean.setPassword( (String) session.getAttribute("passw"));
			
			if(session.getAttribute("numero_ordini") == null) {
				 session.setAttribute("numero_ordini", "1");
				 String a = (String) session.getAttribute("numero_ordini");
				 bean.setNumero_ordini(Integer.parseInt(a));
				try {
					modelUser.toUpdateOrdini(bean);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				int i = Integer.parseInt( (String) session.getAttribute("numero_ordini"));
				i = i + 1;
				System.out.print(i);
				 bean.setNumero_ordini(i);
				 try {
						modelUser.toUpdateOrdini(bean);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				String a = String.valueOf(i);
				session.setAttribute("numero_ordini", a);
			}
			
			
			
			String username = (String) session.getAttribute("username");
			String password = (String) session.getAttribute("passw");
			int id = -1;
			try {
				id = modelUser.canLogin(username, password).getId();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
			
			String indirizzo = request.getParameter("indirizzo");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String telefono = request.getParameter("telefono");
			String method_pagament = request.getParameter("metodo");
			String num = (String)session.getAttribute("numero_ordini");
			
			String date = new Date().toString();
			String[] parts = date.split(" ");
			date = parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[5]+" "+parts[3];
			System.out.println(new Date());
			
			int i = 0;
			while(i < carrello.getSizeList()) {
				OrderBean order = new OrderBean();
				ProductBean product = carrello.getAProduct(i);
				order.setNumOrder(Integer.parseInt(num));
				order.setIdProduct(product.getId());
				order.setId_customer(id);
				order.setAmount(product.getPrice());
				order.setCognome(cognome);
				order.setNome(nome);
				order.setTelefono(telefono);
				order.setIndirizzo(indirizzo);
				order.setMethod(method_pagament);
				order.setData(date);
				
				try {
					modelOrder.doSave(order);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				i++;
			}
			
			session.setAttribute("carrello", new CarrelloBean());
			response.sendRedirect("/Avenue813/PaginaShop/shop.jsp?Sesso=uomo");
	}

}
