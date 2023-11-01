package edu.ilstu;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	private JLabel nameLabel, occupationLabel, ageLabel, empLabel, citizenLabel, taxLabel, genderLabel;
	private JTextField nameField, occupationField, taxField;
	private JButton okBtn;
	private JList ageList;
	private FormEvent formEvent;
	private FormListener formListener;
	private JComboBox empCombo;
	private JCheckBox citizenCheck;
	private JRadioButton femaleRadio, maleRadio;
	private ButtonGroup genderGroup;
	
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

	public FormPanel()
	{
		Dimension dim = getPreferredSize();
		dim.width=300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		ageLabel = new JLabel("Age: ");
		citizenLabel = new JLabel("US Citizen: ");
		taxLabel = new JLabel("Tax ID: ");
		genderLabel = new JLabel("Gender: ");
		
		taxLabel.setEnabled(false);
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		taxField= new JTextField(10);
		taxField.setEnabled(false);
		
		ageList = new JList();
		DefaultListModel ageModel = new DefaultListModel();
		ageModel.addElement(new AgeCategory(0,"Under 18"));
		ageModel.addElement(new AgeCategory(1,"18 to 65"));
		ageModel.addElement(new AgeCategory(2,"65 and over"));
		ageList.setModel(ageModel);
		citizenCheck= new JCheckBox();
		citizenCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean isChecked = citizenCheck.isSelected();
				taxLabel.setEnabled(isChecked);
				taxField.setEnabled(isChecked);
			}
			
		});
		
		empLabel = new JLabel("Employment Status: ");
		empCombo = new JComboBox();
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("employed");
		empModel.addElement("self-employed");
		empModel.addElement("unemployed");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		empCombo.setEditable(true);
		
		femaleRadio = new JRadioButton("female");
		maleRadio = new JRadioButton("male");
		genderGroup = new ButtonGroup();
		maleRadio.setSelected(true);
		genderGroup.add(femaleRadio);
		genderGroup.add(maleRadio);
		maleRadio.setActionCommand("male");
		femaleRadio.setActionCommand("female");
		okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
				//System.out.println(ageCat.getId());
				String empCat = (String) empCombo.getSelectedItem();
				//System.out.println(empCat);
				String gender = genderGroup.getSelection().getActionCommand();
				FormEvent ev = new FormEvent(this, name,occupation,ageCat.getId(), empCat, citizenCheck.isSelected(), taxField.getText(),gender);
				if(formListener!=null)
					formListener.formEventOccurred(ev);
			}
			
		});
		layoutComponents();
	}
	public void layoutComponents()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		////////row one/////////
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =0;
		gc.gridy =0;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(nameLabel,gc);
		
		gc.gridx =1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(nameField,gc);
		
		/////row two////////
		gc.gridx= 0;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(occupationLabel,gc);
		
		gc.gridx=1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(occupationField,gc);
		
		///row three////
		gc.gridx= 0;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(ageLabel,gc);
		
		gc.gridx=1;
		gc.weightx =1;
		gc.weighty =.2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		ageList.setPreferredSize(new Dimension(100,70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		add(ageList,gc);
		
		/////row four////
		gc.gridx= 0;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(empLabel,gc);
		
		gc.gridx=1;
		gc.weightx =1;
		gc.weighty =.2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		ageList.setPreferredSize(new Dimension(100,70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		add(empCombo,gc);
		
		////row five/////
		gc.gridx= 0;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(citizenLabel,gc);
		
		gc.gridx=1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(citizenCheck,gc);
		
		////row six/////
		gc.gridx= 0;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(taxLabel,gc);
		
		gc.gridx=1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(taxField,gc);
		
		///////row seven////
		gc.gridx= 0;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =.02;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(genderLabel,gc);
		
		gc.gridx=1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(femaleRadio,gc);
		////row eight/////
		gc.gridx= 1;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =.02;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(maleRadio,gc);
		///////row nine////
		gc.gridx=1;
		gc.gridy++;
		gc.weightx =1;
		gc.weighty =1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(okBtn,gc);
		

	}
	class AgeCategory{
		private String text;
		private int id;
		
		public AgeCategory(int id, String text)
		{
			this.id =  id;
			this.text = text;
		}
		public String toString()
		{
			return text;
		}
		public String getText() {
			return text;
		}
		public int getId() {
			return id;
		}
		
	}

}
