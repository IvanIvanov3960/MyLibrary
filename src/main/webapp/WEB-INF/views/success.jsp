<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Success Page</title>
</head>
<body>
	message : ${success}
	<br />
	<br />
	<c:choose>
		<c:when test="${bookList}">
			Go back to <a href="<c:url value='/books/' />">List of All
				Books</a>
		</c:when>
		<c:otherwise>
			Go back to <a href="<c:url value='/authors/' />">List of All
				Authors</a>
		</c:otherwise>
	</c:choose>
</body>

</html>