<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<style><%@include file="stylehome.css"%></style>
		<title>Avenue813</title>
	</head>
	
	<body>
		<button onclick="topFunction()" id="myBtn" title="Go to top">Sopra</button>
		<div class="">
				<%@ include file="../PaginaUtili/header.jsp" %>
		</div>
		
		<div class="tipi">
			<div class="freccia_dx">
			
			</div>
			<div class="galleria">
				<div class="slider">
                    <div class="slides">
                        <!-- radio button start-->
                        <input type="radio" name="radio_btn" id="radio1">
                        <input type="radio" name="radio_btn" id="radio2">
                        <input type="radio" name="radio_btn" id="radio3">
                        <input type="radio" name="radio_btn" id="radio4">
                        <!-- radio button end -->

                        <!-- slide images start -->
                        <div class="slide first">
                        <img src="/Avenue813/immagini/stussy.jpeg" alt="First_Image">
                        </div>

                        <div class="slide">

                        <img src="/Avenue813/immagini/carhartt.jpeg" alt="Second_Image">

                        </div>

                        <div class="slide">

                        <img src="/Avenue813/immagini/TNF.jpg" alt="Third_Image">

                        </div>

                        <div class="slide">

                        <img src="/Avenue813/immagini/nike.jpg" alt="Fourth_Image" >

                        </div>
                        <!-- slide images end -->

                        <!-- automatic navigation start -->
                        <div class="navigation-auto">
                          <div class="auto-btn1"></div>
                          <div class="auto-btn2"></div>
                          <div class="auto-btn3"></div>
                          <div class="auto-btn4"></div>
                        </div>
                        <!-- automatic navigation end -->
                        </div>
                   <!-- navigation-manual start -->
                   <div class="navigation-manual">
                   <label for="radio1" class= "manual-btn"></label>
                   <label for="radio2" class= "manual-btn"></label>
                   <label for="radio3" class= "manual-btn"></label>
                   <label for="radio4" class= "manual-btn"></label>
                   </div>
                   <!-- navigation-manual end -->
            </div>
            <!-- image slider end -->

            <script type="text/javascript">
            var counter = 1;
            setInterval(function(){
                document.getElementById('radio'+counter).checked = true;
                counter++;
                if(counter > 4){
                    counter = 1;
                }
            }, 5000);
            </script>
			</div>
			<div class="freccia_sx">
			
			</div>
			
		</div>
		
		<div class="information-div">
			<div class="information-content">
				<div class="descrizione_image">
					<div class="descrizione">
						<h2>COLLEZIONE DA UOMO</h2>
						<p>Summertime is a space-time dimension on its own.
						 Explore our streetwear essentials and help your mind release endorphins thanks to a comprehensive selection that include 
						 shoes, shirt, tote bags and more.</p>
					</div>
					<div class="immagine">
						<a href="/Avenue813/PaginaShop/shop.jsp">
						<img  src="/Avenue813/immagini/korea.jpeg" width ="120%" height="100%"></a>
					</div>
				</div>
			</div>
		
		</div>
		
		<div class="information-div1">
			<div class="information-content1">
				<div class="descrizione_image1">
					<div class="immagine1">
						<a href="/Avenue813/PaginaShop/shop.jsp">
						<img  src="/Avenue813/immagini/donna.jpeg" width ="80%" height="120%"></a>
					</div>
					<div class="descrizione1">
						<h2>COLLEZIONE DA DONNA</h2>
						<p>Avenue813 is the celebration of our sporting attitude that pushes us to be bold, dynamic and with a crazy desire to experiment.</p>
					</div>
					
				</div>
			</div>
		
		</div>
		
		<script>
			var mybutton = document.getElementById("myBtn");
			
			windows.onscroll = function() {scrollFunction()};
			
			function scrollFunction(){
				if(document.body.scrollTop > 20 || document.documentElement.scrollTop > 20){
					mybutton.style.display = "block";
				}else{
					mybutton.style.display = "none";
				}
			}
			
			function topFunction(){
				document.body.scrollTop = 0;
				document.documentElement.scrollTop = 0;
			}
		</script>
		
		<div id="footer">
		
		<%@ include file="../PaginaUtili/footer.jsp"%>
		
		</div>
		
	</body>
	
</html>