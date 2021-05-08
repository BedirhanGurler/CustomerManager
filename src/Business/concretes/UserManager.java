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
		System.out.println("1- Google �le Direk Kay�t \n 2- Normal Kay�t");
		int select1 = s.nextInt();
		if(select1 == 1) {
			validateService.signUp(user);
		}
		else if(select1 == 2) {
			if(user.getPassword().length() < 6) {
				System.out.println("Parola En Az 6 Karakter Olmal�d�r.");
				return;
			}
			if(!matcher.matches()) {
				System.out.println("L�tfen Email Kurallar�na Uygun Bir Email Yaz�n�z.");
				return;
			}
			if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
				System.out.println("�sim Ve Osyisim Alanlar� En Az 2 Karakter Olmal�d�r.");
				return;
			}
			System.out.println("Hesap Do�rulamas� ��in Size Bir Mail G�nderdik. Do�rulama ��in E Tu�una Bas�n�z.");
			String select2 = s.nextLine();
			if(select2.equals("E")) {
				System.out.println("Do�rulama Ba�ar�s�z!!!");
				return;
			}
			userDao.addUser(user);
		}
		
		
		
	}

	@Override
	public void signIn(User user) {
		if(user.getEmail() == null || user.getPassword() == null) {
			System.out.println("Email ve �ifre Alan� Doldurulmal�d�r.");
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
