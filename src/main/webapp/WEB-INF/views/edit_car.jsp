<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jspiders.springmvc.dto.CarDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}

#box {
    border: 3px solid #ccc;
    height: auto;
    width: 440px;
    background-color: chocolate;
    margin: 140px auto;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

#head {
    font-size: 30px;
    text-align: center;
}

.input {
    background-color: gray;
    border: 1px solid;
    padding: 10px;
    width: 250px;
    margin-top: 10px;
}

.label {
    font-size: 20px;
    padding-top: 10px;
}

#button {
    border: 1px solid;
    background-color: black;
    color: gray;
    border-radius: 5px;
    padding: 10px;
    width: 80px;
    margin-left: 245px;
    margin-top: 10px;
    font-size: 15px;
}

#message {
    font-size: 25px;
    text-align: center;
}

a {
    text-decoration: none;
}
</style>



</head>
<body>

	
	<%
		CarDto car = (CarDto) request.getAttribute("car");
	%>
	<div id="box" align="center">
		<h3 id="head">Update Car Details</h3>
		<form action="update_car" method="post">
			<table>
				<tr>
					<td class="label">Id</td>
					<td><input class="input" type="text" name="id"
						value="<%=car.getId()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td class="label">Name</td>
					<td><input class="input" type="text" name="name"
						value="<%=car.getName()%>" required="required"></td>
				</tr>
				<tr>
					<td class="label">Brand</td>
					<td><input class="input" type="text" name="brand"
						value="<%=car.getBrand()%>" required="required"></td>
				</tr>
				<tr>
					<td class="label">Price</td>
					<td><input class="input" type="text" name="price"
						value="<%=car.getPrice()%>" required="required"></td>
				</tr>
			</table>
			<input id="button" type="submit" value="UPDATE">
		</form>
		<h3>
			Do you want to go to <a href="home">Home Page</a> ?
		</h3>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<div align="center">
		<h3 id="message"><%=message%></h3>
	</div>
	<%
	}
	%>

</body>
</html>