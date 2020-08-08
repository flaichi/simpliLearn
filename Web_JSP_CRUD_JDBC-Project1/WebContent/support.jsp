<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>

<body>

	<jsp:include page="checksession.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Content Begin -->
	<div class="container">
		<br /> <br /> 
		<a href="<%=request.getContextPath()%>/MyServlet?action=supportform"
			class="btn btn-success">Create New support User</a><br /> <br /> 
		<br />
		<h3>Support List</h3>
		<br />
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listUser1}">
					<tr>
						<td><c:out value="${user.sId}"></c:out></td>
						<td><c:out value="${user.sName}"></c:out></td>
						<td><c:out value="${user.sEmail}"></c:out></td>
						<td><c:out value="${user.sCountry}"></c:out></td>
						<td><a
							href="<%= request.getContextPath() %>/MyServlet?action=editsupport&id=<c:out value="${user.sId}"/>"
							class="btn btn-secondary">
							Edit
							<input type="hidden" value="sales" id="sales"/>
							</a> <a
							href="<%= request.getContextPath() %>/MyServlet?action=deletesupport&id=<c:out value='${user.sId}' />"
							class="btn btn-danger">Delete
							<input type="hidden" value="sales" id="sales"/>
							</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Content End -->

	<!-- Footer Begin -->
	<!-- Footer End -->

	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>

</html>