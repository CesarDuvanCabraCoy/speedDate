package views;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import views.ConstantsGUI;

public class JDAbout extends JDialog {
	
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 550;
	public static final int WIDTH = 400;
	private JLabel lblInfo;
	
	public JDAbout() {
		this.setTitle(ConstantsGUI.TITLE_JD_ABOUT);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_IMAGE_ICON)).getImage());
		this.setSize(WIDTH, HEIGHT);
		this.setModal(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		init();
	}
	
	private void init(){
		lblInfo = new JLabel(ConstantsGUI.T_LBL_INFO);
		lblInfo.setFont(new java.awt.Font("Century Gothic", 0, 22));
		lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblInfo.setBounds(20, 0, 300, 550);
		this.add(lblInfo);
	}
}
