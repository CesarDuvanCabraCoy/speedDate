package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import controllers.JBActions;
import controllers.MainController;
import models.City;
import models.Gender;
import models.MusicGender;
import models.Sport;
import utils.Utils;

public class JPAddUser extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jlInfo;
	private JLabel jlName;
	private JTextField jtfName; 
	private JLabel jlDateBorn;
	private JCalendar jcDateBorn;
	private JLabel jlCity;
	private JComboBox<City> jcbCity;
	private JLabel jlMyGender;
	private JComboBox<Gender> jcbMyGender;
	private JLabel jlGenderAffinity;
	private JComboBox<Gender> jcbGenderAffinity;
	private JLabel jlSport;
	private JComboBox<Sport> jcbSport;
	private JLabel jlMusicGender;
	private JComboBox<MusicGender> jcbMusicGender;
	private JButton jbAcceptAdd;
	private JButton jbCancelAdd;
	private MainController mainController;

	public JPAddUser(MainController mainController) {
		this.mainController = mainController;
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		init();
	}
	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		Utils.generateBasicGrid(this, gbc);
		
		jlInfo = new JLabel(ConstantsGUI.JL_INFO);
		jlInfo.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 25));
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 7;
		this.add(jlInfo, gbc);
		
		jlName = new JLabel(ConstantsGUI.JL_NAME);
		jlName.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlName, gbc);
		
		jtfName = new JTextField();
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		this.add(jtfName, gbc);
		
		jlDateBorn = new JLabel(ConstantsGUI.JL_DATE_BORN);
		jlDateBorn.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlDateBorn, gbc);
		
		jcDateBorn = new JCalendar();
		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.gridheight = 3;
		gbc.gridwidth = 6;
		this.add(jcDateBorn, gbc);
		
		jlCity = new JLabel(ConstantsGUI.JL_CITY);
		jlCity.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlCity, gbc);
		
		jcbCity = new JComboBox<>(City.values());
		gbc.gridx = 5;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		this.add(jcbCity, gbc);
		
		jlMyGender = new JLabel(ConstantsGUI.JL_MY_GENDER);
		jlMyGender.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlMyGender, gbc);
		
		jcbMyGender = new JComboBox<>(Gender.values());
		gbc.gridx = 5;
		gbc.gridy = 7;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		this.add(jcbMyGender, gbc);
		
		jlGenderAffinity = new JLabel(ConstantsGUI.JL_GENDER_AFFINITY);
		jlGenderAffinity.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlGenderAffinity, gbc);
		
		jcbGenderAffinity = new JComboBox<>(Gender.values());
		gbc.gridx = 5;
		gbc.gridy = 8;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		this.add(jcbGenderAffinity, gbc);
		
		jlSport = new JLabel(ConstantsGUI.JL_SPORT);
		jlSport.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlSport, gbc);
		
		jcbSport = new JComboBox<>(Sport.values());
		gbc.gridx = 5;
		gbc.gridy = 9;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		this.add(jcbSport, gbc);
		
		jlMusicGender = new JLabel(ConstantsGUI.JL_MUSIC_GENDER);
		jlMusicGender.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		this.add(jlMusicGender, gbc);
		
		jcbMusicGender = new JComboBox<>(MusicGender.values());
		gbc.gridx = 5;
		gbc.gridy = 10;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		this.add(jcbMusicGender, gbc);
		
		jbCancelAdd = new JButton(new ImageIcon(getClass().getResource(ConstantsGUI.URL_CANCEL)));
		jbCancelAdd.setActionCommand(JBActions.CANCEL_ADD.toString());
		jbCancelAdd.addActionListener(mainController);
		jbCancelAdd.setBackground(Color.decode("#C0C0C0"));
		gbc.gridx = 2;
		gbc.gridy = 11;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jbCancelAdd, gbc);
	
		jbAcceptAdd = new JButton(new ImageIcon(getClass().getResource(ConstantsGUI.URL_ACCEPT)));
		jbAcceptAdd.setActionCommand(JBActions.ACCEPT_ADD.toString());
		jbAcceptAdd.addActionListener(mainController);
		jbAcceptAdd.setBackground(Color.decode("#C0C0C0"));
		gbc.gridx = 7;
		gbc.gridy = 11;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jbAcceptAdd, gbc);
	}
	
	public void cleanFields() {
		jtfName.setText("");
		jcbCity.setSelectedItem(City.values()[0]);
		jcbMyGender.setSelectedItem(Gender.values()[0]);
		jcbGenderAffinity.setSelectedItem(Gender.values()[0]);
		jcbMusicGender.setSelectedItem(MusicGender.values()[0]);
		jcbSport.setSelectedItem(Sport.values()[0]);
	}
	
	public String getName() {
		return jtfName.getText();
	}
	
	public GregorianCalendar getBornDate() {
		return new GregorianCalendar(jcDateBorn.getYearChooser().getYear(), jcDateBorn.getMonthChooser().getMonth(), jcDateBorn.getDayChooser().getDay());
	}
	
	public City getCity() {
		return City.valueOf(jcbCity.getSelectedItem().toString());
	}
	
	public Gender getMyGender() {
		return Gender.valueOf(jcbMyGender.getSelectedItem().toString());
	}
	
	public Gender getGenderAffinity() {
		return Gender.valueOf(jcbGenderAffinity.getSelectedItem().toString());
	}
	
	public Sport getSport() {
		return Sport.valueOf(jcbSport.getSelectedItem().toString());
	}
	
	public MusicGender getMusicGender() {
		return MusicGender.valueOf(jcbMusicGender.getSelectedItem().toString());
	}
}