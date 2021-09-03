package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import entities.Survey;
import entities.User;
import entities.UserSurvey;
import survey_form.DataStore;

public class SurveyDao {
	public List<Survey> getSurveys() {
		return DataStore.getSurveys();
	}

	public void saveSurvey(UserSurvey userSurvey) throws SQLException {
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
			saveUserSurvey(userSurvey, stmt);
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

	private void saveUserSurvey(UserSurvey userSurvey, Statement stmt) throws SQLException {
		List<String> expectlist = Arrays.asList(userSurvey.getSurvey().getExpect());
		String expect = expectlist.stream().collect(Collectors.joining(","));
		
		String query1 = "insert into user (id,name,email,years,major) "
				        + "values ("+userSurvey.getUser().getId()+","
						+ "\'" +userSurvey.getUser().getName()+"\',"
						+ "\'" +userSurvey.getUser().getEmail()+"\',"
						+ "\'" +userSurvey.getUser().getYears()+"\',"
						+  "\'" +userSurvey.getUser().getMajor()+"\')";
		String query2 = "insert into survey (id, recommendation, team, expect, comment)" + 
						"values(" +userSurvey.getUser().getId()+","
								+ "\'" +userSurvey.getSurvey().getRecommendation()+"\',"
								+ "\'" +userSurvey.getSurvey().getTeam()+"\',"
								+ "\'" +expect+"\',"
								+ "\'" +userSurvey.getSurvey().getComment()+"\')";
		String query3 = "Insert into user_survey (user_id,survey_id) values (" + userSurvey.getUser().getId() + ","
				+ userSurvey.getUser().getId() + ")";
		stmt.executeUpdate(query1);
		stmt.executeUpdate(query2);
		stmt.executeUpdate(query3);
	}

	public void saveUser(User user) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false",
				"root", "960122"); Statement stmt = conn.createStatement();) {
			String query1 = "insert into user (id,name,email,years,major) "
			        + "values ("+user.getId()+","
					+ "\'" +user.getName()+"\',"
					+ "\'" +user.getEmail()+"\',"
					+ "\'" +user.getYears()+"\',"
					+  "\'" +user.getMajor()+"\')";
			stmt.executeUpdate(query1);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
