package DataAccess.abstracts;

import java.util.List;

import Entities.concrets.User;

public interface UserDao {
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	void login(User user);
	List<User> getAllUsers();
}
