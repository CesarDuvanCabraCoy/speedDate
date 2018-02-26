package models;

import java.util.GregorianCalendar;

public class User {

	private int id;
	private String name;
	private GregorianCalendar bornDate;
	private City city;//Variable a tener en cuenta para el promedio de afinidad
	private Gender myGender;
	private Gender genderAffinity;//Variable a tener en cuenta para el promedio de afinidad
	private Sport sport;//Variable a tener en cuenta para el promedio de afinidad
	private MusicGender musicGender;//Variable a tener en cuenta para el promedio de afinidad
	
	public User(int id, String name, GregorianCalendar bornDate, City city, Gender myGender, Gender genderAffinity,
			Sport sport, MusicGender musicGender) {
		this.id = id;
		this.name = name;
		this.bornDate = bornDate;
		this.city = city;
		this.myGender = myGender;
		this.genderAffinity = genderAffinity;
		this.sport = sport;
		this.musicGender = musicGender;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public GregorianCalendar getBornDate() {
		return bornDate;
	}

	public City getCity() {
		return city;
	}

	public Gender getMyGender() {
		return myGender;
	}

	public Gender getGenderAffinity() {
		return genderAffinity;
	}

	public Sport getSport() {
		return sport;
	}

	public MusicGender getMusicGender() {
		return musicGender;
	}

	@Override
	public String toString() {
		return "User -> id=" + id + ", name=" + name + ", bornDate=" + bornDate + ", city=" + city + ", myGender="
				+ myGender + ", genderAffinity=" + genderAffinity + ", sport=" + sport + ", musicGender=" + musicGender
				+ "-------   ";
	}
}