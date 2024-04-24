<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.jspiders.springmvc.dto.CarDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Cars</title>
<style>
  body {
    background-color: #f2f2f2;
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }

  .container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  h2 {
    text-align: center;
    color: #333;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }

  th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }

  th {
    background-color: #f2f2f2;
    color: #333;
    font-weight: bold;
  }

  tr:hover {
    background-color: #f9f9f9;
  }

  p {
    text-align: center;
    color: #777;
  }

  a {
    color: #007bff;
    text-decoration: none;
  }

  a:hover {
    text-decoration: underline;
  }

  .message {
    padding: 20px;
  }
</style>
</head>
<body>

	

<div class="container">
	<div id="box">
		<form action="search" method="post">
			<label>Low price</label> <input type="text" name="low"
				required="required"> <label>High price</label> <input
				type="text" name="high" required="required"> <input
				id="button" type="submit" value="SEARCH">
		</form>
	</div>
    <h2>List of cars</h2>
    <table border="1px solid black" style="background-color: peru;">
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
        <tr>
            <td colspan="4"><p>No car found</p></td>
        </tr>
        <%
        }
        %>
    </table>
    <div align="center" class="message">
        <h3>Do you want to go to <a href="home">Home Page</a>?</h3>
    </div>
</div>

</body>
</html>
