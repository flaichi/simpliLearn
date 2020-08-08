<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editing User</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>
<body>

	<jsp:include page="checksession.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<br />
		<h2>Edit User</h2>
		<br />

		<form
			action="<%=request.getContextPath()%>/MyServlet?action=updatesale"
			method="POST">
			<div class="form-group">
				<input type="hidden" name="id" value="${user.id}">
			</div>
			<div class="form-group">
				<label for="name">User Name</label> <input type="text"
					class="form-control" name="name"
					value="<c:out value="${user.name}"/>">
			</div>
			<div class="form-group">
				<label for="email">User Email</label> <input type="email"
					class="form-control" name="email"
					value="<c:out value= '${user.email}'/>" />
			</div>
			<div class="form-group">
				<label for="country">User Country</label> <input type="text"
					class="form-control" name="country"
					value="<c:out value= '${user.country}'/>" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
	<!--  <button type="cancel" class="btn btn-primary">Cancel</button> --->
		</form>
	</div>
<!-- Full support of bootstrap library put at end of body--->

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


</body>
</html>