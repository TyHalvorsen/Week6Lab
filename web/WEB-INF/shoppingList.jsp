<%-- 
    Author     : TyHalvorsen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List!</h1>
        <h2>Greetings ${username}. Here is your list!</h2>
        <form method="post" action="shoppingList">
            Click to add item: <input type="text" name="addToList">
            <br>
            <input type="submit" name="submit" name="textButton" value="addItem">
            <br>
            <c:forEach var="item" items="${items}">
                <input type="radio" name="radioButton" value="${item}">
                ${item}
                <br>
            </c:forEach>
            <br>
            <input type="submit" name="textButton" value="delete">
        </form>
        <br>
        <a href=shoppingList?logOut">LogOut</a>
    </body>
</html>
