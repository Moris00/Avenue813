<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.model.*, java.util.*"%>
    
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carrello</title>
		<style><%@include file="carrello.css"%></style>
		 <script src="script/selectMethod.js"></script> 
		 <script src="script/validAcquisto.js"></script> 
		 <script src="script/deleteAjax.js"></script>
		 <script>
		 	function displayResults(listaXml, id){
		 		try{
		 			var obj = document.getElementById(id);
		 			if(obj != null){
		 				obj.innerHTML = "Prodotto eliminato!";
		 			}
		 		}catch(e1){
		 			
		 		}
		 	}
		 
		 
		 </script>
		 
	</head>
	<body>
	
	<%
		HttpSession sessionUser = request.getSession();
		
	
	%>
		<div class="main">
				
				<div class="head"><%@include file="../PaginaUtili/header.jsp"%></div>
				<div class="update"><p id="update_title"></p></div>
				<div class="carrello">
				
				   <div class="item_carrello">
				  
					<% 
				if(sessionUser.getAttribute("username") != null && sessionUser.getAttribute("passw") != null){
					CarrelloBean carrello = (CarrelloBean) sessionUser.getAttribute("carrello");	
					if(carrello == null) {
						%>
						<div class="vuoto">Il carrello � vuoto, aggiungi qualcosa!</div>
						
					<%	
						} else if(carrello.isEmpty()){
							%>
							<div class="vuoto">Il carrello � vuoto, aggiungi qualcosa!</div>
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
										<input type="button" value="Elimina" onclick="deleteAjaxCall('update_title', '/Avenue813/RemoveProductCarrelloServlet', displayResults, '<%=bean.getName()%>');">
									</div>
								</div>
								</form>
							</div>
						<% i++;} %>
					
						</div>
						<div class="pagamento">
						<form name="pagament" onsubmit="return isValidOrder()" action="/Avenue813/AcquistoServlet" method="POST">
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
										<li><input type="text" name="nome" id="nome" placeholder="Nome" onblur="return isValidName()">
										<li><input type="text" name="cognome" id="cognome" placeholder="Cognome" onblur="return isValidSecondName()">
										<li><input type="text" name="citta" id="citta" placeholder="Citt�" onblur="return isValidCitta()">
										<li><input type="text" name="indirizzo" id="indirizzo" placeholder="Indirizzo" onblur="return isValidIndirizzo()">
										<li><input type="text" name="telefono"  id="telefono" placeholder="Telefono" onblur="return isValidTel()">
									</ul>
								</div>
								<div id="details_card">
									<ul>
										<li><input type="text" name="codice" id="codice" placeholder="Codice Carta" onblur="return isValidNum()">
										<li><input type="text" name="intestatario" id="intestatario" placeholder="Intestatario" onblur="return isValidInt()">
										<li><input type="text" name="cvc" id="cvc" placeholder="CVC" onblur="return isValidCVC()">
									</ul>
								</div>
								<div id="error"><p id="title_error"> </p></div>
								<div id="details_order">
									<h3 id="tot">Totale: <%=carrello.giveTot() %> &euro;</h3>
									
									<input type="submit" value="Procedi">
								</div>
							
							</div>
							</form>
						</div>
						
					<% 
						}
					}else{
							response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
						}
					%>
					</div>
				</div>
		
	</body>
</html>