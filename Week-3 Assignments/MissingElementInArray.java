package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,7,5,8};

		List<Integer> data = new ArrayList<Integer>();  //Declaring List
		
		for (Integer eachItem : arr) {
			data.add(eachItem);							// Adding data array to List
		}
		
		Collections.sort(data);							// Sort the List	
		
		for (Integer eachItem : data) {
			if((data.get(eachItem-1)!= eachItem))		// check if the iterator variable is not equal to the array values respectively
			{
				System.out.println("The Missing element is :"+ (eachItem-1));	// print the number
				break;														// once printed break the iteration
			}
		}
	}
}
