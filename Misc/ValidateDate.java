/*Obtain a date string in the format dd/MM/yyyy. Write code to 
validate the given date against the given format. If the date is valid return 1 ,else
return -1.*/

package com.training.demo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class UserMainCode1 {
	public static int validate(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		int res=-1;
		

			try {
				Date d1 = sdf.parse(s);
				res=1;
			} catch (ParseException e) {
			res = -1;
			}
		 
		return res;
	}
}

public class ValidateDate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter date");
		String s = scanner.next();
		int res = UserMainCode1.validate(s);
		if (res == 1)
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}

}
