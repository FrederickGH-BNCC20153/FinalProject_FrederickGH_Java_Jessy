package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.MenuDAO;

public class UpdateMenu extends JFrame implements ActionListener{

	private JPanel panel1,panel2;
	private JButton cancelBtn, okBtn;
	private Vector<String> titleColumn;
	private JTextField codeTarget;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private MenuDAO dao;
	private FormView panelView;
	
	public UpdateMenu() {
		this.setTitle("Update Menu");
		dao = new MenuDAO();
		panelView = new FormView();
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		panel1 = createPanelL();
		panel2 = createPanelT();
		
		codeTarget = new JTextField(8);
		panel1.add(new JLabel("Insert Kode to Update"));
		panel1.add(codeTarget);
		
		okBtn = new JButton("Confirm");
		cancelBtn = new JButton("Cancel");
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		panel2.add(okBtn);
		panel2.add(cancelBtn);
		
		this.add(panelView);
		this.add(panel1);
		this.add(panel2);
		
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initTable() {
		
		titleColumn = new Vector<String>();
		titleColumn.add("Kode");
		titleColumn.add("Nama");
		titleColumn.add("Harga");
		titleColumn.add("Stok");
		
		model = new DefaultTableModel(dao.getMenu(), titleColumn) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}
	
	private JPanel createPanelL() {
		return new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 10));
	}
	
	private JPanel createPanelT() {
		return new JPanel(new FlowLayout(FlowLayout.TRAILING, 20, 10));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {
			new Home();
			this.dispose();
		}
	}

}
