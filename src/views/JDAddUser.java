package views;

import java.awt.BorderLayout;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import controllers.MainController;
import models.City;
import models.Gender;
import models.MusicGender;
import models.Sport;

public class JDAddUser extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPAddUser jpAddUser;
	private MainController mainController;
	
	public JDAddUser(MainController mainController) {
		this.mainController = mainController;
		this.setTitle(ConstantsGUI.TITLE_JF_MAIN);
		this.setSize(ConstantsGUI.JD_ADD_USER_WIDTH, ConstantsGUI.JD_ADD_USER_HEIGHT);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_IMAGE_ICON)).getImage());
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setModal(true);
		init();
	}
	
	private void init() {
		jpAddUser = new JPAddUser(mainController);
		this.add(jpAddUser, BorderLayout.CENTER);
	}
	
	public void cleanFields() {
		jpAddUser.cleanFields();
	}
	
	public String getName() {
		return jpAddUser.getName();
	}
	
	public GregorianCalendar getBornDate() {
		return jpAddUser.getBornDate();
	}
	
	public City getCity() {
		return jpAddUser.getCity();
	}
	
	public Gender getMyGender() {
		return jpAddUser.getMyGender();
	}
	
	public Gender getGenderAffinity() {
		return jpAddUser.getGenderAffinity();
	}
	
	public Sport getSport() {
		return jpAddUser.getSport();
	}
	
	public MusicGender getMusicGender() {
		return jpAddUser.getMusicGender();
	}
}