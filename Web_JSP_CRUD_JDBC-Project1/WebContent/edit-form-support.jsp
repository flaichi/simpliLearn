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
			action="<%=request.getContextPath()%>/MyServlet?action=updatesupport"
			method="POST">
			<div class="form-group">
				<input type="hidden" name="sId" value="${user.sId}">
			</div>
			<div class="form-group">
				<label for="name">User Name</label> <input type="text"
					class="form-control" name="sName"
					value="<c:out value="${user.sName}"/>">
			</div>
			<div class="form-group">
				<label for="email">User Email</label> <input type="email"
					class="form-control" name="sEmail"
					value="<c:out value= '${user.sEmail}'/>" />
			</div>
			<div class="form-group">
				<label for="country">User Country</label> <input type="text"
					class="form-control" name="sCountry"
					value="<c:out value= '${user.sCountry}'/>" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-default">Cancel</button>
			
		 
		</form>
	</div>

</body>
</html>