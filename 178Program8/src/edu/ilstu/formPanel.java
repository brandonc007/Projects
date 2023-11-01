/**
 * 
 */
package edu.ilstu;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
public class formPanel extends JPanel {
	
	public formPanel() {
		Dimension dim = getPreferredSize();
		dim.width=300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
	}
	
	
	
}
