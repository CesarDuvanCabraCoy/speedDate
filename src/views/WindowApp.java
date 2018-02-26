package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.MainController;
import exceptions.ExcAreSelectedCbx;
import exceptions.ExcUserNotFound;
import models.ManagerAffinity;
import models.User;

public class WindowApp extends JFrame{

	private static final long serialVersionUID = 1L;
	private JMBMain jmbMain;
	private MainController mainController;
	private JPTableMain jpTableMain;
	private JTBMain jtbMain;
	
	public WindowApp(MainController mainController) {
		this.mainController = mainController;
		this.setTitle(ConstantsGUI.TITLE_JF_MAIN);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_IMAGE_ICON)).getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		init();
		this.setVisible(true);
	}
	
	private void init() {
		jmbMain = new JMBMain(mainController);
		this.setJMenuBar(jmbMain);
		jpTableMain = new JPTableMain();
		this.add(jpTableMain, BorderLayout.CENTER);
		
		jtbMain = new JTBMain(mainController);
		this.add(jtbMain, BorderLayout.NORTH);
	}
	
	public void addInfoToTable(ArrayList<User> users) {
		jpTableMain.addInfoToTable(users);
	}
	
	public ArrayList<User> getUsersSelected(ManagerAffinity managerAffinity) throws NumberFormatException, ExcAreSelectedCbx, ExcUserNotFound{
		return jpTableMain.getUsersSelecteds(managerAffinity);
	}
	
	public void cleanDtm() {
		jpTableMain.cleanDtm();
	}
}
