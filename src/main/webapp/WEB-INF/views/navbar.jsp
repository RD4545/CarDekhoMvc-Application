<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

body{
background-color: tomato;

 

}
#box {
	height: 50px;
	background-color: gray;
	border: 3px solid;
}

a {
	height: 30px;
	width: 60px;
	background-color: black;
	color: gray;
	margin-left: 20px;
	border-radius: 5px;
	padding: 10px;
	font-size: 20px;
	text-decoration: none;
}

nav {
	width: 600px;
	margin-top: 15px;
	margin-left: 800px;
	margin-top: 15px;
}
</style>
</head>
<body>

	<div id="box" align="center">
		<nav>
			<a href="add_car">ADD</a> 
			<a href="show_cars">All CARS</a> 
			
			 <a href="sign_out">SIGN OUT</a>
			 <a href="my_cars"> My Cars</a>
			  
		</nav>
	</div>

</body>
</html>