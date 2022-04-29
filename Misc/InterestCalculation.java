/*1. Read account details from the User. The details would include id, DOB (date of birth) and amount in 
 * the given order. The datatype for id is string, DOB is string and amount is integer.
2. You decide to build two hashmaps. The first hashmap contains user id as key and DOB as value, 
and the second hashmap contains same user ids as key and amount as value.
3. Rate of interest as on 01/01/2015:
    a. If the age greater than or equal to 60 then interest rate is 10% of Amount.
    b.If the age less then to 60 and greater than or equal to 30 then interest rate is 7% of Amount.
    c. If the age less then to 30 interest rate is 4% of Amount.
4. Revised Amount= principle Amount + interest rate.
5.  Write a function calculateInterestRate which takes the above hashmaps as input and returns the treemap (id is key,
revised amount as value) as output.
as output
Sample Input 1:
4
SBI-1010
20-01-1987
10000
SBI-1011
03-08-1980
15000
SBI-1012
05-11-1975
20000
SBI-1013
02-12-1950
30000
Sample Output 1:
SBI-1010:10400
SBI-1011:16050
SBI-1012:21400
SBI-1013:33000
*/

package com.training.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class UserMainCode3 {
	public static TreeMap<String, Integer> calculateInterestRate(HashMap<String, String> hm,
			HashMap<String, Integer> hm1) {
		int year = 0, amount = 0;
		double dis = 0;
		String now = "01/01/2015";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		Iterator<String> it = hm.keySet().iterator();

		while (it.hasNext()) {
			String id = it.next();
			String dob = hm.get(id);
			amount = hm1.get(id);

			try {
				Date d1 = sdf.parse(dob);
				Date d2 = sdf1.parse(now);
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
				c1.setTime(d1);
				c2.setTime(d2);
				long duration1 = c1.getTimeInMillis();
				long duration2 = c2.getTimeInMillis();
				int days = Math.abs((int) ((duration1 - duration2) / (1000 * 3600 * 24)));
				year = days / 365;
				if (year >= 60)
					dis = 0.1 * amount + amount;
				else if (year < 60 && year >= 30)
					dis = 0.07 * amount + amount;
				else
					dis = 0.04 * amount + amount;
				tm.put(id, (int) dis);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		return tm;
	}

}

public class InterestCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> hm = new HashMap<String, String>();
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
	
		int s = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < s; i++) {
			
			
			//sc.nextLine();
			String id = sc.nextLine();
			String dob=sc.nextLine();
			int amount=Integer.parseInt(sc.nextLine());
			hm.put(id, dob);
			hm1.put(id, amount);
		}
		TreeMap<String, Integer> tm = UserMainCode3.calculateInterestRate(hm, hm1);
		Iterator<Entry<String,Integer>> it = tm.entrySet().iterator();
		Entry<String,Integer> entry=null;
		while (it.hasNext()) {
			entry=it.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
