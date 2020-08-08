package com.fl.web;

import com.fl.model.Login;
import com.fl.model.Sale;
import com.fl.model.Support;
import com.fl.userDAO.SaleDAO;
import com.fl.userDAO.SupportDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String role = "admin";

	private SaleDAO userDAO;
	private SupportDAO supportDAO;

	public loginServlet() {
		super();
		userDAO = new SaleDAO();
		supportDAO = new SupportDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dEfault is Sales dpt when app starts.
		System.out.println("login servelte ...");
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		PrintWriter writer = response.getWriter();
		Login login = new Login();
		HttpSession session = request.getSession();
		try {
			login = userDAO.authenticateUser(name, pass);
			System.out.println("Login Email: " + login.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (login.getUserName() == null) {
			System.out.println("Empty!!!");
			request.getRequestDispatcher("login.jsp").include(request, response);
			writer.println("<h4 style='color:red;' class=\"row align-items-center\" >Invalid Credentials..</h4>");
		} else if (login.getRole().toLowerCase().equals(role)) {
			session.setAttribute("username", login.getUserName());
			session.setAttribute("role", login.getRole());
			List<Sale> userList = null;
			List<Support> supportList = null;
			try {
				userList = userDAO.selectAllUser();
				supportList = supportDAO.selectAllUser();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("listUser", userList);
			session.setAttribute("listUser1", supportList);
			request.getRequestDispatcher("sales.jsp").include(request, response);
		} else {
			session.setAttribute("role", "");
			request.getRequestDispatcher("sales.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		// System.out.println("login servelte ...");
	}
}
