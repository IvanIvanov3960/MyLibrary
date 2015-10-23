<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<title>Library</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2 class="text-center">
				<a href="<c:url value='/authors/' />">Welcome to Our Library</a>
			</h2>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NAME</th>
					<th>Country</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${authors}" var="author">
					<tr>
						<td><a href="<c:url value='/authors/${author.id}/books' />">${author.name}</a></td>
						<td>${author.country}</td>
						<td><form:form action="/MyLibrary/authors/${author.id}"
								method="GET">
								<button type="submit" class="btn btn-default">Edit
									Author</button>
							</form:form></td>
						<td><form:form action="/MyLibrary/authors/${author.id}"
								method="DELETE">
								<button type="submit" class="btn btn-default">Delete
									Author</button>
							</form:form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="<c:url value='/authors/new' />">Add New Author</a> <br />
		Go back to <a href="<c:url value='/' />">Home</a>
	</div>
</body>
</html>