<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.avenue813.model.CarrelloBean"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carrello</title>
	</head>
	<body>
		<% 
			HttpSession sessionUser = request.getSession();
			CarrelloBean carrello = (CarrelloBean) sessionUser.getAttribute("carrello");	
			
		%>
		
	</body>
</html>