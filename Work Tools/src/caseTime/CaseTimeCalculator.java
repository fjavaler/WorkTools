package caseTime;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ItemEvent;

public class CaseTimeCalculator
{
    private JFrame frmTimeCalculator;
    private JTextField AddHoursOutput;
    private JTextField addMinutesOutput;
    private JTextField shiftStartHourInput;
    private JTextField shiftStartMinuteInput;
    private JTextField currentTimeHourInput;
    private JTextField currentTimeMinutesInput;
    private JTextField cumulativeHoursInput;
    private JTextField cumulativeMinutesInput;
    protected String shiftStartHour;
    protected String shiftStartMinute;
    protected int shiftStartAmPm;
    protected String currentTimeHour;
    protected String currentTimeMinute;
    protected int currentTimeAmPm;
    protected String accruedTimeHours;
    protected String accruedTimeMinutes;
    File saveFile = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    CaseTimeCalculator window = new CaseTimeCalculator();
		    window.frmTimeCalculator.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     * @throws Exception 
     */

    public CaseTimeCalculator() throws Exception
    {
	//tests read from file
	saveFile = new File("src/saveFile.sav");
//		Read the file to test if file was found.
	Scanner sc = new Scanner(saveFile);
	int counter = 0;
	String lastLine = "";
	while (sc.hasNextLine())
	{
	    lastLine = sc.nextLine();
	    
	    counter++;
	}
	//have final final line at this point
//	System.out.println("last line: " + lastLine);
//	System.out.println("count: " + counter);
	
	if (counter != 0)
	{
	    System.out.println("has data");
	    //Read and load start time to shiftStart text fields
	    String hoursInput;
	    String minutesInput;
	    String amPMInput;
	    //TODO: Start here next
	}
	else
	{
	    System.out.println("doesn't have data");
	    //Prompt user for start time
	    String userInput = JOptionPane.showInputDialog(
		    "What time did you start work today?\nFormat: HHMMXM\n\nValid Examples:\n0800AM\n1200PM");
	    //Valid format: HHMMXM
	    Boolean isFormattedCorrectly = userInput.matches("[0-9]{4}[A|P]M");
	    if (isFormattedCorrectly == false)
		JOptionPane.showMessageDialog(null,
			"Your time is improperly formatted.\nPlease enter a valid time in the format, \"HHMMXM\",\nWhere H stands for hour, M stands for minute, and XM can either be AM or PM");
	    else
		JOptionPane.showMessageDialog(null, "Correctly formatted!");
	}
	sc.close();   
	
//	See if save file already exists
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	// Constants
	String[] amPmString = { "AM", "PM" };

	String[] hours = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };

	String[] minutes = new String[60];
	for (int i = 0; i < minutes.length; i++)
	{
	    if (i < 10)
		minutes[i] = "0" + i;
	    else
		minutes[i] = "" + i;
	}

	// Begin draw
	frmTimeCalculator = new JFrame();
	frmTimeCalculator.setTitle("Case TIme Calculator");
	frmTimeCalculator.setForeground(Color.BLACK);
	frmTimeCalculator.setBackground(Color.BLACK);
	frmTimeCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage(CaseTimeCalculator.class
		.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-information.png")));
	frmTimeCalculator.getContentPane().setBackground(Color.BLACK);
	frmTimeCalculator.getContentPane().setLayout(null);

	JPanel panel = new JPanel();
	panel.setBackground(Color.BLACK);
	panel.setBounds(10, 11, 364, 95);
	frmTimeCalculator.getContentPane().add(panel);
	panel.setLayout(null);

	JLabel lblTimeCalculator = new JLabel("Time Calculator Tool");
	lblTimeCalculator.setForeground(Color.WHITE);
	lblTimeCalculator.setFont(new Font("Tahoma", Font.BOLD, 25));
	lblTimeCalculator.setHorizontalAlignment(SwingConstants.CENTER);
	lblTimeCalculator.setBounds(34, 0, 299, 25);
	panel.add(lblTimeCalculator);

	JLabel lblWhatTimeDid = new JLabel("What time did your shift start today?");
	lblWhatTimeDid.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblWhatTimeDid.setHorizontalAlignment(SwingConstants.CENTER);
	lblWhatTimeDid.setForeground(new Color(255, 255, 255));
	lblWhatTimeDid.setBounds(10, 36, 344, 14);
	panel.add(lblWhatTimeDid);

	JComboBox shiftStartComboBox = new JComboBox(amPmString);
	shiftStartComboBox.setEnabled(false);
	shiftStartComboBox.setBackground(Color.LIGHT_GRAY);
	shiftStartComboBox.setBounds(235, 59, 50, 20);
	panel.add(shiftStartComboBox);

	JLabel label = new JLabel("Hour");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.WHITE);
	label.setBounds(90, 82, 39, 14);
	panel.add(label);

