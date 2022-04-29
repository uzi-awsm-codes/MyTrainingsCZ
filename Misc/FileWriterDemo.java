package com.training.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		Scanner sc=new Scanner(System.in);
		String str;
		try
		{
		fw=new FileWriter("test2.txt",true);
		System.out.println("enter a line of text");
		str=sc.nextLine();
		fw.write(str);
		fw.flush();
		System.out.println("data stored successfully");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		

	}

}
