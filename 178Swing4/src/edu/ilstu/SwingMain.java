package edu.ilstu;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame();			
			}			
		});
	}

}
