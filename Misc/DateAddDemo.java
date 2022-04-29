/*Read date as input in dd/MM/yyyy format and add 7 days with the input date and return the day name
 of the new date.
 */
package com.training.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import java.text.ParseException;

public class DateAddDemo {

	public static void main(String[] args) {
		String inputDate;
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE");
			sdf.setLenient(false);
			System.out.println("Enter date in dd/MM/yyyy format");
			inputDate = scanner.next();
			// converting string date to Date object
			Date d = sdf.parse(inputDate);
			System.out.println("Date =" + d);
			//assigning Date to Calendar for date manipulation
			calendar.setTime(d);
			calendar.add(Calendar.DATE, 3);
			//convert Calendar to Date for formatting
			Date newDate = calendar.getTime();
			System.out.println("New date="+newDate);
			String dayName = sdf1.format(newDate);
			System.out.println(dayName);
		} catch (ParseException e) {
			System.out.println("Invalid Date");
		}

	}
}
