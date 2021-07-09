<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.model.CarrelloBean"%>
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
					<% if(carrello == null) {
						%>
						<div class="vuoto">Il carrello è vuoto, aggiungi qualcosa!</div>
					
					<%
						} else {
					%>
						<div class="content_carrello">
						
						
					
						</div>
				
					<% 
						}
					%>
					</div>
				</div>
		
		
		</div>
		
	</body>
</html>