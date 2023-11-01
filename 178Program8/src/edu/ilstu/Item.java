/**
 * IT 178
 */
package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.Container;
/**
 * 
 * @author Brandon Claahsen
 * 
 * ULID: bdclaah
 * 
 * Creating a restaurant menu with items in Java using TextField, RadioButtons, JLabels..
 * 
 * Date: 3/20/21
 *
 */
import java.awt.Dimension;
import java.text.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.ArrayList;

public class Item extends JPanel {

	private final JTextField nameField;
	private JLabel nameLabel;
	private JLabel drinkLabel;
	private JLabel appetizerLabel;
	private JLabel entreeLabel;
	private JLabel dessertLabel;
	private int quantity;
	private Container c;
	private formPanel panel;

	String[] drinkChoice = {"Coke 		$1.95", "Beer 		$2.95", "Wine 		$4.95"};
	String[] appChoice = {"Soup 		$3.95", "Salad 		$4.95", "Cheese Curds 	$5.95"};
	String[] entreeChoice = {"Pasta 		$11.95", "Steak 		$19.95", "Cheeseburger 	$9.95"};
	String[] dessertChoice = {"Tiramisu 	$6.95", "Cheesecake 	$5.95", "Chocolate Cake 	$4.95"};
	
	JRadioButton[] drinkButtons = new JRadioButton[drinkChoice.length];
	JRadioButton[] appButtons = new JRadioButton[appChoice.length];
	JRadioButton[] entreeButtons = new JRadioButton[entreeChoice.length];
	JRadioButton[] dessertButtons = new JRadioButton[dessertChoice.length];
	
	ButtonGroup buttonGroupDrink = new ButtonGroup();
	ButtonGroup buttonGroupApp = new ButtonGroup();
	ButtonGroup buttonGroupEntree = new ButtonGroup();
	ButtonGroup buttonGroupDessert = new ButtonGroup();
	
	JButton mealCost;
	JButton nextPerson;
	JButton submitOrder;
	
	ArrayList<Double> tableTotal = new ArrayList(0);
	
	double mealTotal = 0;
	double mealTotal1 = 0;
	
	/**
	 * Default constructor for Item class that creates a restaurant menu. 
	 */
	public Item(){
		 
		nameLabel = new JLabel("Name: (Press Enter)");
		 
	    layoutComponents();
		
	    ActionListener nameEntered = new NameEntered(); 
	    nameField = new JTextField(10);
	    add(nameField);
	    nameField.addActionListener(nameEntered);
	
	    ActionListener drinkSelection = new DrinkSelectionChangeMade();
	    ActionListener appSelection = new AppSelectionChangeMade();
	    ActionListener entreeSelection = new EntreeSelectionChangeMade();
	    ActionListener dessertSelection = new DessertSelectionChangeMade();
	    
	    drinkLabel = new JLabel("Choose a Drink");
	    layoutComponents2();
	    for (int i = 0; i < drinkChoice.length; i++) {
	        drinkButtons[i] = new JRadioButton(drinkChoice[i]);
	        drinkButtons[i].getModel().setActionCommand(drinkChoice[i]);
	        drinkButtons[i].addActionListener(drinkSelection);
	        buttonGroupDrink.add(drinkButtons[i]);
	        add(drinkButtons[i]);
	    }
	    
	    appetizerLabel = new JLabel("Choose an Appetizer");
	    layoutComponents3();
	    for (int i = 0; i < appChoice.length; i++) {
	        appButtons[i] = new JRadioButton(appChoice[i]);
	        appButtons[i].getModel().setActionCommand(appChoice[i]);
	        appButtons[i].addActionListener(appSelection);
	        buttonGroupApp.add(appButtons[i]);
	        add(appButtons[i]);
	    }
	
	    entreeLabel = new JLabel("Choose an Entree");
	    layoutComponents4();
	    for (int i = 0; i < entreeChoice.length; i++) {
	        entreeButtons[i] = new JRadioButton(entreeChoice[i]);
	        entreeButtons[i].getModel().setActionCommand(entreeChoice[i]);
	        entreeButtons[i].addActionListener(entreeSelection);
	        buttonGroupEntree.add(entreeButtons[i]);
	        add(entreeButtons[i]);
	
	    }
	
	    dessertLabel = new JLabel("Choose a Dessert");
	    layoutComponents5();
	    for (int i = 0; i < dessertChoice.length; i++) {
	        dessertButtons[i] = new JRadioButton(dessertChoice[i]);
	        dessertButtons[i].getModel().setActionCommand(dessertChoice[i]);
	        dessertButtons[i].addActionListener(dessertSelection);
	        buttonGroupDessert.add(dessertButtons[i]);
	        add(dessertButtons[i]);
	
	    };
	   
	    mealCost = new JButton("Total Cost of Meal");
	    add(mealCost);
	    ActionListener mealPrice = new MealCostPressed();
	    mealCost.addActionListener(mealPrice);
	
	    nextPerson = new JButton("Next Person");
	    add(nextPerson);
	    ActionListener next = new NextPersonPressed();
	    nextPerson.addActionListener(next);
	
	    submitOrder = new JButton("Submit Order");
	    add(submitOrder);
	    ActionListener submit = new SubmitPressed();
	    submitOrder.addActionListener(submit);
	    
	    panel = new formPanel();
	    setLayout(new BorderLayout());
		setJMenuBar(createMenuBar());
		
		add(panel,BorderLayout.EAST);
		setSize(300,300);
		setVisible(true);
	    
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	private void setJMenuBar(JMenuBar createMenuBar) {
		// TODO Auto-generated method stub
		
	}

	private JMenuBar createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");
		
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showformItem = new JCheckBoxMenuItem("Order");
		showformItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				panel.setVisible(menuItem.isSelected());
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
	
	/**
	 * Layout for JLabel nameLabel
	 */
	public void layoutComponents()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =0;
		gc.gridy =0;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(nameLabel,gc);
		
	}
	
