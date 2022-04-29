/*Sample Input 1:
123-456-7895
Sample Output 1:
Valid number format*/
//aBc-123-4567
package com.training.demo;

import java.util.Scanner;

public class ValidNumber {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//String pattern="[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}";
		String pattern="[a-zA-Z]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}";
		System.out.println("Enter the number to validate");
		String number=scanner.next();
//		if(number.matches(pattern))
//		 {
//		System.out.println("Valid");
//		 }
//		else
//		{
//			System.out.println("Invalid");
//		}
		boolean flag=false;
		boolean flag1=true;
		String tokens[]=number.split("-");
		if(tokens[0].length()==3 && tokens[1].length()==3 &&tokens[2].length()==4)
		{
			flag=true;
		}
		if(flag)
		{
		for(String s:tokens)
		{
			String token=s;
			for(int i=0;i<s.length();i++)
			{
				if(!Character.isDigit(s.charAt(i)))
				{
					flag1=false;
					break;
				}
			}
		
		}
		}
		}
	}

}
