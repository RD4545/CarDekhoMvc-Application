<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
    }

    #signup-container {
        width: 300px;
        margin: 50px auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 200px auto;
    }

    h3 {
        font-size: 24px;
        text-align: center;
    }

    table {
        width: 100%;
    }

    table td {
        padding: 10px;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        border: none;
        border-radius: 3px;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .message {
        text-align: center;
        margin-top: 20px;
        color: #ff0000; 
    }
</style>
</head>
<body>

<div id="signup-container">
    <h3>Sign Up</h3>
    <form action="add_user" method="post">
        <table>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" required="required"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" required="required"></td>
            </tr>
        </table>
        <input type="submit" value="Sign Up">
    </form>
    
    <div class="message">
	
        <% String msg = (String) request.getAttribute("message");
        if (msg != null) { 
        %>
        
        <h3><%=msg%></h3>
        
        <% 
        }
        %>
    </div>
</div>


	


</body>
</html>
