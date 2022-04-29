package com.training.exception;
//try,catch,finally -
//try,catch 
//try,finally
public class Test {

	public static void main(String[] args) {
		double a,b,c;
		try
		{
		a=Double.parseDouble(args[0]);
		b=Double.parseDouble(args[1]);
		c=a/b;
		System.out.println("Result= "+c);
		}
//		catch(Exception e)
//		{
//			//System.out.println(e.getMessage());
//			System.out.println("Invalid input");
//			//e.printStackTrace();
//		}
		finally
		{
			System.out.println("executed always");
		}
		


	}

}
