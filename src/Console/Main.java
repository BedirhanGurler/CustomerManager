package Console;

import Business.concretes.UserManager;
import Core.concretes.GoogleValidateAdapter;
import Entities.concrets.User;


public class Main {


	public static void main(String[] args) {
		UserManager userManager = new UserManager(new GoogleValidateAdapter());
		User user1 = new User(1, "B", "Gürler", "bgurler001@gmail.com", "1234567");
		userManager.signUp(user1);
	}

}
