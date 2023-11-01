package edu.ilstu;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	private JButton helloButton;
	private JButton goodbyeButton;
	private StringListener textListener;
	
	public Toolbar()
	{
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEtchedBorder());
		add(helloButton);
		add(goodbyeButton);
		
	}
	
	public void setTextListener(StringListener textListener) {
		this.textListener = textListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Button has been clicked. ");
		JButton clicked = (JButton)e.getSource();
		if(clicked==helloButton)
			if(textListener!=null)
				textListener.textEmitted("Hello\n");
			//textPanel.appendText("Hello\n");
		if(clicked==goodbyeButton)
			if(textListener!=null)
				textListener.textEmitted("Goodbye\n");
			//textPanel.appendText("Goodbye\n");
	}

}
