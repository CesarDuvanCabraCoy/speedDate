package utils;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

import org.w3c.dom.Element;

import models.City;
import models.Gender;
import models.MusicGender;
import models.Sport;
import models.User;
import views.ConstantsGUI;

public class Utils {

	public static void generateBasicGrid(Container comp, GridBagConstraints gbc){
		gbc.weightx = 1;
		for (int i = 0; i < ConstantsGUI.COLUMNS_NUMBER; i++) {
			gbc.gridx = i;
			comp.add(new JLabel(""), gbc);
		}
	}
	
	public  static short calculateAge(Calendar birthDay){
		Calendar currentDate = new 	GregorianCalendar();
		int y2 = currentDate.get(GregorianCalendar.YEAR);
		int m2 = currentDate.get(Calendar.MONTH + 1);
		int d2 = currentDate.get(Calendar.DAY_OF_MONTH);
		
		int year = y2-birthDay.get(Calendar.YEAR);
		int month = m2-birthDay.get(Calendar.MONTH);
		int day = d2-birthDay.get(Calendar.DAY_OF_YEAR);
		
		if((month<0) || (month == 0 && day < 0)){
			year--;
		}
		return (short) year;
	}
	
	public static short getAffinityByAge(GregorianCalendar bornDateCurrentUser, GregorianCalendar bornDateMaybeMatch) {
		short ageCurrentUser = calculateAge(bornDateCurrentUser);
		short ageMaybeMatch = calculateAge(bornDateMaybeMatch);
		short affinity = 0;
		int ageDifference = ageCurrentUser - ageMaybeMatch; 
		if (ageDifference > -4 && ageDifference < 4) {
			affinity = 15;
		}else if ((ageDifference > -8 && ageDifference < -3) && (ageDifference < 8 && ageDifference > 3) ) {
			affinity = 10;
		}
		return affinity;
	}
	
	public static short getAffinityByCity(City cityCurrentUser, City cityMaybeMatch) {
		short affinity = 0;
		if (cityCurrentUser.equals(cityMaybeMatch)) {
			affinity = 20;
		}
		return affinity;
	}
	
	public static short getAffinityByGender(Gender genderAffinityCurrentUSer, Gender genderMaybeMatch) {
		short affinity = 0;
		if (genderAffinityCurrentUSer.equals(genderMaybeMatch)) {
			affinity = 25;
		}
		return affinity;
	}
	
	public static short getAffinityBySport(Sport sportCurrentUser, Sport sportMaybeMatch) {
		short affinity = 0;
		if (sportCurrentUser.equals(sportMaybeMatch)) {
			affinity = 20;
		}
		return affinity;
	}
	
	public static short getAffinityByMusicGender(MusicGender musicCurrentUser, MusicGender musicMaybeMatch) {
		short affinity = 0;
		if (musicCurrentUser.equals(musicMaybeMatch)) {
			affinity = 20;
		}
		return affinity;
	}
	
	public static Calendar getBornDate(String date){
		String[] auxDate = date.split("/");
		return new GregorianCalendar(Integer.parseInt(auxDate[2]), Integer.parseInt(auxDate[1]), Integer.parseInt(auxDate[0]));
	}
	
	public static User getUser(Element element) {
		int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
		String name = element.getElementsByTagName("name").item(0).getTextContent();
		GregorianCalendar bornDate = (GregorianCalendar) getBornDate(element.getElementsByTagName("bornDate").item(0).getTextContent());
		City city = City.valueOf(element.getElementsByTagName("city").item(0).getTextContent());
		Gender myGender = Gender.valueOf(element.getElementsByTagName("myGender").item(0).getTextContent());
		Gender genderAffinity = Gender.valueOf(element.getElementsByTagName("genderAffinity").item(0).getTextContent());
		Sport sport = Sport.valueOf(element.getElementsByTagName("sport").item(0).getTextContent());
		MusicGender musicGender = MusicGender.valueOf(element.getElementsByTagName("musicGender").item(0).getTextContent());
		return new User(id, name, bornDate, city, myGender, genderAffinity, sport, musicGender);
	}
}