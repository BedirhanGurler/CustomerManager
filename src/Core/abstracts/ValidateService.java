package Core.abstracts;

import Entities.concrets.User;

public interface ValidateService {
	void signUp(User user);
	void signIn(User user);
}
