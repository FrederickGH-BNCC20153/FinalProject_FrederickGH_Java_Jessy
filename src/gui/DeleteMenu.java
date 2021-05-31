package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.MenuDAO;

public class DeleteMenu extends JFrame implements ActionListener, MouseListener{
	
	private JPanel panel1,panel2;
	private JButton cancelBtn, okBtn, dellbtn;
	private Vector<String> titleColumn;
	private JTextField codeTarget;
	private JTable table;
	private JScrollPane scroll;
	private JPopupMenu popUp;
	private DefaultTableModel model;
	private MenuDAO dao;
	
	public DeleteMenu() {
		this.setTitle("Delete Menu");
		dao = new MenuDAO();
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		panel1 = createPanelL();
		panel2 = createPanelT();
		
		codeTarget = new JTextField(8);
		panel1.add(new JLabel("Insert Kode to Delete"));
		panel1.add(codeTarget);
		
		okBtn = new JButton("Confirm");
		cancelBtn = new JButton("Cancel");
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		panel2.add(okBtn);
		panel2.add(cancelBtn);
		
		popUp = new JPopupMenu();
		dellbtn = new JButton("Delete");
		
		initTable();
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
			}else if(e.getSource()== okBtn){
				boolean valid = true;
				
				String target = codeTarget.getText();
				
				if(target.trim().isEmpty()) {
					valid = false;
				}
				
				if(!valid) {
					JOptionPane.showMessageDialog(null, "Code Must be Filled!");
				}else {
					dao.delete(target);
					JOptionPane.showMessageDialog(null, "Success to delete "+target);
					
					model.setDataVector(dao.getMenu(), titleColumn);
				}
				
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
		int select = table.rowAtPoint(e.getPoint());
		
		if(select>=0 && select<=table.getRowCount()) {
			table.setRowSelectionInterval(select, select);
		}else {
			table.clearSelection();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
