package survey_form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Survey;
import entities.User;
import entities.UserSurvey;
import managers.SurveyManager;
import managers.UserManager;

public class DataStore {
	private static List<User> users = new ArrayList<>();

	public static List<User> getUsers() {
		return users;
	}

	private static List<Survey> surveys = new ArrayList<>();

	public static List<Survey> getSurveys() {
		return surveys;
	}

	private static List<UserSurvey> userSurveys = new ArrayList<>();

	public static void loadData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// new com.mysql.jdbc.Driver();
			// OR
			// System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");

			// OR java.sql.DriverManager
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chem_e_car_survey?useSSL=false",
				"root", "960122"); Statement stmt = conn.createStatement();) {
			loadUsers(stmt);
			loadSurvey(stmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadUsers(Statement stmt) throws SQLException {
		String query = "Select * from User";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			long id = rs.getLong("id");
			String email = rs.getString("email");
			String name = rs.getString("name");
			String years = rs.getString("years");
			String major = rs.getString("major");

			User user = UserManager.getInstance().createUser(id, name,years, email, major);
			users.add(user);
		}
	}

	private static void loadSurvey(Statement stmt) throws SQLException {
		String query = "Select * from Survey";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String recommendation = rs.getString("recommendation");
			String team = rs.getString("team");
			String[] expect = rs.getString("expect").split(",");
			String comment = rs.getString("comment");

			Survey survey = SurveyManager.getInstance().createSurvey(recommendation, team, expect, comment);
			surveys.add(survey);
		}
	}

	public static void add(UserSurvey userSurvey) {
		userSurveys.add(userSurvey);
	}

}
