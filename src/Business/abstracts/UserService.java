package Business.abstracts;

import java.util.List;

import Entities.concrets.User;

public interface UserService {
	void signUp(User user);
	void signIn(User user);
	List<User> gerAll();
}
