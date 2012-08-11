package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.Info;

public class InfoQueries {

	private static final String URL = "jdbc:mysql://localhost/UserInfo_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private Connection connection = null;
	private PreparedStatement insertNewPerson = null;
	private PreparedStatement selectPeopleByUsername = null;

	public InfoQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = (Statement) connection.createStatement();

			String query = "CREATE TABLE IF NOT EXISTS Usertable(ID int, Username VARCHAR(30), Password VARCHAR(20))";
			stmt.executeUpdate(query);
			insertNewPerson = connection
					.prepareStatement("INSERT INTO Usertable "
							+ "(Username, Password)" + "VALUES (?, ?)");
			selectPeopleByUsername = connection
					.prepareStatement("SELECT * FROM Usertable WHERE Username=?");

		} catch (SQLException aesql) {
			aesql.printStackTrace();
			System.exit(0);
		}
	}

	public Boolean getPeopleByUsername(String name, String password) {
		List<Info> results = null;
		ResultSet resultSet = null;
		try {
			selectPeopleByUsername.setString(1, name);
			resultSet = selectPeopleByUsername.executeQuery();
			results = new ArrayList<Info>();
			while (resultSet.next()) {
				results.add(new Info(resultSet.getInt("ID"), resultSet
						.getString("Username"), resultSet
						.getString("Password")));
				if(resultSet.getString("Password").equals(password))
				{
					return true;					
				}				
			}
			return false;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}
	
		return false;
		
	}

	public int addPerson(String name, String password) {
		int result = 0;
		try {
			insertNewPerson.setString(1, name);
			insertNewPerson.setString(2, password);

			result = insertNewPerson.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}

	

	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
