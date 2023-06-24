import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

//The CustomJFrame class is responsible for creating the gui and formatting the input boxes and buttons. It also formats the information into comma seperated format for the FileHandler.
public class CustomJFrame extends JFrame{
	private JLabel headingLabel = new JLabel("Personal Information");
	private JLabel firstNameLabel = new JLabel("First Name:");
	private JLabel lastNameLabel = new JLabel("Last Name:");
	private JLabel phoneNumberLabel = new JLabel("Phone Number:");
	private JLabel emailLabel = new JLabel("Email:");
	private JLabel genderLabel = new JLabel("Sex:");
	private JLabel dietaryLabel = new JLabel("Dietary Questions");
	private JLabel waterLabel = new JLabel("How many cups of water on average do you drink a day?");
	private JLabel mealsLabel = new JLabel("How many meals on average do you eat a day?");
	private JLabel checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
	private JLabel walkLabel = new JLabel("On average how many miles do you walk in a day?");
	private JLabel weightLabel = new JLabel("How much do you weigh?");
	private JTextField firstNameTextField = new JTextField();
	private JTextField lastNameTextField = new JTextField();
	private JTextField phoneNumberTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JRadioButton maleRadioButton = new JRadioButton("Male");
	private JRadioButton femaleRadioButton = new JRadioButton("Female");
	private JRadioButton preferRadioButton = new JRadioButton("Prefer not to say");
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private JSpinner waterIntakeSpinner = new JSpinner( new SpinnerNumberModel(15, 0, 50, 1));
	private JSlider mealSlider = new JSlider(0, 10, 3);
	private JCheckBox wheatCheckBox = new JCheckBox("Wheat");
	private JCheckBox sugarCheckBox = new JCheckBox("Sugar");
	private JCheckBox dairyCheckBox = new JCheckBox("Dairy");
	private String[] walkOptions = new String[4];
	private JComboBox walkComboBox;
	private JFormattedTextField weightFormattedTextField;
	private JButton clearButton = new JButton("Clear");
	private JButton submitButton = new JButton("Submit");
	private FileHandler fileHandler = new FileHandler();

