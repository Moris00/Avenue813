<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , it.avenue813.model.*, it.avenue813.utils.*"%>
    
<%
	Collection<?> products = (Collection<?>) request.getAttribute("products");

	String error = (String) request.getAttribute("error");
	HttpSession sessionUser = request.getSession();
		String sesso = request.getParameter("Sesso");
		String category = request.getParameter("Category");
			if(sesso == null){
				sesso = "uomo";
			}
		
			
			if(products == null && category == null){
				Utility.print(request.getParameter("Category")+"123");
				response.sendRedirect(response.encodeRedirectURL("../ProductControl?Sesso="+sesso));
			}else{
			
			if(category != null){
				response.sendRedirect(response.encodeRedirectURL("../ProductControl?Sesso="+sesso+"&Category="+category));
			}
		
		}

%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Benvenuti nello Shop Avenue813</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<style>
				<%@include file="shopstyle.css" %>
		</style>
		
	</head>
	
	<body>
		
		<div class="main">
			<div class="head">
			
			<%@include file="../PaginaUtili/header.jsp"%>
			</div>
			
		     
			<div class="shopmain">	
					<div class="category">
					
						<div class="content_category">
							
							<input type="search" name="cerca" id="cerca" onkeydown="ricerca()">
							<div class="content_search">asdassd</div>
							 <%if(sessionUser.getAttribute("role") == "Admin"){ %>
								<button onclick="location.href='/Avenue813/PaginaShop/admin/aggiungi_prodotti.jsp'">Aggiungi prodotto</button>
							<% } %><br>
							<form action="/Avenue813/ProductControl1?Sesso=uomo" method="GET">
								<input type="text" id="cose" name="Sesso" value="<%=sesso%>" readonly>
								<input type="submit" name="Category" value="Maglie"><br>
								<input type="submit" name="Category" value="Pantaloni"><br>
								<input type="submit" name="Category" value="Sneakers"><br>
								<input type="submit" name="Category" value="Accessori"><br>
								<input type="submit" name="Category" value="Saldi"><br>
							</form>
						</div>
						
					</div>
					<div class="products">
				
					<div class="products_title">
						<span></span>
					</div>
					
					<div class="products_content">
					
						<div class="list">
						<%
							if(products != null && products.size() > 0 ){
								Iterator<?> it = products.iterator();
								while(it.hasNext()){
									ProductBean bean = (ProductBean)it.next();
						%>
						
						
							<div class="product">
								<%if(sessionUser.getAttribute("role") == "Admin"){ %>
								<div class="remove_product">
									<form name="remove" action="/Avenue813/RemoveProductList" method="GET">
										<input type="submit" name=<%=bean.getId()%> value="X">
									</form>
								</div>
								<% } %>
								<div class="image_product">
									<img src="<%=bean.getPath()%>" width=150px height="150px" alt="/Avenue813/immagini_prodotti/error.png">
								</div>
								<div class="buy_price">
									<div class="product_name">
										<span class="nome_prodotto"><%= bean.getName() %></span>
									
									</div>
									<div class="buy_button">
									<form action="/Avenue813/ViewProductServlet" method="GET">
										<input type="submit" value="Dettagli" name=<%=bean.getId()%>>
									</form>
									</div>
									<div class="price">
										<% if(sessionUser.getAttribute("username") == null && sessionUser.getAttribute("passw") == null) { %>
											<span> <a href="/Avenue813/PaginaAutenticazione/login.jsp">Accedi!!</a></span>
										<%	}else{ %>
											<span class="prezzo_prodotto"><%= bean.getPrice() %> &euro;</span>
										<%} %>
									</div>
										
								</div>
							</div>
						
						<%
								}
							} 
						%>
						
						</div>
					
					</div>
				</div>
				<div class="carrello">
						<div class="content_carrello">
							<div class="item">
								<img src="/Avenue813/immagini/Logo-Nike-Swoosh.png" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/ADIDAS.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/PUMA.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/SUPREME.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/BULLS.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/LOGHI.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
						</div>
					
				</div>
					
				</div>
			 
				<div id="footer">
					<%@ include file="../PaginaUtili/footer.jsp"%>
				</div>
		</div>
		
		
	</body>
	<script type="text/javascript">
		function clickButton(){
			var xhr = new XMLHttpRequest();
			
			xhr.open('GET', 'ProductControl1', true);
			xhr.send(null);
			
		}
	</script>
</html>