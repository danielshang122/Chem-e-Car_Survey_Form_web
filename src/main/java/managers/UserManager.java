package managers;

import java.util.List;

import dao.UserDao;
import entities.User;

public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao= new UserDao();
	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}
	
	public User createUser(long id,String Name,String years,String email,String major) {
		User user = new User();
		user.setId(id);
		user.setName(Name);
		user.setYears(years);
		user.setEmail(email);
		user.setMajor(major);
		
		return user;
	}
	
	public List<User> getUsers(){
		return dao.getUsers();
	}
}
