package com.fl.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fl.model.Sale;
import com.fl.model.Support;
import com.fl.userDAO.SaleDAO;
import com.fl.userDAO.SupportDAO;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SupportDAO supportDAO;
	private SaleDAO saleDAO;


	public MyServlet() {
		super();
		saleDAO = new SaleDAO();
		supportDAO = new SupportDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println("servletPath: " + servletPath);
		String action = request.getParameter("action");
		System.out.println("action: " + action);
		

		try {

			switch (action) {

			case "newsale":
				saleAdd(request, response);
				break;
			case "newsupport":
				supportAdd(request, response);
				break;

			case "login":
				login(request, response);
				break;
			case "logout":
				logout(request, response);
				break;

			case "saleform":
				saleform(request, response);
				break;
			case "supportform":
				supportform(request, response);
				break;

			case "deletesale":
				deletesale(request, response);
				break;

			case "editsale":
				editsale(request, response);
				break;

			case "updatesale":
				updatesale(request, response);
				break;

			case "sale":				
				saleList(request, response);
				break;
			case "support":				
				supportList(request, response);
				break;
			case "editsupport":
				editsupport(request, response);
				break;

			case "deletesupport":				
				deletesupport(request, response);
				break;
			case "updatesupport":
				updatesupport(request, response);
				break;


			default:
				saleList(request, response);
				break;
			}

		} catch (Exception ex) {
			System.out.println("Exception Caught from swicth  : ");
			System.out.println(ex.getMessage());
		}
	}

	private void updatesale(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		System.out.println("1  update method ...");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("2  Hi Update..");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		System.out.println("3    Hi Update.2.");
		Sale book = new Sale(id, name, email, country);
		saleDAO.updateUser(book);
		try {
			saleList(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updatesupport(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		System.out.println("1  update method ...");
		int id = Integer.parseInt(request.getParameter("sId"));
		System.out.println("2  Hi Update..");
		String name = request.getParameter("sName");
		String email = request.getParameter("sEmail");
		String country = request.getParameter("sCountry");
		System.out.println("3    Hi Update.2.");
		Support book  = new Support(id, name, email, country);
		supportDAO.updateUser(book);
		try {
			supportList(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void editsale(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("editform method ...");
		int id = Integer.parseInt(request.getParameter("id"));
 		Sale existingUser = saleDAO.selectUser(id);
 		RequestDispatcher rd = request.getRequestDispatcher("edit-form-sale.jsp");
		request.setAttribute("user", existingUser);
 		rd.forward(request, response);
 	}
	private void editsupport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("editform method ...");
		int id = Integer.parseInt(request.getParameter("id"));
 		Support existingUser = supportDAO.selectUser(id);
 		RequestDispatcher rd = request.getRequestDispatcher("edit-form-support.jsp");
		request.setAttribute("user", existingUser);
 		rd.forward(request, response);
 	}

	private void saleform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("sale-form.jsp");
		rd.forward(request, response);

	}
	private void supportform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("support-form.jsp");
		rd.forward(request, response);

	}

	private void deletesale(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("deleting User");

		int id = Integer.parseInt(request.getParameter("id"));
		if (saleDAO.deleteUser(id)) {
			try {
				saleList(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("erro in ndel user");
		}
	}
	private void deletesupport(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("deleting User");

		int id = Integer.parseInt(request.getParameter("id"));
		if (supportDAO.deleteUser(id)) {
			try {
				supportList(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("erro in ndel user");
		}
	}

	private void saleList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {

		List<Sale> saleList = saleDAO.selectAllUser();
		request.setAttribute("listUser", saleList);

		System.out.println(saleList);

		RequestDispatcher rd = request.getRequestDispatcher("sales.jsp");
		rd.forward(request, response);

	}
	private void supportList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {

		List<Support> supportList = supportDAO.selectAllUser();
		System.out.println("List of support: "+supportList);
		// important to tag the userlist same to be called from JSP file.
		request.setAttribute("listUser1", supportList);
		// important to tag the listUSer1 same to be called from JSP file.
		System.out.println(supportList);

		RequestDispatcher rd = request.getRequestDispatcher("support.jsp");
		rd.forward(request, response);

	}

	private void saleAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		Sale newUser = new Sale(name, email, country);
		saleDAO.insertUser(newUser);
		try {
			saleList(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void supportAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("adding support...");
		String name = request.getParameter("sName");
		String email = request.getParameter("sEmail");
		String country = request.getParameter("sCountry");
		System.out.println("country: "+country);
		Support newUser = new Support(name, email, country);
		supportDAO.insertUser(newUser);
		try {
			supportList(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		System.out.println("logout user...");
		/*
		 * HttpSession session=request.getSession(); session.invalidate();
		 * RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		 * rd.forward(request, response);
		 */

	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		System.out.println("logout user...");
		HttpSession session=request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
