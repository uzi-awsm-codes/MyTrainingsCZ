package com.training.collection;
import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		System.out.println("size of list="+list.size());
		list.add(new Integer(10));
		list.add(20);
		list.add("one");
		list.add(10);
		list.add(10);
		list.add(new Double(45.89));
		list.add(null);
		list.add("two");
		System.out.println("After adding size of list="+list.size());
		System.out.println("List ="+list);
		list.add("three");
		System.out.println("Index of 10="+list.indexOf(10));
		System.out.println("Index of last occurrence of 10="+list.lastIndexOf(10));
		System.out.println("List contains 10="+list.contains(10));
		System.out.println("List contains 30="+list.contains(30));
		System.out.println("third element="+list.get(2));
		
		list.set(3, "modified element");
		System.out.println("After changing 4th element ="+list);
		list.add(2,"new element");
		System.out.println("After inserting new element in 2nd index="+list);
		ArrayList list1=new ArrayList();
		list1.add("one");
		list1.add("two");
		System.out.println("List 1="+list1);
		list1.addAll(list);
		System.out.println("After appending list to list1 "+list1);
		list1.remove(3);
		System.out.println("After removing 4th element "+list1);
		list1.clear();
		System.out.println("After clearing list1 "+list1);

	}

}
