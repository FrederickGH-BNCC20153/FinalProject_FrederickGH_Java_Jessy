package gui;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.MenuDAO;

public class FormView extends JPanel{

	private JTable table;
	private JScrollPane scroll;
	private MenuDAO dao;
	
	public FormView() {
		dao = new MenuDAO();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initTable();
	}
	
	private void initTable() {
		
		Vector<String> titleColumn = new Vector<String>();
		titleColumn.add("Kode");
		titleColumn.add("Nama");
		titleColumn.add("Harga");
		titleColumn.add("Stok");
		
		DefaultTableModel model = new DefaultTableModel(dao.getMenu(), titleColumn) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}

}
