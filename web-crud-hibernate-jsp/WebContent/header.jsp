<!-- Nav Bar Begin -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#"> Admin Portal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home 	<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true"> Departments: </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"  href="sales.jsp"> Sales</a> 
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="support.jsp">Support</a>
				</div></li>
			<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="false">Help</a></li>
		</ul>
			<ul class="nav navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Admin</a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a href="#print" class="dropdown-item" onClick="window.print()" >Print</a>
                        <div class="dropdown-divider"></div>
                        <a href="<%= request.getContextPath() %>/MyServlet?action=logout"class="dropdown-item">Logout</a>
                    </div>
                </li>
            </ul>
	</div>
</nav>
<!-- Nav Bar End -->