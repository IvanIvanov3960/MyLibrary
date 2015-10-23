<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>List of Books</h2>
	<table>
		<tr>
			<td colspan="2">${author.name}</td>
		</tr>
		<tr>
			<td>NAME</td>
			<td>Status</td>
		</tr>

		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.status}</td>
				<td>
					<form:form action="/MyLibrary/authors/${author.id}/books/${book.id}" method="GET">
						<input type="submit" value="Edit Book" />
					</form:form>
				</td>
				<td>
					<form:form action="/MyLibrary/authors/${author.id}/books/${book.id}" method="DELETE">
						<input type="submit" value="Delete Book" />
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/authors/${author.id}/books/new' />">Add New Book</a>
	<br /> Go back to
	<a href="<c:url value='/' />">Home</a>
</body>
</html>