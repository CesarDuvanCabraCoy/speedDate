package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import controllers.JBActions;
import controllers.MainController;

public class JTBMain extends JToolBar{

	private static final long serialVersionUID = 1L;
	private JButton jbAddUser;
	private JButton jbCompare;
	private JButton jbAbout;
	private MainController mainController;
	
	public JTBMain(MainController mainController) {
		this.mainController = mainController;
		this.setBackground(Color.decode("#E4E6EA"));
		this.setFloatable(false);
		this.setRollover(true);
		init();
	}
	
	private void init() {
		addButton(jbAddUser, ConstantsGUI.URL_JB_ADD_USER, JBActions.SHOW_DIALOG_ADD_USER, ConstantsGUI.TT_JB_ADD_USER);
		addButton(jbCompare, ConstantsGUI.URL_JB_COMPARE, JBActions.COMPARE, ConstantsGUI.TT_JB_COMPARE);
		this.addSeparator();
		addButton(jbAbout, ConstantsGUI.URL_JB_ABOUT, JBActions.ABOUT, ConstantsGUI.TT_JB_ABOUT);
	}
	
	private void addButton(JButton jb, String urlImage, JBActions command, String toolTip) {
		jb = new JButton(new ImageIcon(getClass().getResource(urlImage)));
		jb.addActionListener(mainController);
		jb.setActionCommand(command.toString());
		jb.setToolTipText(toolTip);
		this.add(jb);
	}
}
