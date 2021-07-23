<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , it.avenue813.model.*, it.avenue813.utils.*, javax.sql.*"%>
    
    <% HttpSession sessionUser = request.getSession();
    	if(sessionUser.getAttribute("username") == null &&  sessionUser.getAttribute("passw") == null){
    		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
    	}
    	
    	
    	
    	int numero_ordini = Integer.parseInt((String) sessionUser.getAttribute("numero_ordini")); 
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
				<%}else { while(i-1 < numero_ordini){ %>
				<fieldset class="fields"> 
					<legend>ID ORDER: <%=i%></legend>
					<%
						OrderModelDS orderModel = new OrderModelDS((DataSource) getServletContext().getAttribute("DataSource"));
					
						ArrayList<?> products = orderModel.giveProducts(i); 
						int n = products.size();
						int j = 0;
						double tot = 0;
						
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
							<h3>Metodo Pagamento: <%=orderModel.doRetrieveMethodPagament(i)%></h3><h3>Totale spesa:<%=tot%></h3>
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