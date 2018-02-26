package views;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import models.User;

public class JDAffinity extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPTAffinity jptAffinity;
	
	public JDAffinity() {
		this.setTitle(ConstantsGUI.TITLE_JD_AFFINITY);
		this.setSize(ConstantsGUI.JD_AFFINITY_WIDTH, ConstantsGUI.JD_AFFINITY_HEIGHT);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_IMAGE_ICON)).getImage());
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setModal(true);
		init();
	}
	
	private void init() {
		jptAffinity = new JPTAffinity();
		this.add(jptAffinity, BorderLayout.CENTER);
	}
	
	public void addInfoToTable(ArrayList<User> users) {
		jptAffinity.addInfoToTable(users);
	}
	
	public void setValueJPBar(int value) {
		jptAffinity.setValueProgressBar(value);
	}
	
	public void changeImage(String urlImage) {
		jptAffinity.changeImage(urlImage);
	}
	
	public void cleanImage() {
		jptAffinity.cleanImage();
	}
	
	public void cleanDtm() {
		jptAffinity.cleanDtm();
	}
}