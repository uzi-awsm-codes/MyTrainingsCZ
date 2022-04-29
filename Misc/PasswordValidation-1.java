/*Given a method with a password in string format as input. 
 * Write code to validate the password using following rules:
- Must contain at least one digit
- Must contain at least one of the following special characters @, #, $
# Length should be between 6 to 20 characters.*/
package com.training.demo;

import java.util.Scanner;

public class PasswordValidation {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the password");
		String password = scanner.next();
		/*
		 * if(password.matches(".*[0-9]{1,}.*") && password.matches(".*[@#$]{1}") &&
		 * password.length()>=6 && password.length()<=20) System.out.println("valid");
		 * else System.out.println("Invalid");
		 */
		boolean flag = false;
		if (password.length() >= 8) {
			if (password.contains("#") || password.contains("@") || password.contains("_")) {
				char c = password.charAt(0);
				if (Character.isAlphabetic(c)) {
					char ch = password.charAt(password.length() - 1);

					if ((Character.isAlphabetic(ch)) || (Character.isDigit(ch))) {
						if (password.matches(".*[0-9]{1,}.*") || password.matches(".*[a-zA-Z]{1,}.*")) {
							flag = true;
						}
					}
				} else {
					flag = false;
				}
			}
		}
		if (flag)
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}

}
