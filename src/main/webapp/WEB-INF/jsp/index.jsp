<%-- 
    Document   : index.jsp
    Created on : Aug 16, 2023, 5:32:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <h1>Categories</h1>
        <ul>
            <th:forEach var="cat" items="${categories}">
                <li>${cat.name}</li>
            </th:forEach>
        </ul>
    </body>
</html>
