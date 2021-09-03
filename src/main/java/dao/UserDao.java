package dao;

import java.util.List;

import entities.User;
import survey_form.DataStore;

public class UserDao {
	public List<User> getUsers() {
		return DataStore.getUsers();
	}
}
