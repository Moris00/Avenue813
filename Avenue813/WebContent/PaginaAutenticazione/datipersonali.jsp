<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
		HttpSession userSessionn = request.getSession();
	%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="ISO-8859-1">
		<title>Profilo <%=userSessionn.getAttribute("username")%></title>
		<style><%@include file="datipersonali.css"%></style>
	</head>
	<body>


	
		<div class="main">
			<div class="head">
				<%@include file="../PaginaUtili/header.jsp"%>
			</div>
			<div class="content">
				<div class="titolo">
					<h1> Benvenuto, <%=userSession.getAttribute("username")%></h1>
				</div>
				<div class = "image_profile">
					<img src="/Avenue813/immagini/loginimg.png" alt="immagine utente" width=300px; height=350px;>
					<input type="file" id="file" name="file" multiple > 
					<label for="file">Select a photo</label>
				</div>
				
				<div class = "dati_profile">
					<label for="file">Nome : <%=userSession.getAttribute("pname")%></label>
					<label for="file">Cognome : <%=userSession.getAttribute("secondname")%></label>
					<label for="file">Username : <%=userSession.getAttribute("username")%></label>
					<label for="file">E-mail : <%=userSession.getAttribute("email")%></label>
					<label for="file">Password : <%=userSession.getAttribute("passw")%></label>
				</div>
		
				
			</div>
		</div>
	
		
	</body>
</html>