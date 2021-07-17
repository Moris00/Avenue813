<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% HttpSession sessionUser = request.getSession();
    	if(sessionUser.getAttribute("username") == null &&  sessionUser.getAttribute("passw") == null){
    		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
    	}
    	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini di <%=sessionUser.getAttribute("username")%></title>
		<style><%@include file="mieiordini.css"%></style>
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../PaginaUtili/header.jsp"%>
			</div>
			<div class="content">
				<div class="titolo"><h1 align="center">I tuoi ordini</h1></div>
				<fieldset class="fields"> 
					<legend>ID ORDER: content</legend>
					<div class="item">
						<div class="image_item">
							<img src="/Avenue813/immagini_prodotti/error.png">
						</div>
						<div class="desc_item">
							<p>dlsakdòlas
							adaslòkdòalskd</p>
						</div>
					
					</div>
				</fieldset>
			</div>
			<div class="foot">
				<%@include file="../PaginaUtili/footer.jsp"%>
			</div>
		</div>
	</body>
</html>