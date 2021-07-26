<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , it.avenue813.model.*, it.avenue813.utils.*, javax.sql.*"%>
    
    <% HttpSession sessionUser = request.getSession();
    	if(sessionUser.getAttribute("username") == null &&  sessionUser.getAttribute("passw") == null){
    		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
    		return;
    	}
    	
    	if(sessionUser.getAttribute("username")== "" || sessionUser == null){
    		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
    		return;
    	}
    	
    	
    	int numero_ordini = Integer.parseInt((String) sessionUser.getAttribute("numero_ordini")); 
    	
    	if(sessionUser.getAttribute("numero_ordini") == ""){
    		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
    		return;
    	}
    	int i = 1;
    	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini di <%=sessionUser.getAttribute("username")%></title>
		<style><%@include file="mieiordini.css"%></style>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../PaginaUtili/header.jsp"%>
			</div>
			<div class="content">
				<div class="titolo"><h1 align="center">I tuoi ordini</h1></div>
				<%if (numero_ordini == 0){ %>
					<div class="vuoto"><h2 align="center"><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=uomo">Non hai effettuato ordini, vai allo shop</a></h2></div>
				<%}else { while(i < numero_ordini+1){ %>
				<fieldset class="fields"> 
					<legend>ID ORDER: <%=i%></legend>
					<%
						OrderModelDS orderModel = new OrderModelDS((DataSource) getServletContext().getAttribute("DataSource"));
					
						UserModelDS userModel = new UserModelDS((DataSource) getServletContext().getAttribute("DataSource"));
						UserBean beanU = userModel.canLogin((String) sessionUser.getAttribute("username"), (String) sessionUser.getAttribute("passw"));
					
						ArrayList<?> products = orderModel.giveProducts(i, beanU.getId()); 
						int n = products.size();
						int j = 0;
						double tot = 0;
						OrderBean order = orderModel.doRetrieveOrder(i);
						
						while(j < n){
							ProductBean bean = (ProductBean) products.get(j);
							tot = tot + bean.getPrice();
					%>
					<div class="item">
						<div class="image_item">
							<img src="<%=bean.getPath()%>">
						</div>
						<div class="desc_item">
							<h3><%=bean.getName()%></h3>
							<h3><%=bean.getPrice()%> &euro;</h3>
						</div>
						
					</div>
					
					<% 
						j++;
							} 
					%>
					<div class="tot">
							<h3>Ordinato da: <%=order.getNome()%> <%=order.getCognome()%></h3><h3>Indirizzo: <%=order.getIndirizzo() %></h3><h3>Data: <%=order.getData() %></h3><h3>Metodo Pagamento: <%=orderModel.doRetrieveMethodPagament(i)%></h3>
							<%if(order.getMethod().equals("Contrassegno")){ %>
							<h3>Totale spesa:<%=tot+5.00%></h3>
							<% }else{ %>
								<h3>Totale spesa:<%=tot%></h3>
							
							<%} %>
					</div>
				</fieldset>
				<%
					i++;
						} 
					}
				%>
			</div>
			<div class="foot">
				<%@include file="../PaginaUtili/footer.jsp"%>
			</div>
		</div>
	</body>
</html>