<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jspiders.springmvc.dto.CarDto"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Cars</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
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

  .delform,
  .editform {
    display: inline-block;
  }

  .action-button {
    background-color: transparent;
    border: none;
    padding: 0;
    cursor: pointer;
    margin-right: 5px; /* Adjust spacing between buttons */
  }

  .action-button i {
    color: #007bff; /* Blue color for edit icon */
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
    <h2>List of cars</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Action</th>
        </tr>

        <%
        List<CarDto> cars = (List<CarDto>) request.getAttribute("cars");
        if (cars != null && cars.size() > 0) {
            for (CarDto car : cars) {
        %>

        <tr>
            <td><%=car.getId()%></td>
            <td><%=car.getName()%></td>
            <td><%=car.getBrand()%></td>
            <td><%=car.getPrice()%></td>
            <td>
                <form action="delete_car" class="delform" method="post">
                    <input type="hidden" name="carId" value="<%=car.getId()%>">
                    <button type="submit" class="action-button">
                      <i class="fas fa-trash-alt"></i> Delete
                    </button>
                </form>
                <form action="edit_car" class="editform" method="post">
                    <input type="hidden" name="id" value="<%=car.getId()%>">
                    <button type="submit" class="action-button">
                      <i class="fas fa-edit"></i> Edit
                    </button>
                </form>
            </td>
        </tr>

        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5"><p>No car found</p></td>
        </tr>
        <%
        }
        %>
        <tr>
            <td colspan="5" class="message"><h3>Do you want to go to <a href="home">Home Page</a>?</h3></td>
        </tr>
    </table>
</div>

</body>
</html>
