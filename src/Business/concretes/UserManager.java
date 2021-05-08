package Business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Business.abstracts.UserService;
import Core.abstracts.ValidateService;
import DataAccess.abstracts.UserDao;
import Entities.concrets.User;

public class UserManager implements UserService{
	
	List<User> users = new ArrayList<User>();
	
	Scanner s = new Scanner(System.in);
	private Pattern pattern;
    private Matcher matcher;
    
    private UserDao userDao;
    public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	private ValidateService validateService;

    public UserManager(ValidateService validateService) {
		super();
		this.validateService = validateService;
	}

	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public void EmailValidator()
    {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    public boolean validate(final String email)
    {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

	@Override
	public void signUp(User user) {
		System.out.println("1- Google Ýle Direk Kayýt \n 2- Normal Kayýt");
		int select1 = s.nextInt();
		if(select1 == 1) {
			validateService.signUp(user);
		}
		else if(select1 == 2) {
			if(user.getPassword().length() < 6) {
				System.out.println("Parola En Az 6 Karakter Olmalýdýr.");
				return;
			}
			if(!matcher.matches()) {
				System.out.println("Lütfen Email Kurallarýna Uygun Bir Email Yazýnýz.");
				return;
			}
			if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
				System.out.println("Ýsim Ve Osyisim Alanlarý En Az 2 Karakter Olmalýdýr.");
				return;
			}
			System.out.println("Hesap Doðrulamasý Ýçin Size Bir Mail Gönderdik. Doðrulama Ýçin E Tuþuna Basýnýz.");
			String select2 = s.nextLine();
			if(select2.equals("E")) {
				System.out.println("Doðrulama Baþarýsýz!!!");
				return;
			}
			userDao.addUser(user);
		}
		
		
		
	}

	@Override
	public void signIn(User user) {
		if(user.getEmail() == null || user.getPassword() == null) {
			System.out.println("Email ve Þifre Alaný Doldurulmalýdýr.");
			return;
		}
		if(validateService != null) {
			validateService.signIn(user);
		}
		if(userDao != null) {
			userDao.login(user);
		}
		
	}

	@Override
	public List<User> gerAll() {
		return users;
	}
	
	
	

	

}
