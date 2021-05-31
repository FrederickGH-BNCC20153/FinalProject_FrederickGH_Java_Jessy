package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.MenuDAO;

public class ViewMenu extends JFrame implements ActionListener, MouseListener{

	private JTable table;
	private JScrollPane scroll;
	private JButton addBtn, updateBtn, deleteBtn, backBtn, dellbtn;
	private MenuDAO dao;
	private JPopupMenu popUp;
	
	private DefaultTableModel model;
	private Vector<String> titleColumn;
	
	private FormView panelView;
	
	public ViewMenu() {
		this.setTitle("View Menu");
		dao = new MenuDAO();
		panelView = new FormView();
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
//		initTable();
		this.add(panelView);
		
		initButton();
		
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initButton() {
		backBtn = new JButton("Back");
		addBtn = new JButton("Add");
		updateBtn = new JButton("Update");
		deleteBtn = new JButton("Delete");
		
		backBtn.addActionListener(this);
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(Box.createHorizontalStrut(25));
		panel.add(backBtn);
		panel.add(Box.createHorizontalStrut(25));
		panel.add(addBtn);
		panel.add(Box.createHorizontalStrut(25));
		panel.add(updateBtn);
		panel.add(Box.createHorizontalStrut(25));
		panel.add(deleteBtn);
		panel.add(Box.createHorizontalStrut(25));
		
		this.add(panel);
	}

	private void initTable() {
		
		titleColumn = new Vector<String>();
		titleColumn.add("Kode");
		titleColumn.add("Nama");
		titleColumn.add("Harga");
		titleColumn.add("Stok");
		
		popUp = new JPopupMenu();
		dellbtn = new JButton("Delete");
		
		dellbtn.addActionListener(this);
		
		popUp.add(dellbtn);
		
		model = new DefaultTableModel(dao.getMenu(), titleColumn) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		table.setComponentPopupMenu(popUp);
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			new Home();
			this.dispose();
		}else if(e.getSource() == addBtn) {
			new AddMenu();
			this.dispose();
		}else if(e.getSource() == deleteBtn) {
			new DeleteMenu();
			this.dispose();
		}else if(e.getSource() == dellbtn) {
			int r = table.getSelectedRow();
			
			String id = table.getValueAt(r, 0).toString();
			
			dao.delete(id);
			
			JOptionPane.showMessageDialog(null, "Success to delete "+id);
			
			model.setDataVector(dao.getMenu(), titleColumn);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int r = table.rowAtPoint(e.getPoint());
		
		if(r>=0 && r<=table.getRowCount()) {
			table.setRowSelectionInterval(r, r);
		}else {
			table.clearSelection();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
