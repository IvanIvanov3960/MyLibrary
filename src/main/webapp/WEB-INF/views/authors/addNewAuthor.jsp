<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<title>Author Details</title>
</head>
<body>
	<div class="container">
		<form:form modelAttribute="author" role="form">
			<form:input type="hidden" path="id" id="id" />
			<div class="form-group">
				<label for="name">Name: </label>
				<form:input path="name" id="name" />
				<form:errors path="name" cssClass="error" />
			</div>
			<form:select path="country" id="country">
				<form:options items="${countries}" />
			</form:select>
			<c:choose>
				<c:when test="${edit}">
					<form:form action="/MyLibrary/authors/${author.id}" method="PUT">
						<button type="submit" class="btn btn-default">Edit Author</button>
					</form:form>
				</c:when>
				<c:otherwise>
					<form:form action="/MyLibrary/authors/new" method="GET">
						<button type="submit" class="btn btn-default">Add Author</button>
					</form:form>
				</c:otherwise>
			</c:choose>
		</form:form>
		<br /> <br /> Go back to <a href="<c:url value='/' />">Home</a>
	</div>
</body>
</html>