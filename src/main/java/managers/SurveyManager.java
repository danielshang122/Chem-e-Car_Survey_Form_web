package managers;

import java.sql.SQLException;
import java.util.List;

import dao.SurveyDao;
import entities.Survey;
import entities.User;
import entities.UserSurvey;

public class SurveyManager {
	private static SurveyManager instance = new SurveyManager();
	private static SurveyDao dao = new SurveyDao();

	private SurveyManager() {
	}

	public static SurveyManager getInstance() {
		return instance;
	}

	public Survey createSurvey(String recommendation, String team, String[] expect, String comment) {
		Survey survey = new Survey();
		survey.setRecommendation(recommendation);
		survey.setTeam(team);
		survey.setExpect(expect);
		survey.setComment(comment);

		return survey;
	}
	
	public void saveUserSurvey(User user, Survey survey) throws SQLException {
		UserSurvey userServey = new UserSurvey();
		userServey.setUser(user);
		userServey.setSurvey(survey);
		
		dao.saveSurvey(userServey);
	}

	public List<Survey> getSurveys() {
		return dao.getSurveys();
	}

	public void saveUser(User user) throws SQLException {
		dao.saveUser(user);
	}
}
