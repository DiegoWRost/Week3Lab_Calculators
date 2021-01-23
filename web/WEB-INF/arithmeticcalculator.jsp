<%-- 
    Document   : arithmeticcalculator
    Created on : Jan 22, 2021, 3:56:50 PM
    Author     : 806509
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form method="post" action="arithmetic">
            First: <input type="text" name="firstNumber" value="${firstNumber}"><br>
            Second: <input type="text" name="secondNumber" value="${secondNumber}"><br>
            <input type="submit" value="+" name="submit">
            <input type="submit" value="-" name="submit">
            <input type="submit" value="*" name="submit">
            <input type="submit" value="%" name="submit"><br><br>
        </form>
            Result: ${message} <br>
           <a href="age">Age Calculator</a>
    </body>
</html>
