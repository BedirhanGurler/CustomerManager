package Core.concretes;

import Core.abstracts.ValidateService;
import Entities.concrets.User;
import GoogleValidateService.Google;

public class GoogleValidateAdapter implements ValidateService{
	
	Google google = new Google();
	
	@Override
	public void signUp(User user) {
		google.signUp(user);
	}

	@Override
	public void signIn(User user) {
		google.signIn(user);
		
	}

}
