package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.MenuDAO;
import Menu.Data;

public class AddMenu extends JFrame implements ActionListener{

	private JPanel panel5;
	private JButton cancelBtn, addBtn;
	private FormAdd panelAdd;
	
	private MenuDAO dao;
	
	public AddMenu() {
		this.setTitle("Insert Menu");
		dao = new MenuDAO();
		panelAdd = new FormAdd();
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		panel5 = createPanelT();
		
		//panel 5
		addBtn = new JButton("Add");
		cancelBtn = new JButton("Cancel");
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		panel5.add(addBtn);
		panel5.add(cancelBtn);
		
		this.add(panelAdd);
		this.add(panel5);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private JPanel createPanelT() {
		return new JPanel(new FlowLayout(FlowLayout.TRAILING, 20, 10));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {
			new Home();
			this.dispose();
		}else if(e.getSource()== addBtn){
			boolean valid = true;
			
			String name = panelAdd.getNameText().getText();
			String hargaMentah = panelAdd.getHargaText().getText();
			int stok = (int)panelAdd.getStokCombo().getSelectedItem();
			
			if(name.trim().isEmpty()) {
				valid = false;
			}
			else if(hargaMentah.trim().isEmpty()) {
				valid = false;
			}
			
			if(!valid) {
				JOptionPane.showMessageDialog(null, "All Requirement Must be Filled!");
			}else {
				int harga = Integer.parseInt(hargaMentah);
				Data data = new Data(name, harga, stok);
				dao.insert(data);
				
				JOptionPane.showMessageDialog(null, "Success to add "+ name + " with id "+ data.getKode());
				
				panelAdd.clearForm();
			}
		}
	}
}
