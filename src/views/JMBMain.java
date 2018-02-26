package views;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controllers.JBActions;
import controllers.MainController;

public class JMBMain extends JMenuBar{

	private static final long serialVersionUID = 1L;
	private JMenu jmFile;
	private JMenu jmHelp;
	private JMenuItem jmiAddUser;
	private JMenuItem jmiAbout;
	private MainController mainController;
	
	public JMBMain(MainController mainController) {
		this.mainController = mainController;
		jmFile = new JMenu(ConstantsGUI.JM_FILE);
		addItem(jmiAddUser, ConstantsGUI.JMI_ADD_USER, JBActions.SHOW_DIALOG_ADD_USER.toString(), KeyEvent.VK_A, jmFile);
		this.add(jmFile);
		
		jmHelp = new JMenu(ConstantsGUI.JM_HELP);
		addItem(jmiAbout, ConstantsGUI.JMI_ABOUT, JBActions.ABOUT.toString(), KeyEvent.VK_H, jmHelp);
		this.add(jmHelp);
	}
	
	private void addItem(JMenuItem jmi, String name, String actionCommand, int keyEvent, JMenu jMenu) {
		jmi = new JMenuItem(name);
		jmi.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.PLAIN, 19));
		jmi.setActionCommand(actionCommand);
		jmi.setAccelerator(KeyStroke.getKeyStroke(keyEvent, InputEvent.CTRL_MASK));
		jmi.addActionListener(mainController);
		jMenu.add(jmi);
	}
	
	
}
