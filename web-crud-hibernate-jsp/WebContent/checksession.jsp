<%
	if (session.getAttribute("username") == null) {
%>
<jsp:forward page="login.jsp" />
<%
	}
%>