	/**
	 * Layout for JLabel drinkingLabel
	 */
	public void layoutComponents2()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =0;
		
		gc.gridx =1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(drinkLabel,gc);
	}
	
	/**
	 * Layout for JLabel appetizerLabel
	 */
	public void layoutComponents3()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =0;
		gc.gridy =0;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(appetizerLabel,gc);
	}
	
	/**
	 * Layout for JLabel entreeLabel
	 */
	public void layoutComponents4()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =0;
		gc.gridy =0;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(entreeLabel,gc);
	}
	
	/**
	 * Layout for JLabel dessertLabel
	 */
	public void layoutComponents5()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =0;
		gc.gridy =0;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(dessertLabel,gc);
	}
	
	/**
	 * Prints the name of the person when the name is entered into the textField.
	 */
	private class NameEntered implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e){
	        String name = nameField.getText();
	        System.out.println(name);
	    }
	}
	
	/**
	 * Prints the corresponding drink that was selected from radioButtons with the price. Adds to total.
	 */
	private class DrinkSelectionChangeMade implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	quantity++;
	        String drink = buttonGroupDrink.getSelection().getActionCommand();
	        System.out.println(drink + " as a drink");
	        if(drink == "Coke"){
	            mealTotal = mealTotal + 1.95;
	        }
	        else if(drink == "Beer"){
	            mealTotal = mealTotal + 2.95;
	        }
	        else{
	            mealTotal = mealTotal + 4.95;
	        }
	    }
	}

	/**
	 * Prints the corresponding appetizer that was selected from radioButtons with the price. Adds to total.
	 */
	private class AppSelectionChangeMade implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	quantity++;
	        String app = buttonGroupApp.getSelection().getActionCommand();
	        System.out.println(app + " as an appetizer");
	        if(app == "Soup"){
	            mealTotal = mealTotal + 3.95;
	        }
	        else if(app == "Salad"){
	            mealTotal = mealTotal + 4.95;
	        }
	        else{
	            mealTotal = mealTotal + 5.95;
	        }
	    }
	}
	
	/**
	 * Prints the corresponding entree that was selected from radioButtons with the price. Adds to total.
	 */
	private class EntreeSelectionChangeMade implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	quantity++;
	        String entree = buttonGroupEntree.getSelection().getActionCommand();
	        System.out.println(entree + " as an entree");
	        if(entree == "Pasta"){
	            mealTotal = mealTotal + 11.95;
	        }
	        else if(entree == "Steak"){
	            mealTotal = mealTotal + 19.95;
	        }
	        else{
	            mealTotal = mealTotal + 9.95;
	        }
	    }
	}
	
	/**
	 * Prints the corresponding dessert that was selected from radioButtons with the price. Adds to total.
	 */
	private class DessertSelectionChangeMade implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	quantity++;
	    	String dessert = buttonGroupDessert.getSelection().getActionCommand();
	      	System.out.println(dessert + " as a dessert");
	        if(dessert == "Tiramisu"){
	            mealTotal = mealTotal + 6.95;
	        }
	        else if(dessert == "Cheesecake"){
	            mealTotal = mealTotal + 5.95;
	        }
	        else{
	            mealTotal = mealTotal + 4.95;
	        }
	            tableTotal.add(mealTotal);
	    }
	}

	/**
	 * Creates a new JFrame for a new customer if the Next Person button is pressed.
	 */
	private class NextPersonPressed implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e){
	      JFrame nextFrame = new MainFrame();
	      nextFrame.setVisible(true);
	      System.out.println("Next Customer: "); 
	    }
	}
	
	/**
	 * Displays the meal cost in dollars if the Total Cost for Meal button is pressed.
	 */
	private class MealCostPressed implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e){
	    	final double tax=.07;
	    	mealTotal=mealTotal*tax+mealTotal;
	    	tableTotal.add(mealTotal);
	    	DecimalFormat formatter=new DecimalFormat("$0.00");
	        JOptionPane.showMessageDialog(mealCost, formatter.format(mealTotal));
	    }
	}
	
	/**
	 * Displays a messages thanking you for your order if the Submit Order button is pressed. 
	 */
	private class SubmitPressed implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e){
	    	DecimalFormat formatter=new DecimalFormat("$0.00");
	        JOptionPane.showMessageDialog(nextPerson, "Thank you for your order. Please Exit Now.");
	        System.out.println("The total cost for the table is: " + formatter.format(mealTotal));
	    }
}

}
