<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.model.*, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carrello</title>
		<style><%@include file="carrello.css"%></style>
	</head>
	<body>
		<% 
			HttpSession sessionUser = request.getSession();
			CarrelloBean carrello = (CarrelloBean) sessionUser.getAttribute("carrello");	
			
		%>
		<div class="main">
			<div class="head"> <%@include file="../PaginaUtili/header.jsp"%> </div>
				<div class="carrello">
				   <div class="item_carrello">
					<% if(carrello.isEmpty()) {
						%>
						<div class="vuoto">Il carrello è vuoto, aggiungi qualcosa!</div>
					
					<%
						} else {
					%>
							<% 
								int i = 0;
								while(i < carrello.getSizeList()){
									ProductBean bean = carrello.getAProduct(i);
							%>
							<div class="item">
								<div class="immagine">
									<img alt="" src="<%=bean.getPath()%>">
								</div>
								<div class="title">
									<p><%=bean.getName()%></p>
								</div>
								<div class="price">
									<%=bean.getPrice()%>
								
								</div>
							</div>
						<% i++;} %>
						</div>
						<%=carrello.giveTot() %>
					<% 
						
						}
					%>
					</div>
				</div>
		
	</body>
</html>