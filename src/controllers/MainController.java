package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.xml.sax.SAXException;
import exceptions.ExcAreSelectedCbx;
import exceptions.ExcUserNotFound;
import models.ManagerAffinity;
import perssistence.ManagerXml;
import views.ConstantsGUI;
import views.JDAbout;
import views.JDAddUser;
import views.JDAffinity;
import views.WindowApp;

public class MainController implements ActionListener{

	private WindowApp windowApp;
	private ManagerAffinity managerAffinity;
	private JDAddUser jdAddUser;
	private JDAffinity jdAffinity;
	private ManagerXml managerXml;
	private JDAbout jdAbout;
	
	public MainController() {
		LoadInfo();
		jdAddUser = new JDAddUser(this);
		jdAffinity = new JDAffinity();
		jdAbout = new JDAbout();
	}

	private void LoadInfo() {
		managerXml = new ManagerXml();
		managerAffinity = new ManagerAffinity();
		windowApp = new WindowApp(this);
		try {
			managerAffinity.loadUsers(managerXml.parserDocumentToGetUsers());
			windowApp.cleanDtm();
			windowApp.addInfoToTable(managerAffinity.getUsers());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (JBActions.valueOf(event.getActionCommand())) {
		case SHOW_DIALOG_ADD_USER:
			jdAddUser.setVisible(true);
			break;
		case CANCEL_ADD:
			cancelAdd();
			break;
		case ACCEPT_ADD:
			acceptAdd();
			break;
		case COMPARE:
			compare();
			break;
		case ABOUT:
			jdAbout.setVisible(true);
			break;
		default:
			break;
		}
	}
	
	private void compare() {
		jdAffinity.cleanDtm();
		try {
			jdAffinity.addInfoToTable(windowApp.getUsersSelected(managerAffinity));
			int affinityLevel =managerAffinity.calculateAffinity(windowApp.getUsersSelected(managerAffinity).get(0),
					windowApp.getUsersSelected(managerAffinity).get(1)); 
			paintImage(affinityLevel);
			jdAffinity.setValueJPBar(affinityLevel);
			jdAffinity.setVisible(true);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ExcAreSelectedCbx e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),  ConstantsGUI.WRONG, JOptionPane.ERROR_MESSAGE);
		} catch (ExcUserNotFound e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),  ConstantsGUI.WRONG, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void paintImage(int affinityLevel) {
		if (affinityLevel > 70) {
			jdAffinity.changeImage(ConstantsGUI.URL_IMG_AFFINITY_MAX);
		}else if (affinityLevel > 40 && affinityLevel < 70) {
			jdAffinity.changeImage(ConstantsGUI.URL_IMG_AFFINITY_MEDIUM);
		}else {
			jdAffinity.changeImage(ConstantsGUI.URL_IMG_NOT_AFFINITY);
		}
	}
	
	private void acceptAdd() {
		managerAffinity.addUser(managerAffinity.getUsers().size(), jdAddUser.getName(), jdAddUser.getBornDate(), jdAddUser.getCity(), 
				jdAddUser.getMyGender(), jdAddUser.getGenderAffinity(), jdAddUser.getSport(), jdAddUser.getMusicGender());
		try {
			managerXml.writeAllUsers(managerAffinity.getUsers());
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, ConstantsGUI.JOP_USER_CREATED, ConstantsGUI.JOP_SUCCESFULL, 
				JOptionPane.INFORMATION_MESSAGE);
		cancelAdd();
		windowApp.cleanDtm();
		windowApp.addInfoToTable(managerAffinity.getUsers());
		
	}

	private void cancelAdd() {
		jdAddUser.cleanFields();
		jdAddUser.setVisible(false);
	}
}
