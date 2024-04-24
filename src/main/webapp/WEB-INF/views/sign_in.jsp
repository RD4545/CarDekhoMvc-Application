<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif; 
        background-color: #f2f2f2; 
        margin: 0;
        padding: 0;
    }
    #box {
        position: absolute; 
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    input[type="text"],
    input[type="password"],
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
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
        margin-top: 20px;
        color: #ff0000; 
    }
</style>

</head>
<body>

	<div id="box">
		<form action="check_user" method="post">
			<table cellpadding="5">
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" required="required" autocomplete="on"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required" autocomplete="on"></td>
				</tr>
			</table>
			<input type="submit" value="Sign In">
		</form>
	</div>
	
	
	<div class="message">
	
        <% String msg = (String) request.getAttribute("message");
        if (msg != null) { 
        %>
        
        <h3><%=msg%></h3>
        
        <% 
        }
        %>
    </div>

</body>
</html>
