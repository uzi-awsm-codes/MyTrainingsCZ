/*Read student details from the User. The details would 
 include name, mark in the given order. The datatype for name 
 is string, mark is float.Create a hashmap. 
 The hashmap contains name as key and mark as value.
 1. If Mark is less than 60, then grade is FAIL.
2. If Mark is greater than or equal to 60, then grade is PASS.
Note: FAIL/PASS should be in uppercase.
Store the result in a new Hashmap with name as Key and 
grade as value. Define a static method 
static HashMap<String,String> findGrade(HashMap<String,Float>) in the UserMainCode and call the method
in main.
Sample Input:
3
A
80
B
59
C
90
Sample Output:
	A:PASS
	B:FAIL
	C:PASS*/

	
package com.training.demo;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class UserMainCode
{
	static HashMap<String,String> findGrade(HashMap<String,Float> inputMap)
	{
		HashMap<String,String> resultMap=new HashMap<>();
		String name;
		float mark;
		for(Entry<String,Float> entry:inputMap.entrySet())
		{
			name=entry.getKey();
			mark=entry.getValue();
			if(mark>=60)
			{
				resultMap.put(name, "PASS");
			}
			else
			{
				resultMap.put(name, "FAIL");
			}
		}
		return resultMap;
		
	}
}
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n;
		String name;
		float mark;
		HashMap<String,Float> input=new HashMap<>();
		n=scanner.nextInt();
		for(int i=1;i<=n;i++)
		{
			scanner.nextLine();
			name=scanner.nextLine();
			mark=scanner.nextFloat();
			input.put(name, mark);
			
		}
		//System.out.println(input);
		HashMap<String,String> result=UserMainCode.findGrade(input);
		for(Entry<String,String> entry:result.entrySet())
		{
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		

	}

}
