package models;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import exceptions.ExcUserNotFound;
import utils.Utils;

public class ManagerAffinity {

	private ArrayList<User> users;

	public ManagerAffinity() {
		users = new ArrayList<User>();
	}

	public void loadUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void addUser(int id, String name, GregorianCalendar bornDate, City city, Gender myGender, Gender genderAffinity, 
			Sport sport, MusicGender musicGender) {
		users.add(new User(id, name, bornDate, city, myGender, genderAffinity, sport, musicGender));
		System.out.println(users);
	}

	public int calculateAffinity(User currentUser, User maybeMatch) {
		return (Utils.getAffinityByAge(currentUser.getBornDate(), maybeMatch.getBornDate()) 
				+ Utils.getAffinityByCity(currentUser.getCity(), maybeMatch.getCity()) 
				+ Utils.getAffinityByGender(currentUser.getGenderAffinity(), maybeMatch.getMyGender())
				+ Utils.getAffinityByMusicGender(currentUser.getMusicGender(), maybeMatch.getMusicGender())
				+ Utils.getAffinityBySport(currentUser.getSport(), maybeMatch.getSport()));
	}

	public ArrayList<Integer> generateListAffinity(User currentUser){
		ArrayList<Integer> affinityList = new ArrayList<Integer>();
		for (User maybeMatch : users) {
			affinityList.add(calculateAffinity(currentUser, maybeMatch));				
		}
		return affinityList;
	}

	public User searchUser(int id) throws ExcUserNotFound {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}throw new ExcUserNotFound();
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}
