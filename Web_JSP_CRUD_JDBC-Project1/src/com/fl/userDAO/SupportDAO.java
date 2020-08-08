package com.fl.userDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fl.model.Login;
import com.fl.model.Support;

public class SupportDAO {

	
	//private static final String   tablName= "users";
	private String jdbcURL = "jdbc:mysql://localhost:3306/sampledb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "farouk";

	
	
	private static final String INSERT_USERS_SQL = "INSERT INTO support (name, email, country) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from support where id =?";
	private static final String SELECT_ALL_USERS = "select * from support";
	private static final String DELETE_USERS_SQL = "delete from support where id = ?;";
	private static final String UPDATE_USERS_SQL = "update  support set name = ?,email= ?, country =? where id = ?;";
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

	public void insertUser(Support user) throws SQLException {
		System.out.println("setting tablename in select users"+ INSERT_USERS_SQL);

		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_USERS_SQL);
		stmt.setString(1, user.getsName());
		stmt.setString(2, user.getsEmail());
		stmt.setString(3, user.getsCountry());
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

	public boolean updateUser(Support user) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_USERS_SQL);
		stmt.setString(1, user.getsName());
		stmt.setString(2, user.getsEmail());
		stmt.setString(3, user.getsCountry());
		stmt.setInt(4, user.getsId());
		boolean result = stmt.executeUpdate() > 0;
		conn.close();
		return result;
	}
	
	

	public List<Support> selectAllUser() throws SQLException {
		List<Support> userList = new ArrayList<Support>();
		Connection conn = getConnection();
		System.out.println("setting tablename in select users"+ SELECT_ALL_USERS);
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_USERS);
		//stmt.setString(1, tablName);
		System.out.println("setting tablename in select users");
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			Support user = new Support();
			user.setsId(result.getInt(1));
			user.setsName(result.getString(2));
			user.setsEmail(result.getString(3));
			user.setsCountry(result.getString(4));
			userList.add(user);
		}
		return userList;
	}

	public Support selectUser(int id) throws SQLException {
		Support user = new Support();
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_ID);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			user.setsId(result.getInt(1));
			user.setsName(result.getString(2));
			user.setsEmail(result.getString(3));
			user.setsCountry(result.getString(4));
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
