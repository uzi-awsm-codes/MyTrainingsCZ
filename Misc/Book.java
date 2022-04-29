package com.pack1;

public class Book {
	private int bookCode;
	private String author;
	private String title;
	public void setData(int code,String aname,String bname)
	{
		bookCode=code;
		author=aname;
		title=bname;
	}
	public void display()
	{
		System.out.println("Code :"+bookCode);
		System.out.println("Title :"+title);
		System.out.println("Author :"+author);
	}

}
