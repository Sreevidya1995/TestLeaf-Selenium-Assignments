package week3.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MostDuplicateElementInArray {
	

	public static void main(String[] args) {
		String input = "abbababnjjifdjdksmnmnsjdhfvnnailsbb" ;
		
		char[] charArray = input.toCharArray(); // Converting string to character array
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();  // Declaring Tree Map
		
		for (Character eachItem : charArray) {
			map.put(eachItem, map.getOrDefault(eachItem, 0)+1);			// Adding the array items to the map along with the count of duplicates
		}
		
		System.out.println(map);  //verification to print the map
		
		Set<Entry<Character, Integer>> entrySet = map.entrySet();  // converting to Entry Set
		
		char maxDuplicated = ' ';									//to store max duplicated char
		int maxValue = 0;											
		
		for (Entry<Character, Integer> eachItem : entrySet) {
			if(eachItem.getValue()>maxValue)
			{
				maxDuplicated = eachItem.getKey();							
				maxValue=eachItem.getValue();								
			}
		}
		
		System.out.println("The maximum duplicated value is : "+ maxDuplicated);

	}

}