	public CustomJFrame() {
		//add all the walkOptions into the Combo box
		walkOptions[0] = "Less than 1 Mile";
		walkOptions[1] = "More than 1 Mile but less than 2 miles";
		walkOptions[2] = "More than 2 Miles but less than 3 miles";
		walkOptions[3] = "More than 3 Miles";
		walkComboBox = new JComboBox(walkOptions);

		this.setTitle("Dietary Survey");
		this.setLayout(new GridBagLayout());
		
		//layout for each of the input streams and labels
		GridBagConstraints layoutManager = new GridBagConstraints();
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		layoutManager.insets = new Insets(5, 10, 10, 5);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		layoutManager.fill = GridBagConstraints.HORIZONTAL;
		this.add(headingLabel, layoutManager);
		
		layoutManager.fill = GridBagConstraints.NONE;

		JPanel personalInfoPanel = new JPanel();
		personalInfoPanel.add(firstNameLabel);
		firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
		personalInfoPanel.add(firstNameTextField);

		personalInfoPanel.add(lastNameLabel);
		lastNameLabel.setHorizontalAlignment(JLabel.CENTER);
		personalInfoPanel.add(lastNameTextField);
		
		personalInfoPanel.add(phoneNumberLabel);
		phoneNumberLabel.setHorizontalAlignment(JLabel.CENTER);
		personalInfoPanel.add(phoneNumberTextField);
		
		personalInfoPanel.add(emailLabel);
		emailLabel.setHorizontalAlignment(JLabel.CENTER);
		personalInfoPanel.add(emailTextField);
		
		personalInfoPanel.add(genderLabel);
		genderLabel.setHorizontalAlignment(JLabel.CENTER);

		//set the radio buttons Aciton Commands to read inputs
		JPanel sexPanel = new JPanel();
		maleRadioButton.setActionCommand("Male");
		sexPanel.add(maleRadioButton);
		femaleRadioButton.setActionCommand("Female");
		sexPanel.add(femaleRadioButton);
		preferRadioButton.setActionCommand("Prefer not to say");
		sexPanel.add(preferRadioButton);
		personalInfoPanel.add(sexPanel);
		personalInfoPanel.setLayout(new GridLayout(7, 2));

		layoutManager.gridx = 0;
		layoutManager.gridy = 1;
		this.add(personalInfoPanel, layoutManager);
		
		
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 8;
		layoutManager.fill = GridBagConstraints.HORIZONTAL;
		this.add(dietaryLabel, layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 9;
		layoutManager.fill = GridBagConstraints.NONE;
		this.add(waterLabel, layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 10;
		this.add(waterIntakeSpinner, layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 11;
		layoutManager.fill = GridBagConstraints.NONE;
		this.add(mealsLabel, layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 12;
		mealSlider.setPaintTicks(true);
		mealSlider.setPaintLabels(true);
		mealSlider.setSnapToTicks(true);
	    mealSlider.setMajorTickSpacing(1);
	    mealSlider.setMinorTickSpacing(1);
		this.add(mealSlider, layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 13;
		layoutManager.fill = GridBagConstraints.NONE;
		this.add(checkBoxLabel, layoutManager);
		
		JPanel checkBoxPanel = new JPanel(new FlowLayout());
		checkBoxPanel.add(dairyCheckBox);
		checkBoxPanel.add(wheatCheckBox);
		checkBoxPanel.add(sugarCheckBox);
		layoutManager.gridx = 0;
		layoutManager.gridy = 14;
		this.add(checkBoxPanel, layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 15;
		layoutManager.fill = GridBagConstraints.NONE;
		this.add(walkLabel, layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 16;
		this.add(walkComboBox, layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 17;
		layoutManager.fill = GridBagConstraints.NONE;
		this.add(weightLabel, layoutManager);
		
		//set the Formatted text field to only allow for numbers to be written
		NumberFormat format = NumberFormat.getInstance();
	    format.setGroupingUsed(false);
	    NumberFormatter formatter = new NumberFormatter(format);
	    format.setGroupingUsed(false);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
	    weightFormattedTextField = new JFormattedTextField(formatter);
		layoutManager.gridx = 0;
		layoutManager.gridy = 18;
		this.add(weightFormattedTextField, layoutManager);
		weightFormattedTextField.setColumns(15);
		
		JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        
		clearButton.setBackground(Color.YELLOW);
        buttonPanel.add(clearButton);
     
		submitButton.setBackground(Color.GREEN);
        buttonPanel.add(submitButton);
        
        layoutManager.gridx = 0;
		layoutManager.gridy = 19;
        this.add(buttonPanel, layoutManager);
        
        clearButton.addActionListener(new InnerActionListener());
        submitButton.addActionListener(new InnerActionListener());
        
	}
	
	//InnerActionListner is responsible for corresponding the submit and clear buttons to methods that allow them to execture properly
	public class InnerActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clearButton) {
				clearForm();
			}
			
			if(e.getSource() == submitButton) {
				String surveyData;
				//format Date and time for the fileHandler
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss aa");  
			    Date date = new Date();  
			    String now = formatter.format(date);
			    surveyData = now + ", ";
			    surveyData = surveyData + firstNameTextField.getText() + "," + lastNameTextField.getText() + "," + phoneNumberTextField.getText() + "," + emailTextField.getText() + ",";
			    //Catches the exception if no gender is selected
			    try {
			    	surveyData = surveyData + radioButtonGroup.getSelection().getActionCommand() + ",";
			    }
			    catch(Exception n) {
			    	
			    }
			    surveyData = surveyData + waterIntakeSpinner.getValue().toString() + "," + mealSlider.getValue() + "," + wheatCheckBox.isSelected() + "," + sugarCheckBox.isSelected() + "," + dairyCheckBox.isSelected() + "," + walkOptions[(walkComboBox.getSelectedIndex())] + "," + weightFormattedTextField.getText();
			    
			    System.out.println(surveyData);

			    fileHandler.writeResults(surveyData);
			    clearForm();
			    }
			    
			}
		}
		//resets all the inputs back to their original values
		private void clearForm() {
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			weightFormattedTextField.setValue(null);
			maleRadioButton.setSelected(false);
			femaleRadioButton.setSelected(false);
			preferRadioButton.setSelected(false);
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			dairyCheckBox.setSelected(false);
			walkComboBox.setSelectedIndex(0);
		}
	}
	

