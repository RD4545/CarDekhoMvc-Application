<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Car Details</title>

<style type="text/css">
    body {
        background-color: #f2f2f2;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    #box {
        background-color: #fff;
        width: 300px;
        margin: 50px auto;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h3 {
        margin-top: 0;
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
    }
    table td {
        padding: 10px 0;
    }
    input[type="text"],
    input[type="submit"] {
        width: calc(100% - 20px);
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    .message {
        text-align: center;
        color: red;
        margin-top: 20px;
    }
</style>

</head>
<body>

<div id="box">
    <h3>Add Car Details</h3>
    <form action="add_car" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" required="required"></td>
            </tr>
            <tr>
                <td>Brand</td>
                <td><input type="text" name="brand" required="required"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" required="required"></td>
            </tr>
        </table>
        <input type="submit" value="Add">
    </form>
    <h3> Do you want to go to <a href="home">Home Page</a> ?</h3>
</div>

<% 
    String msg = (String) request.getAttribute("message");
    if(msg != null) { %>
    <div class="message">
        <h3><%=msg%></h3>
    </div>
<% } %>

</body>
</html>
