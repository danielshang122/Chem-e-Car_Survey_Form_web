package survey_form;

import java.util.List;
import entities.Survey;
import entities.User;
import managers.SurveyManager;
import managers.UserManager;

public class Launch {
	private static List<User> users;
	private static List<Survey> surveys;
	
	private static void LoadData() {
		System.out.println("1. Loading data ...");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		surveys = SurveyManager.getInstance().getSurveys();
		
		System.out.println("Printing data...");
		PrintUserData();
		PrintSurveyData();
	}
	private static void PrintUserData() {
		for(User user: users) {
			System.out.println("Name: "+user.getName());
		}
		
	}
	private static void PrintSurveyData() {
		for(Survey survey: surveys) {
			System.out.println("team: "+survey.getTeam());
		}
	}
	
	public static void main(String[] args) {
		LoadData();
	}
}
