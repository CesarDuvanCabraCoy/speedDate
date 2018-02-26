package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import exceptions.ExcAreSelectedCbx;
import exceptions.ExcUserNotFound;
import models.ManagerAffinity;
import models.User;
import utils.Utils;

public class JPTableMain extends JPanel{

	/**
	 * Panel que contiene la tabla de los usuarios
	 */
	private static final long serialVersionUID = 1L;	
	private JScrollPane jScrollPane;
	private JTable table;
	private DefaultTableModel dtm;
	private JLabel jlInfo;
	private ArrayList<JCheckBox> checkBoxs;

	public JPTableMain() {
		checkBoxs = new ArrayList<JCheckBox>();
		init();
	}

	private void init(){
		jlInfo = new JLabel(ConstantsGUI.JL_USERS_AFFINITY);
		jlInfo.setFont(new Font("CASTELLAR", Font.BOLD, 35));
		jlInfo.setAlignmentX(CENTER_ALIGNMENT);
		this.add(jlInfo, BorderLayout.NORTH);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#ABB2B9"));
		dtm = new DefaultTableModel();
		String [] columns = new String[]{ConstantsGUI.T_HEADER_ID, ConstantsGUI.T_HEADER_NAME, ConstantsGUI.T_HEADER_AGE,
				ConstantsGUI.T_HEADER_CITY,	ConstantsGUI.T_HEADER_MY_GENDER, ConstantsGUI.T_HEADER_SPORT, 
				ConstantsGUI.T_HEADER_GENDER_AFFINITY, ConstantsGUI.T_HEADER_MUSIC_GENDER, ConstantsGUI.T_HEADER_COMPARE};
		dtm.setColumnIdentifiers(columns);
		Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC, 20);
		table = new JTable(dtm);
		for (int i = 8; i < columns.length; i++) {
			table.getColumn(columns[i]).setCellRenderer(new TableCellRenderer() {
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
						int row, int column) {
					return (JCheckBox) value;
				}
			});
			table.getColumn(columns[i]).setCellEditor(new TableCellEditor() {

				@Override
				public boolean stopCellEditing() {
					return true;
				}
				@Override
				public boolean shouldSelectCell(EventObject anEvent) {
					return true;
				}
				@Override
				public void removeCellEditorListener(CellEditorListener l) {}

				@Override
				public boolean isCellEditable(EventObject anEvent) {
					return true;
				}

				@Override
				public Object getCellEditorValue() {
					return null;
				}

				@Override
				public void cancelCellEditing() {}

				@Override
				public void addCellEditorListener(CellEditorListener l) {

				}

				@Override
				public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
					return (JCheckBox)value;
				}
			});
		}
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
		add(jScrollPane, BorderLayout.PAGE_END);
		this.setBorder(null);
	}

	public JCheckBox createCheckBox(String id){
		JCheckBox cbx = new JCheckBox();
		cbx.setName(id);
		cbx.setBackground(Color.decode("#5fba7d"));
		cbx.setForeground(Color.WHITE);
		checkBoxs.add(cbx);
		return cbx;
	}


	public void addInfoToTable(ArrayList<User> users) {
		for (User user : users) {
			JCheckBox jbtn = createCheckBox(String.valueOf(user.getId()));
			short age = Utils.calculateAge(user.getBornDate());
			Object[] aux = new Object[]{user.getId(), user.getName(), age, user.getCity(), user.getMyGender(), user.getSport(), 
					user.getGenderAffinity(), user.getMusicGender(), jbtn};
			dtm.addRow(aux);
		}
	}

	private int countSelectedOnlyTwo() {
		int quantityCbxSelected = 0;
		for (JCheckBox cbx : checkBoxs) {
			if (cbx.isSelected()) {
				quantityCbxSelected++;
			}
		}
		return quantityCbxSelected;
	}
	
	public ArrayList<User> getUsersSelecteds(ManagerAffinity managerAffinity) throws ExcAreSelectedCbx, NumberFormatException, ExcUserNotFound{
		ArrayList<User> users = new ArrayList<User>();
		for (JCheckBox cbx : checkBoxs) {
			if (countSelectedOnlyTwo() == 2) {
				if (cbx.isSelected()) {
					users.add(managerAffinity.searchUser(Integer.parseInt(cbx.getName())));
				}
			}else {
				throw new ExcAreSelectedCbx();
			}
		}
		return users;
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
