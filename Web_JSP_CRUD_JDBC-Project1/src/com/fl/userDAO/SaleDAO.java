package com.fl.userDAO;




import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fl.model.Login;
import com.fl.model.Sale;

public class SaleDAO {


	
	//private static final String   tablName= "users";
	private String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
	private String jdbcUsername = "root";
	private String jdbcPassword = "farouk";

	
	
	private static final String INSERT_USERS_SQL = "INSERT INTO sales (name, email, country) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from sales where id =?";
	private static final String SELECT_ALL_USERS = "select * from sales ";
	private static final String DELETE_USERS_SQL = "delete from sales  where id = ?;";
	private static final String UPDATE_USERS_SQL = "update  sales  set name = ?,email= ?, country =? where id = ?;";
	private static final String AUTHENTICATE_USER = "select * from logintable where username=? and password=?";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(Sale user) throws SQLException {
		System.out.println("setting tablename in select sales"+ INSERT_USERS_SQL);

		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_USERS_SQL);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getCountry());
		stmt.executeUpdate();
		conn.close();
	}

	public boolean deleteUser(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_USERS_SQL);
		stmt.setInt(1, id);
		boolean result = stmt.executeUpdate() > 0;
		conn.close();
		return result;
	}

	public boolean updateUser(Sale user) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_USERS_SQL);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getCountry());
		stmt.setInt(4, user.getId());
		boolean result = stmt.executeUpdate() > 0;
		conn.close();
		return result;
	}
	
	

	public List<Sale> selectAllUser() throws SQLException {
		List<Sale> saleList = new ArrayList<Sale>();
		Connection conn = getConnection();
		System.out.println("setting tablename in select users"+ SELECT_ALL_USERS);
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_USERS);
		System.out.println("setting tablename in select users");
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			//Sale user = new Sale();
			Sale user = new Sale();
			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setCountry(result.getString(4));
			saleList.add(user);
		}
		return saleList;
	}

	public Sale selectUser(int id) throws SQLException {
		Sale user = new Sale();
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_ID);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setCountry(result.getString(4));
		}
		return user;
	}

	public Login authenticateUser(String username, String password) throws SQLException {
		Login login = new Login();
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(AUTHENTICATE_USER);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			login.setId(result.getInt(1));
			login.setFullName(result.getString(2));
			login.setEmail(result.getString(3));
			login.setUserName(result.getString(4));
			login.setPassword(result.getString(5));
			login.setRole(result.getString(6));
		}
		return login;
	}
}
