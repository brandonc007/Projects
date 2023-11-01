/**
 * IT 178
 */
package edu.ilstu;

import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 * 
 * @author Brandon Claahsen
 * 
 * ULID: bdclaah
 * 
 * Creating a calculator in Java 
 * 
 * Date: 3/10/22
 *
 */
public class Calculator extends JFrame implements ActionListener {

	private static JFrame j;
	private static JTextField k;
	String str0,str1,str2;
	
	/**
	 *	This is a default constructor for a Calculator. 
	 */
	public Calculator() 
	{
		str0=str1=str2="";
	}
	public static void main(String[] args) {
		j= new JFrame("calculator");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		}
		catch (Exception e) {
			System.err.println("Error!");
		}
		Calculator c = new Calculator();
		k = new JTextField(16);
		k.setEditable(false);

		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
	  	b0 = new JButton("0");
	  	b1 = new JButton("1");
	  	b2 = new JButton("2");
	  	b3 = new JButton("3");
	  	b4 = new JButton("4");
	  	b5 = new JButton("5");
	  	b6 = new JButton("6");
	  	b7 = new JButton("7");
	  	b8 = new JButton("8");
	  	b9 = new JButton("9");
	  	beq1 = new JButton("=");
	  	ba = new JButton("+");
	  	bs = new JButton("-");
	  	bd = new JButton("/");
	  	bm = new JButton("*");
	    beq = new JButton("C");
	    be = new JButton(".");
	    JPanel p = new JPanel();
	    
	    bm.addActionListener(c);
	    bd.addActionListener(c);
	    bs.addActionListener(c);
	    ba.addActionListener(c);    
	    b9.addActionListener(c);
	    b8.addActionListener(c);
	    b7.addActionListener(c);
	    b6.addActionListener(c);
	    b5.addActionListener(c);
	    b4.addActionListener(c);
	    b3.addActionListener(c);
	    b2.addActionListener(c);
	    b1.addActionListener(c);
	    b0.addActionListener(c);
	    be.addActionListener(c);
	    beq.addActionListener(c);
	    beq1.addActionListener(c);
	    
	    p.add(k);
	    p.add(ba);
	    p.add(b1);
	    p.add(b2);
	    p.add(b3);
	    p.add(bs);
	    p.add(b4);
	    p.add(b5);
	    p.add(b6);
	    p.add(bm);
	    p.add(b7);
	    p.add(b8);
	    p.add(b9);
	    p.add(bd);
	    p.add(be);
	    p.add(b0);
	    p.add(beq);
	    p.add(beq1);
	    p.setBackground(Color.black);
	    j.add(p);
	    j.setSize(200, 220);
	    j.show();
	}
	
	/**
	 *	This is a void method that performs an action event. 
	 */
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			if (!str1.equals(""))
				str2 = str2 + s;
	        else
	            str0 = str0 + s;
			k.setText(str0 + str1 + str2);
	    }
	    else if (s.charAt(0) == 'C') {    
	    	str0 = str1 = str2 = "";
	        k.setText(str0 + str1 + str2);
	    }
	    else if (s.charAt(0) == '=') {
	    	double te;
	    	if (str1.equals("+"))
	    		te = (Double.parseDouble(str0) + Double.parseDouble(str2));
	    	else if (str1.equals("-"))
	            te = (Double.parseDouble(str0) - Double.parseDouble(str2));
            else if (str1.equals("/"))
            	te = (Double.parseDouble(str0) / Double.parseDouble(str2));
            else
            	te = (Double.parseDouble(str0) * Double.parseDouble(str2));
	        k.setText(str0 + str1 + str2 + "=" + te);
	        str0 = Double.toString(te);
	        str1 = str2 = "";
	     }
	     else {
	    	 if (str1.equals("") || str2.equals(""))
	    		 str1 = s;
	    	 else {
	            double te;
	            if (str1.equals("+"))
	            	te = (Double.parseDouble(str0) + Double.parseDouble(str2));
	            else if (str1.equals("-"))
	            	te = (Double.parseDouble(str0) - Double.parseDouble(str2));
	            else if (str1.equals("/"))
	            	te = (Double.parseDouble(str0) / Double.parseDouble(str2));
	            else
	            	te = (Double.parseDouble(str0) * Double.parseDouble(str2));
	            str0 = Double.toString(te);
	            str1 = s;
	            str2 = "";
	         }
	    	 k.setText(str0 + str1 + str2);
	     }
	}
}
