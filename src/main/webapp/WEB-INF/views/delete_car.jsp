<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.jspiders.springmvc.dto.CarDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div align="center">

		<h2>List of cars</h2>
		<table border="1px solid black" style="background-color:aqua">

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
			</tr>

			<%
			List<CarDto> cars = (List<CarDto>) request.getAttribute("message");
			if (cars != null && cars.size() > 0) {
				for (CarDto car : cars) {
			%>

			<tr>

				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getPrice()%></td>

			</tr>

		

		<%
		}
		} else {
		%>

		<p>No car found</p>

		<%
		}
		%>
		</table>

	</div>



	<div align="center">
		<h3>Enter the Name of car you want to delete.</h3>
		<form action="delete_car" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td> <input type="text" name="name" required="required"> </td>
				</tr>
			</table>
			
			<input type="submit" value="Delete">
		</form>
	</div>
	
	<%!String message;%>
	<%
	message = (String) request.getAttribute("msg");
	%>
	<div align="center">
		<%
		if (message != null  && !message.isEmpty()) {
		%>
		<h4><%=message%>
		</h4>
		<%
		}
		%>
	</div>
 
</body>
</html>