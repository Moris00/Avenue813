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
				  
					<% 


					if(carrello.isEmpty()) {
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
								 <form action="../RemoveProductCarrelloServlet" method="POST">
								<div class="immagine">
										<img alt="" src="<%=bean.getPath()%>">
									</div>
								<div class="desc">
									<div class="title">
										<input type="text" name="name_product" value="<%=bean.getName()%>">
									</div>
									<div class="price">
										<input type="text" name="price" value="<%=bean.getPrice()%> &euro;" disabled>
									</div>
									<div class="delete">
										<input type="submit" value="Elimina">
									</div>
								</div>
								</form>
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