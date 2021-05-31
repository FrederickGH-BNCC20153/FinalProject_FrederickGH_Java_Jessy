package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener{

	private JLabel label1;
	private JMenuBar menuBar;
	private JMenu menuHome , menuHelp;
	private JMenuItem addItem, viewItem, deleteItem, updateItem, exitItem, aboutItem;
	
	public Home() {
		this.setTitle("Menu Workplace");
		label1 = new JLabel("Workbench");
		
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label1);
		
		initMenuBar();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initMenuBar() {
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		menuHome = new JMenu("Home");
		menuHelp = new JMenu("About");
		
		addItem = new JMenuItem("Insert Menu");
		viewItem = new JMenuItem("View Menu");
		deleteItem = new JMenuItem("Delete Menu");
		updateItem = new JMenuItem("Update Menu");
		exitItem = new JMenuItem("Exit");
		aboutItem = new JMenuItem("About");
		
		exitItem.addActionListener(this);
		addItem.addActionListener(this);
		updateItem.addActionListener(this);
		deleteItem.addActionListener(this);
		aboutItem.addActionListener(this);
		viewItem.addActionListener(this);
		
		menuHome.add(addItem);
		menuHome.add(viewItem);
		menuHome.add(deleteItem);
		menuHome.add(updateItem);
		menuHome.add(exitItem);
		
		menuHelp.add(aboutItem);
		
		menuBar.add(menuHome);
		menuBar.add(menuHelp);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitItem) {
			System.exit(0);
		}else if(e.getSource() == addItem) {
			new AddMenu();
			this.dispose();
		}else if(e.getSource() == viewItem) {
			new ViewMenu();
			this.dispose();
		}else if(e.getSource() == updateItem) {
			new UpdateMenu();
			this.dispose();
		}else if(e.getSource() == deleteItem) {
			new DeleteMenu();
			this.dispose();
		}else if(e.getSource() == aboutItem) {
			new AboutPanel();
			this.dispose();
		}
	}

}
