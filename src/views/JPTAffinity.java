package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.User;
import utils.Utils;

public class JPTAffinity extends JPanel {

	/**
	 * Panel que contiene la tabla de los usuarios
	 */
	private static final long serialVersionUID = 1L;	
	private JScrollPane jScrollPane;
	private JTable table;
	private DefaultTableModel dtm;
	private JLabel jlInfo;
	private JPImageMain jpImageMain;
	private JLabel jlAffinityPercent;
	private JProgressBar jProgressBar;

	public JPTAffinity() {
		init();
	}

	private void init(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		Utils.generateBasicGrid(this, gbc);
		
		jlInfo = new JLabel(ConstantsGUI.JL_TABLE_AFFINITY_WITH_USER);
		jlInfo.setFont(new Font("CASTELLAR", Font.BOLD, 35));
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 11;
		this.add(jlInfo, gbc);
		
		this.setBackground(Color.decode("#ABB2B9"));
		dtm = new DefaultTableModel();
		String [] columns = new String[]{ConstantsGUI.T_HEADER_NAME, ConstantsGUI.T_HEADER_AGE,
				ConstantsGUI.T_HEADER_CITY,	ConstantsGUI.T_HEADER_MY_GENDER, ConstantsGUI.T_HEADER_SPORT, 
				ConstantsGUI.T_HEADER_GENDER_AFFINITY, ConstantsGUI.T_HEADER_MUSIC_GENDER};
		dtm.setColumnIdentifiers(columns);
		Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC, 20);
		table = new JTable(dtm);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(Color.decode("#B4AFAD"));
		table.getTableHeader().setForeground(Color.decode("#263566"));
		table.getTableHeader().setFont(fontHeader);
		table.setBackground(Color.decode("#809BB8"));
		table.setBorder(null);
		table.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
		table.setRowHeight(25);
		table.setAlignmentX(Component.CENTER_ALIGNMENT);		
		jScrollPane = new JScrollPane(table);
		jScrollPane.setForeground(Color.WHITE);
		jScrollPane.setBorder(null);
		jScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 12;
		this.add(jScrollPane, gbc);
		
		jlAffinityPercent = new JLabel(ConstantsGUI.JL_AFFINITY_PERCENT);
		jlAffinityPercent.setFont(new Font("CASTELLAR", Font.BOLD, 28));
		gbc.gridx = 7;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jlAffinityPercent, gbc);
		
		jProgressBar = new JProgressBar(0, 100);
		jProgressBar.setValue(0);
		jProgressBar.setStringPainted(true);
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridheight = 2;
		gbc.gridwidth = 6;
		this.add(jProgressBar, gbc);
		
		jpImageMain = new JPImageMain(ConstantsGUI.URL_IMG_AFFINITY_MAX);
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.ipady = 300;
		gbc.ipadx = 400;
		gbc.gridheight = 6;
		gbc.gridwidth = 6;
		this.add(jpImageMain, gbc);

//		this.setBorder(null);
	}
	
	public void changeImage(String urlImage) {
		jpImageMain.changeImage(urlImage);
	}
	
	public void cleanImage() {
		jpImageMain.cleanImage();
	}
	
	public void setValueProgressBar(int value) {
		jProgressBar.setValue(value);
	}
	
	public void addInfoToTable(ArrayList<User> users) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			short age = Utils.calculateAge(user.getBornDate());
			Object[] aux = new Object[]{user.getName(), age, user.getCity(), user.getMyGender(), user.getSport(), 
					user.getGenderAffinity(), user.getMusicGender()};
			dtm.addRow(aux);				
		}
	}

	public void cleanDtm(){
		dtm = (DefaultTableModel)table.getModel();
		for (int i = 0; i < dtm.getRowCount(); i++) {
			dtm.removeRow(i);
			i-=1;
		}
	}

	public void refreshStatus() {
		dtm.fireTableDataChanged();
	}
}
