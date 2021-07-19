<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , it.avenue813.model.*, it.avenue813.utils.* , javax.sql.DataSource"%>
    <%
		HttpSession userSessionn = request.getSession();
    	
    
    	UserModelDS modelUser = new UserModelDS((DataSource)getServletContext().getAttribute("DataSource"));
    	String username = (String) userSessionn.getAttribute("username");
    	String password = (String) userSessionn.getAttribute("passw");
    	
    	if(userSessionn.getAttribute("username") == null && userSessionn.getAttribute("passw") == null){
    		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
    	}else{
    	
    		UserBean bean = modelUser.canLogin(username, password);
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
				
				<form name="dati" action="/Avenue813/UpdateDatiServlet" method="POST">
				
				<div id = "dati_profile">
					
					<h2>Nome :        <input type="text" value="<%=bean.getName()%>" name="nome"></h2><br>
					<h2>Cognome :      <input type="text" value="<%=bean.getSecond_name()%>" name="cognome"></h2><br>
					<h2>Username :     <input type="text" value="<%=bean.getUsername()%>" name="username"></h2><br>
					<h2>E-mail :           <input type="text" value="<%=bean.getEmail()%>" name="email"> </h2><br>
					<h2>Password Vecchia :  <input type="password" value="<%=bean.getPassword() %>" name="password"> </h2><br>
					<h2>Password Nuova :      <input type="password" value="" name="newpassword"></h2><br>
					<h2>Ripeti Password :     <input type="password" value="" name="newpassword2"></h2><br>
					<div class="pulsanti">
						<div class="error">
							<p id="errore">asdsad</p>
						</div>
						<input type="submit" value="Modifica">
					</div>
				</div>
				
				
				</form>
				
			</div>
		</div>
	
		
	</body>
</html>

<% }%>