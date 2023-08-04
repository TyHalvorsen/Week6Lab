<%-- 

    Author     : TyHalvorsen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action ="shoppingList" method="post">
            username: <input type="text" name="username">
            <input type="submit" name="register" value="registerValue">
        </form>
        <br>
        <p>${logOutMessage}</P>
        <p>${errorMessage}</p>
    </body>
</html>
