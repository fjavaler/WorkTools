package caseTime;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class CaseTimeCalculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaseTimeCalculator window = new CaseTimeCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaseTimeCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/*
		 * Constants
		 */
		String[] amPmString = {"AM", "PM"};
		
		Integer[] hours = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12};
		
		Integer[] minutes = new Integer[60];
		for(int i = 0; i < minutes.length; i++)
		{
			minutes[i] = i;
		}
		/*
		 * end constants
		 */
		
		frame = new JFrame();
		frame.setForeground(Color.BLACK);
		frame.setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CaseTimeCalculator.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-information.png")));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 364, 85);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTimeCalculator = new JLabel("Time Calculator Tool");
		lblTimeCalculator.setForeground(Color.WHITE);
		lblTimeCalculator.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTimeCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeCalculator.setBounds(10, 7, 344, 25);
		panel.add(lblTimeCalculator);
		
		JLabel lblWhatTimeDid = new JLabel("What time did your shift start today?");
		lblWhatTimeDid.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatTimeDid.setForeground(new Color(255, 255, 255));
		lblWhatTimeDid.setBounds(10, 33, 344, 14);
		panel.add(lblWhatTimeDid);
		
		JComboBox<Integer[]> comboBox = new JComboBox(hours);
		comboBox.setBackground(SystemColor.activeCaption);
		comboBox.setBounds(96, 51, 40, 20);
		panel.add(comboBox);
		
		JComboBox<Integer[]> comboBox_1 = new JComboBox(minutes);
		comboBox_1.setBackground(SystemColor.activeCaption);
		comboBox_1.setBounds(165, 51, 40, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(amPmString);
		comboBox_2.setBackground(SystemColor.activeCaption);
		comboBox_2.setBounds(235, 51, 50, 20);
		panel.add(comboBox_2);
		
		JLabel label = new JLabel("Hour");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setBounds(96, 71, 39, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Minutes");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(162, 71, 45, 14);
		panel.add(label_1);
		
		JLabel lblAmpm_1 = new JLabel("AM/PM");
		lblAmpm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmpm_1.setForeground(Color.WHITE);
		lblAmpm_1.setBounds(235, 71, 46, 14);
		panel.add(lblAmpm_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 100, 364, 75);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWhatTimeIs = new JLabel("What Time Is It Currently?");
		lblWhatTimeIs.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWhatTimeIs.setForeground(Color.WHITE);
		lblWhatTimeIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatTimeIs.setBounds(85, 6, 200, 20);
		panel_1.add(lblWhatTimeIs);
		
		JLabel lblHours_1 = new JLabel("Hour");
		lblHours_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours_1.setForeground(Color.WHITE);
		lblHours_1.setBounds(95, 52, 40, 14);
		panel_1.add(lblHours_1);
		
		JLabel lblMinutes_1 = new JLabel("Minutes");
		lblMinutes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes_1.setForeground(Color.WHITE);
		lblMinutes_1.setBounds(162, 52, 45, 14);
		panel_1.add(lblMinutes_1);
		
		JComboBox comboBoxHours = new JComboBox(hours);
		comboBoxHours.setBackground(SystemColor.activeCaption);
		comboBoxHours.setBounds(96, 26, 40, 20);
		panel_1.add(comboBoxHours);
		
		JComboBox comboBoxMinutes = new JComboBox(minutes);
		comboBoxMinutes.setBackground(SystemColor.activeCaption);
		comboBoxMinutes.setBounds(165, 26, 40, 20);
		panel_1.add(comboBoxMinutes);
		
		JComboBox comboBoxAmPm = new JComboBox(amPmString);
		comboBoxAmPm.setBackground(SystemColor.activeCaption);
		comboBoxAmPm.setBounds(235, 26, 50, 20);
		panel_1.add(comboBoxAmPm);
		
		JLabel lblAmpm = new JLabel("AM/PM");
		lblAmpm.setForeground(new Color(255, 255, 255));
		lblAmpm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmpm.setBounds(235, 52, 46, 14);
		panel_1.add(lblAmpm);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 186, 364, 75);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCummulativeUnsubmittedAccrued = new JLabel("Cummulative Unsubmitted Accrued Time");
		lblCummulativeUnsubmittedAccrued.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCummulativeUnsubmittedAccrued.setForeground(Color.WHITE);
		lblCummulativeUnsubmittedAccrued.setHorizontalAlignment(SwingConstants.CENTER);
		lblCummulativeUnsubmittedAccrued.setBounds(72, 11, 223, 20);
		panel_2.add(lblCummulativeUnsubmittedAccrued);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setForeground(Color.WHITE);
		lblHours.setBounds(115, 59, 58, 14);
		panel_2.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setBounds(199, 59, 58, 14);
		panel_2.add(lblMinutes);
		
		JComboBox comboBoxHours2 = new JComboBox(hours);
		comboBoxHours2.setBackground(SystemColor.activeCaption);
		comboBoxHours2.setBounds(124, 34, 40, 20);
		panel_2.add(comboBoxHours2);
		
		JComboBox comboBoxMinutes2 = new JComboBox(minutes);
		comboBoxMinutes2.setBackground(SystemColor.activeCaption);
		comboBoxMinutes2.setBounds(209, 34, 40, 20);
		panel_2.add(comboBoxMinutes2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(10, 272, 364, 89);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBackground(new Color(220, 20, 60));
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalculate.setBounds(137, 6, 89, 23);
		panel_3.add(btnCalculate);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(49, 46, 36, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(162, 46, 36, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMinutes_2 = new JLabel("minutes to your case time");
		lblMinutes_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMinutes_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes_2.setForeground(Color.WHITE);
		lblMinutes_2.setBounds(203, 48, 151, 14);
		panel_3.add(lblMinutes_2);
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
