package caseTimeCLI;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.time.Instant;

import javax.swing.JOptionPane;

public class CaseTimeCalculator
{
    private static String startTime;
    private static String currentTime;

    public static void main(String[] args)
    {
	startTime = JOptionPane.showInputDialog("Please enter your start time today in military time: ");
	System.out.println("startTime: " + startTime);
	// Get and convert current Zulu time to MST
	DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US)
		.withZone(ZoneId.systemDefault());
	Instant instant = Instant.now();
	String output = formatter.format(instant);
	currentTime = output;
	String[] splitArr = output.split(" ");
	String[] newArr = new String[2];
	for(int i = 0; i < splitArr.length; i++)
	{
	    if(i == 1)
	    {
		newArr[0] = splitArr[i];
	    }
	    else if(i == 2)
	    {
		newArr[1] = splitArr[i];
	    }
	}
	String currentTime = "";
	if(newArr[1].equals("PM"))
	{
	    String timeNoColon = newArr[0].replace(":", "");
	    int timeAddedInt = Integer.parseInt(timeNoColon) + 1200;
	    String timeAddedString = "" + timeAddedInt;
	    for(int i = 0; i < timeAddedString.length(); i++)
	    {
		char c = timeAddedString.charAt(i);
		currentTime = currentTime + c;
	    }
	    System.out.println("currentTime: " + currentTime);
	}
	String timeLogged = JOptionPane.showInputDialog("How many hours have you logged already? Format: hhmm\n(e.g. if you have already logged 6 hours and 15 minutes, enter 0615");
	System.out.println("timeLogged: " + timeLogged);
	int totalTimeWorkedAlready = Integer.parseInt(currentTime) - Integer.parseInt(startTime);
	String totalTimeWorkedAlreadyString = "" + totalTimeWorkedAlready;
	System.out.println("totalTimeWorkedAlready: " + totalTimeWorkedAlreadyString);
	int finalTime = totalTimeWorkedAlready - Integer.parseInt(timeLogged);
	
	//TODO: time to add minutes need to be converted from base 100 to base 60
	String timeToAdd = "" + finalTime;
	System.out.println("timeToAdd: " + timeToAdd);
	String finalDisplayedTime = "";
	if (timeToAdd.length() == 3)
	{
	    finalDisplayedTime = "0" + timeToAdd;
	}
	else if(timeToAdd.length() == 4)
	{
	    finalDisplayedTime = timeToAdd;
	}
	String hours = "";
	String minutes = "";
	for (int i = 0; i < finalDisplayedTime.length(); i++)
	{
	    if(i == 0 || i == 1)
	    {
		hours += finalDisplayedTime.charAt(i);
	    }
	    else if(i == 2 || i == 3)
	    {
		minutes += finalDisplayedTime.charAt(i);
	    }
	}
	if(hours.charAt(0) == '0')
	{
	    hours = hours.substring(1);
	}
	System.out.println("Add " + hours + " hours and " + minutes + " minutes to your case time.");
    }
}