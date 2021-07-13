<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.model.*, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carrello</title>
		<style><%@include file="carrello.css"%></style>
		 <script src="script/selectMethod.js"></script> 
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
										<input type="text" name="name_product" value="<%=bean.getName()%>" readonly>
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
						<div class="pagamento">
						<form name="pagament" >
							<h3>METODO DI PAGAMENTO</h3>
							<div class="method_pagamento">
							
								<ul>
									<li><input type="radio" name="metodo" value="Visa" id="visa" onclick=" selectMethod()"><img src="/Avenue813/immagini/visa.png"></li>
									<li><input type="radio" name="metodo" value="Mastercard" onclick=" selectMethod()"><img src="/Avenue813/immagini/mastercard.png"></li>
									<li><input type="radio" name="metodo" value="American" onclick=" selectMethod()"><img src="/Avenue813/immagini/american.png"></li>
									<li><input type="radio" name="metodo" value="Contrassegno" onclick=" selectMethod()"><img src="/Avenue813/immagini/contrassegno.png"></li>
								</ul>
							
							</div>
							<div class="details_pagamento">
								<div id="details_user">
									<ul>
										<li><input type="text" name="nome" placeholder="Nome">
										<li><input type="text" name="cognome" placeholder="Cognome">
										<li><input type="text" name="indirizzo" placeholder="Indirizzo">
										<li><input type="text" name="telefono" placeholder="Telefono">
									</ul>
								</div>
								<div id="details_card">
									<ul>
										<li><input type="text" name="codice" placeholder="Codice Carta">
										<li><input type="text" name="intestatario" placeholder="Intestatario">
										<li><input type="text" name="cvc" placeholder="CVC">
									</ul>
								</div>
								<div id="details_order">
									<h3>Totale: <%=carrello.giveTot() %> &euro;</h3>
									<input type="submit" value="Procedi">
								</div>
							
							</div>
							</form>
						</div>
						
					<% 
						
						}
					%>
					</div>
				</div>
		
	</body>
</html>