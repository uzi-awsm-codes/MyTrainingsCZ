package com.training.date;

import java.util.Calendar;
import java.util.Scanner;

public class FindNoOfDays {

	public static void main(String[] args) {
		int month,year;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter month and year");
		month=scanner.nextInt();
		year=scanner.nextInt();
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.DATE,1);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.YEAR, year);
		System.out.println(calendar.getActualMaximum(Calendar.DATE));
		//System.out.println(calendar.getActualMinimum(Calendar.DATE));
		//System.out.println(calendar.getActualMaximum(Calendar.MONTH));

	}

}
