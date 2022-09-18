package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class FindIntersection {
	
	public static void main (String[] args) {
 /*
	* c) Declare for loop iterator from 0 to array length
	* d) Declare a nested for another array from 0 to array length
	* e) Compare Both the arrays using a condition statement
	* f) Print the first array (shoud match item in both arrays)*/
		
		int[] array1 = {3,2,11,4,6,7};
		int[] array2 = {1,2,8,4,9,7};
		
		//Declare 2 Lists
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		for (Integer eachInteger : array1) {
			set1.add(eachInteger);					//Adding array1 items to set1
		}	
		
		for (Integer eachInteger : array2) {
			set2.add(eachInteger);					//Adding array2 items to set2
		}
  
		set1.retainAll(set2);  //Retains All will retain the common elements in list1 and list2 removing the remaining items
		
		System.out.println(set1); //Printing the set1 (Retained values)
		
	}
}
