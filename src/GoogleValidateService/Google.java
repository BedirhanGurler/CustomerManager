package GoogleValidateService;

import Entities.concrets.User;

public class Google {
	public void signUp(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " Adl� Kullan�c� Google �le Kay�t Oldu.");
	}
	
	public void signIn(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " Adl� Kullan�c� Google �le Giri� Yapt�.");
	}
}
