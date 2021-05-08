package GoogleValidateService;

import Entities.concrets.User;

public class Google {
	public void signUp(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " Adlý Kullanýcý Google Ýle Kayýt Oldu.");
	}
	
	public void signIn(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " Adlý Kullanýcý Google Ýle Giriþ Yaptý.");
	}
}
