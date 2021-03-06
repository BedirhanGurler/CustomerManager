package DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DataAccess.abstracts.UserDao;
import Entities.concrets.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();
	Scanner s = new Scanner(System.in);

	@Override
	public void addUser(User user) {
		System.out.println(user.getFirstName() + " Adl? Kullan?c? Hibernate ?le Eklendi.");
		
	}

	@Override
	public void updateUser(User user) {
		System.out.print("Yeni ?sim: ");
		String yeniIsim = s.nextLine();
		
		System.out.print("Yeni Soyisim: ");
		String yeniSoyisim = s.nextLine();
		
		System.out.println(user.getFirstName() + " " + user.getLastName() + " Adl? Kullan?c? " + yeniIsim 
							+ " " + yeniSoyisim + " Olarak G?ncellendi.");
		
	}

	@Override
	public void deleteUser(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " Adl? Kullan?c? " + " Silindi.");
		
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public void login(User user) {
		System.out.println("Kullan?c? Hibernate ?le Giri? Yapt?.");
		
	}

}