	JLabel label_1 = new JLabel("Minutes");
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	label_1.setForeground(Color.WHITE);
	label_1.setBounds(162, 82, 45, 14);
	panel.add(label_1);

	JLabel lblAmpm_1 = new JLabel("AM/PM");
	lblAmpm_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblAmpm_1.setForeground(Color.WHITE);
	lblAmpm_1.setBounds(235, 82, 46, 14);
	panel.add(lblAmpm_1);

	shiftStartHourInput = new JTextField();
	shiftStartHourInput.setEditable(false);
	shiftStartHourInput.setBackground(Color.LIGHT_GRAY);
	shiftStartHourInput.setBounds(85, 59, 50, 20);
	panel.add(shiftStartHourInput);
	shiftStartHourInput.setColumns(10);

	shiftStartMinuteInput = new JTextField();
	shiftStartMinuteInput.setEditable(false);
	shiftStartMinuteInput.setBackground(Color.LIGHT_GRAY);
	shiftStartMinuteInput.setColumns(10);
	shiftStartMinuteInput.setBounds(157, 59, 50, 20);
	panel.add(shiftStartMinuteInput);

	JCheckBox chckbxUpdate = new JCheckBox("Update");
	chckbxUpdate.addItemListener(new ItemListener()
	{
	    public void itemStateChanged(ItemEvent e)
	    {
		int state = e.getStateChange();
		if (state == ItemEvent.DESELECTED)
		{
		    shiftStartHourInput.setEditable(false);
		    shiftStartMinuteInput.setEditable(false);
		    shiftStartComboBox.setEnabled(false);
		} else
		{
		    shiftStartHourInput.setEditable(true);
		    shiftStartMinuteInput.setEditable(true);
		    shiftStartComboBox.setEnabled(true);
		    shiftStartHourInput.setBackground(Color.white);
		    shiftStartMinuteInput.setBackground(Color.white);
		    shiftStartComboBox.setBackground(Color.white);
		}
	    }
	});
	chckbxUpdate.setBounds(10, 59, 67, 20);
	panel.add(chckbxUpdate);

	JPanel panel_1 = new JPanel();
	panel_1.setBackground(Color.BLACK);
	panel_1.setBounds(10, 115, 364, 67);
	frmTimeCalculator.getContentPane().add(panel_1);
	panel_1.setLayout(null);

	JLabel lblWhatTimeIs = new JLabel("What Time Is It Currently?");
	lblWhatTimeIs.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblWhatTimeIs.setForeground(Color.WHITE);
	lblWhatTimeIs.setHorizontalAlignment(SwingConstants.CENTER);
	lblWhatTimeIs.setBounds(85, 6, 200, 20);
	panel_1.add(lblWhatTimeIs);

	JLabel lblHours_1 = new JLabel("Hour");
	lblHours_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblHours_1.setForeground(Color.WHITE);
	lblHours_1.setBounds(85, 52, 50, 14);
	panel_1.add(lblHours_1);

	JLabel lblMinutes_1 = new JLabel("Minutes");
	lblMinutes_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblMinutes_1.setForeground(Color.WHITE);
	lblMinutes_1.setBounds(157, 52, 50, 14);
	panel_1.add(lblMinutes_1);

	JComboBox amPmComboBox = new JComboBox(amPmString);
	amPmComboBox.setBackground(Color.WHITE);
	amPmComboBox.setBounds(235, 26, 50, 20);
	panel_1.add(amPmComboBox);

	JLabel lblAmpm = new JLabel("AM/PM");
	lblAmpm.setForeground(new Color(255, 255, 255));
	lblAmpm.setHorizontalAlignment(SwingConstants.CENTER);
	lblAmpm.setBounds(235, 52, 50, 14);
	panel_1.add(lblAmpm);

	currentTimeHourInput = new JTextField();
	currentTimeHourInput.setColumns(10);
	currentTimeHourInput.setBounds(85, 26, 50, 20);
	panel_1.add(currentTimeHourInput);

	currentTimeMinutesInput = new JTextField();
	currentTimeMinutesInput.setColumns(10);
	currentTimeMinutesInput.setBounds(157, 26, 50, 20);
	panel_1.add(currentTimeMinutesInput);

	JPanel panel_2 = new JPanel();
	panel_2.setBackground(Color.BLACK);
	panel_2.setBounds(10, 194, 364, 67);
	frmTimeCalculator.getContentPane().add(panel_2);
	panel_2.setLayout(null);

	JLabel lblCumulativeUnsubmittedAccrued = new JLabel("Cumulative Unsubmitted Accrued Time");
	lblCumulativeUnsubmittedAccrued.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblCumulativeUnsubmittedAccrued.setForeground(Color.WHITE);
	lblCumulativeUnsubmittedAccrued.setHorizontalAlignment(SwingConstants.CENTER);
	lblCumulativeUnsubmittedAccrued.setBounds(59, 0, 251, 20);
	panel_2.add(lblCumulativeUnsubmittedAccrued);

