package com.training.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class PriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		int result=0;
		if(o1.getPrice()==o2.getPrice())
			result=0;
		else if(o1.getPrice()<o2.getPrice())
			result=1;
		else
			result=-1;
		return result;
	}
}

class CodeComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		int result=0;
		if(o1.getCode()==o2.getCode())
			result=0;
		else if(o1.getCode()>o2.getCode())
			result=1;
		else
			result=-1;
		return result;
	}

}

public class ComparatorDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int code;
		String name;
		double price;
		List<Product> productList = new ArrayList<>();
		int n;
		System.out.println("Enter the number of products");
		n = scanner.nextInt();
		Product p;
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter product code,name and price");
			code = scanner.nextInt();
			scanner.nextLine();
			name = scanner.nextLine();
			price = scanner.nextDouble();
			p = new Product();
			p.setCode(code);
			p.setName(name);
			p.setPrice(price);
			productList.add(p);

		}
		System.out.println("Before sorting ");
		for (Product obj : productList) {
			System.out.println(obj);
		}
		System.out.println("Sorting in ascending order -- Name");
		Collections.sort(productList);
		for (Product obj : productList) {
			System.out.println(obj);
		}

		System.out.println("Sorting in descending order -- Price");
		Collections.sort(productList, new PriceComparator());
		for (Product obj : productList) {
			System.out.println(obj);
		}

		System.out.println("Sorting in ascending order -- Code");
		Collections.sort(productList, new CodeComparator());
		for (Product obj : productList) {
			System.out.println(obj);
		}

	}

}
