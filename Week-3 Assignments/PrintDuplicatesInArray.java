package week3.day2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {

		int[] array = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		
		Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();  // Declaring Linked Hash Map
		
		for (Integer eachItem : array) {
			map.put(eachItem, map.getOrDefault(eachItem, 0)+1);			// Adding the array items to the map along with the count of duplicates
		}
		
		System.out.println(map);  // Print the map
		
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();  		// Adding the hash map key-value pairs to a set
		
		for (Entry<Integer, Integer> eachItem : entrySet) {  			// Accessing the value separately and checking if the item has duplicates
			if(eachItem.getValue()>=2) {
			 System.out.println("The array item "+ eachItem.getKey() + " has " + eachItem.getValue() + " duplicates");
			 
			 // Since only the first array item with duplicates is required. In case all the items with duplicates is required then remove this line
			 break;														
			}
		}
	}

}
