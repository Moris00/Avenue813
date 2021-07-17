<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Pagina Utente</title>
</head>
<body>

<%
		HttpSession userSession = request.getSession();
	%>
	
<h1 > Benvenuto, <%=userSession.getAttribute("username")%></h1>
<img src="/Avenue813/immagini/loginimg.png" alt="immagine utente" width=300px; height=350px;>
<label for="file">Select a photo</label><input type="file" id="file" name="file" multiple > 


<label for="file">Nome : <%=userSession.getAttribute("pname")%></label>
<label for="file">Cognome : <%=userSession.getAttribute("secondname")%></label>
<label for="file">Username : <%=userSession.getAttribute("username")%></label>
<label for="file">E-mail : <%=userSession.getAttribute("email")%></label>
<label for="file">Password : <%=userSession.getAttribute("passw")%></label>
</body>
</html>