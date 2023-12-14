<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品リスト</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
<p>でてほしいな</p>

<ul>
    <c:forEach var="item" items="${list}">
    	<li class="list-item">
	        <p class="item-ttl">${item.name }</p>
	        <p>${item.description }</p>

   		</li>
    </c:forEach>
</ul>

</body>
</html>
