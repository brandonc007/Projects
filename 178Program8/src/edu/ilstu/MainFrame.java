/**
 * IT 178
 */
package edu.ilstu;

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
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public static void main(String args[]) {

	    JFrame aFrame = new MainFrame();
	    aFrame.setVisible(true);

	}

	/**
	 * This is a default constructor for MainFrame that creates a BoxLayout. 
	 */
	public MainFrame() {
		
	    setTitle("Restaurant Menu");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Item buttonPanel = new Item();
	    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	    setContentPane(buttonPanel);
	    pack();
	    
	}

}
