package com.training.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class NoOfDays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 2 dates");
		String s1 = scanner.next();
		String s2 = scanner.next();
		int n=scanner.nextInt();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		sd.setLenient(false);
		try {
			Date d1 = sd.parse(s1);
			Date d2 = sd.parse(s2);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(d1);
			c2.setTime(d2);
			long duration1 = c1.getTimeInMillis();
			long duration2 = c2.getTimeInMillis();
			int exp = Math.abs((int) ((duration1 - duration2) / (1000 * 3600 * 24)));
			System.out.println(exp/365);
			if(exp/365==n)
				System.out.println("true");
			else
				System.out.println("false");
		} catch (ParseException e) {
			System.out.println("Invalid date");
		}
	}

}

//01/01/2000-c1-ms
//01/01/2020-c1-ms
