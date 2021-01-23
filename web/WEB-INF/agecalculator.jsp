<%-- 
    Document   : agecalculator
    Created on : Jan 21, 2021, 10:07:32 PM
    Author     : Diego Weidle Rost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        
        <form method="post" action="age">
            Enter your age: <input type="text" name="enterAge" value="${age}"><br>
            <input type="submit" value="Age next birthday"><br>
        </form>
        ${message}<br>
        <a href="arithmetic">Arithmetic Calculator</a>
    </body>
</html>