	JLabel lblHours = new JLabel("Hours");
	lblHours.setHorizontalAlignment(SwingConstants.CENTER);
	lblHours.setForeground(Color.WHITE);
	lblHours.setBounds(120, 52, 50, 14);
	panel_2.add(lblHours);

	JLabel lblMinutes = new JLabel("Minutes");
	lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
	lblMinutes.setForeground(Color.WHITE);
	lblMinutes.setBounds(196, 52, 50, 14);
	panel_2.add(lblMinutes);

	cumulativeHoursInput = new JTextField();
	cumulativeHoursInput.setColumns(10);
	cumulativeHoursInput.setBounds(120, 24, 50, 20);
	panel_2.add(cumulativeHoursInput);

	cumulativeMinutesInput = new JTextField();
	cumulativeMinutesInput.setColumns(10);
	cumulativeMinutesInput.setBounds(195, 24, 50, 20);
	panel_2.add(cumulativeMinutesInput);

	JPanel panel_3 = new JPanel();
	panel_3.setBackground(Color.BLACK);
	panel_3.setBounds(10, 264, 364, 86);
	frmTimeCalculator.getContentPane().add(panel_3);
	panel_3.setLayout(null);

	JButton btnCalculate = new JButton("Calculate");
	btnCalculate.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		/*
		 * TODO: Get shift start time from save file, except on first run.
		 */
		shiftStartHour = shiftStartHourInput.getText();
		shiftStartMinute = shiftStartMinuteInput.getText();
		shiftStartAmPm = shiftStartComboBox.getSelectedIndex();
		if (shiftStartAmPm == 0)
		{
		    System.out.println("AM");
		} else if (shiftStartAmPm == 1)
		{
		    System.out.println("PM");
		}
		currentTimeHour = currentTimeHourInput.getText();
		currentTimeMinute = currentTimeMinutesInput.getText();
		currentTimeAmPm = amPmComboBox.getSelectedIndex();
		accruedTimeHours = cumulativeHoursInput.getText();
		accruedTimeMinutes = cumulativeMinutesInput.getText();

		/*
		 * TODO: Perform calculation here
		 */

		System.out.println("StartTimeHour: " + shiftStartHour);
		System.out.println("StartTimeMinute: " + shiftStartMinute);
		System.out.println("StartTimeAmPm: " + shiftStartAmPm);

		System.out.println("CurrentTimeHour: " + currentTimeHour);
		System.out.println("CurrentTimeMinute: " + currentTimeMinute);
		System.out.println("CurrentTimeAmPm: " + currentTimeAmPm);

		System.out.println("accruedTimeHours: " + accruedTimeHours);
		System.out.println("accruedTimeMinutes: " + accruedTimeMinutes);

		/*
		 * TODO: Update output
		 */
		AddHoursOutput.setText("test");
		addMinutesOutput.setText("test");

		if (chckbxUpdate.isSelected())
		{
		    // System.out.println("CheckBox is selected");
		    /*
		     * Save Time to save file
		     */

		}
	    }

	});
	btnCalculate.setBackground(new Color(220, 20, 60));
	btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnCalculate.setBounds(137, 6, 89, 30);
	panel_3.add(btnCalculate);

	AddHoursOutput = new JTextField();
	AddHoursOutput.setEditable(false);
	AddHoursOutput.setBounds(49, 46, 36, 20);
	panel_3.add(AddHoursOutput);
	AddHoursOutput.setColumns(10);

	JLabel lblAdd = new JLabel("Add");
	lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
	lblAdd.setForeground(Color.WHITE);
	lblAdd.setBounds(10, 45, 36, 20);
	panel_3.add(lblAdd);

	JLabel lblHoursAnd = new JLabel("hours, and ");
	lblHoursAnd.setHorizontalAlignment(SwingConstants.CENTER);
	lblHoursAnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblHoursAnd.setForeground(Color.WHITE);
	lblHoursAnd.setBounds(93, 45, 64, 20);
	panel_3.add(lblHoursAnd);

	addMinutesOutput = new JTextField();
	addMinutesOutput.setEditable(false);
	addMinutesOutput.setBounds(162, 46, 36, 20);
	panel_3.add(addMinutesOutput);
	addMinutesOutput.setColumns(10);

	JLabel lblMinutes_2 = new JLabel("minutes to your case time");
	lblMinutes_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblMinutes_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblMinutes_2.setForeground(Color.WHITE);
	lblMinutes_2.setBounds(203, 48, 151, 14);
	panel_3.add(lblMinutes_2);
	frmTimeCalculator.setBounds(100, 100, 400, 400);
	frmTimeCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
