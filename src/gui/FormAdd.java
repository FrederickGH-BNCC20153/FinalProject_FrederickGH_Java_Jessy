package gui;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormAdd extends JPanel{

	private JPanel panel1, panel2, panel3;
	private JTextField nameText, hargaText;
	private JComboBox stokCombo;
	
	public FormAdd() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panel1 = createPanelL();
		panel2 = createPanelL();
		panel3 = createPanelL();
		
		//1.kode menu
		//rand
		
		//2.nama menu
		nameText = new JTextField(20);
		panel1.add(new JLabel("Nama Menu"));
		panel1.add(nameText);
		
		//3.harga menu
		
		hargaText = new JTextField(20);
		panel2.add(new JLabel("Harga Menu"));
		panel2.add(hargaText);
		
		//4.stok menu
		Integer[] stokData = {0,
				1,2,3,4,5,6,7,8,9,10,
				11,12,13,14,15,16,17,18,19,20,
				21,22,23,24,25,26,27,28,29,30,
				31,32,33,34,35,36,37,38,39,40,
				41,42,43,44,45,46,47,48,49,50,
				51,52,53,54,55,56,57,58,59,60,
				61,62,63,64,65,66,67,68,69,70,
				71,72,73,74,75,76,77,78,79,80,
				81,82,83,84,85,86,87,88,89,90,
				91,92,93,94,95,96,97,98,99,100
				};
		stokCombo = new JComboBox(stokData);
		panel3.add(new JLabel("Stok"));
		panel3.add(stokCombo);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
	}
	
	public void clearForm() {
		nameText.setText("");
		hargaText.setText("");
		stokCombo.setSelectedIndex(0);
	}
	
	private JPanel createPanelL() {
		return new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 10));
	}

	public JTextField getNameText() {
		return nameText;
	}

	public JTextField getHargaText() {
		return hargaText;
	}

	public JComboBox getStokCombo() {
		return stokCombo;
	}
}
