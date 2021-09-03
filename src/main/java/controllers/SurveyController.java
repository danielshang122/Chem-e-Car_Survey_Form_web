package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Survey;
import entities.User;
import managers.SurveyManager;
import managers.UserManager;

@WebServlet(urlPatterns = { "/survey", "/submit" })
public class SurveyController extends HttpServlet {
	/*
	 * private static SurveyController instance = new SurveyController();
	 * 
	 * private SurveyController() { }
	 * 
	 * public static SurveyController getInstance() { return instance; }
	 */
	public SurveyController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		System.out.println("Servlet path: " + request.getServletPath());
		if (request.getServletPath().contains("survey")) {
			dispatcher = request.getRequestDispatcher("/survey.jsp");
		}
		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String years = request.getParameter("years");
			String major = request.getParameter("major");

			String recommendation = request.getParameter("recommendation");
			String team = request.getParameter("team");
			String[] expect = request.getParameterValues("expect");
			String comment = request.getParameter("comment");

			User user = UserManager.getInstance().createUser(id, name, years, email, major);
			Survey survey = SurveyManager.getInstance().createSurvey(recommendation, team, expect, comment);
			try {
				saveUserSurvey(user, survey);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void saveUserSurvey(User user, Survey survey) throws SQLException {
		SurveyManager.getInstance().saveUserSurvey(user, survey);
	}

	public void saveUser(User user) throws SQLException {
		SurveyManager.getInstance().saveUser(user);
	}
}
