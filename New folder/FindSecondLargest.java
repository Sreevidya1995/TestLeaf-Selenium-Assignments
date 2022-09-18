package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {
	
	/*
	 Pseudo Code:
	 1) Arrange the array in ascending order
	 2) Pick the 2nd element from the last and print it
	 */
	
	public static void main(String[] args) {
		
		int[] data = {3, 2, 11, 4, 6, 7, 53, 216, 99, 8, 5};
		
		List<Integer> dataList = new ArrayList<Integer>();  //Declaring List
		
		for (Integer eachItem : data) {
			dataList.add(eachItem);				//Adding data array to List
		}
		
		Collections.sort(dataList);   // Sorting the List
		
		System.out.println("The Second largest number in the list is : " +dataList.get(dataList.size()-2));   //Printing using the index

	}

}
