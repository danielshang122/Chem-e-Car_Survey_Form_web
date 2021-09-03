package survey_form;

import controllers.SurveyController;
import entities.Survey;
import entities.User;

public class View {
	public static void startSurvey(User user, Survey survey) {
		System.out.println("\n" + user.getName() + " starts survey ...");
		
		SurveyController.getInstance().saveUserSurvey(user,survey);
		
		System.out.println("Survey is done");
	}
}
