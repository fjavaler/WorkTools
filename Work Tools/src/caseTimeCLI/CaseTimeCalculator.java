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
	startTime = JOptionPane.showInputDialog("Please enter your start time today in military time:");

	// Get and convert current Zulu time to MST
	DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US)
		.withZone(ZoneId.systemDefault());
	Instant instant = Instant.now();
	String output = formatter.format(instant);
	System.out.println("formatter: " + formatter + " with zone: " + formatter.getZone() + " and Locale: " + formatter.getLocale() );
	System.out.println("instant: " + instant );
	System.out.println("output: " + output );
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
	if(newArr[1].equals("PM"))
	{
	    newArr[0] = Integer.toString(Integer.parseInt(newArr[0]) + 12);
	}
	for (String s: newArr)
	{
	    System.out.println(s);
	}
    }
}
