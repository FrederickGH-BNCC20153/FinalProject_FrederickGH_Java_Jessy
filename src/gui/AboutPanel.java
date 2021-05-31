package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPanel extends JFrame implements ActionListener{

	private JLabel label1,label2;
	private JPanel panel1,panel2;
	private JButton back;
	
	public AboutPanel() {
		this.setTitle("About");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		panel1 = createPanelL();
		panel2 = createPanelT();
		
		label1 = new JLabel("This Gui was made By Frederick Gervaise");
		label2 = new JLabel("Harianto - BNCC20153 for BobaCool Company.");
		
		back = new JButton("Back");
		back.addActionListener(this);
		
		panel1.add(label1);
		panel1.add(label2);
		panel2.add(back);
		
		this.add(panel1);
		this.add(panel2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private JPanel createPanelL() {
		return new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 10));
	}
	
	private JPanel createPanelT() {
		return new JPanel(new FlowLayout(FlowLayout.TRAILING, 20, 10));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			new Home();
			this.dispose();
		}
	}

}
