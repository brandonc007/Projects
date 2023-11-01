package edu.ilstu;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {
	
	private TextPanel textPanel;
	private FormPanel formPanel;
	private Toolbar toolbar;
	
	public MainFrame()
	{
		super("Hello World");
			
		setLayout(new BorderLayout());
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		setJMenuBar(createMenuBar());
		/*btn = new JButton("Click Me!");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Hello\n");				
			}			
		});*/
		toolbar.setTextListener(new StringListener(){
			@Override
			public void textEmitted(String text) {
				textPanel.appendText(text);				
			}		
		});
		formPanel.setFormListener(new FormListener() {

			@Override
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory();
				String empCat = e.getEmpCategory();
				boolean citizenCheck = e.isCitizen();
				String taxID = e.getTaxID();
				String gender = e.getGender();
				textPanel.appendText(name + ": " + occupation + ": " + ageCat+ ": " + empCat+ ": " + citizenCheck + ": " + taxID+": " +gender + "\n");			
			}		
		});
		//toolbar.setTextPanel(textPanel);
		add(formPanel,BorderLayout.WEST);
		add(toolbar,BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		//add(btn,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
		
	}
	private JMenuBar createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");
		
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("exit");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		JMenu showMenu = new JMenu("show");
		JCheckBoxMenuItem showformItem = new JCheckBoxMenuItem("Person Form");
		showformItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
			
		});
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.add(exitItem);
		windowMenu.add(showMenu);
		showMenu.add(showformItem);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		return menuBar;
	}

}
