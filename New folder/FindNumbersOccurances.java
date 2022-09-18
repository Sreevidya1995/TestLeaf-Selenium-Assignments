package week3.day2;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FindNumbersOccurances {
	
	/* Psuedcode:
	 * 1) Create Map -> TreeMap
	 * 2) For loop -> each number -> add to the map
	 * 3) If it is exist -> update it with + 1
	 * Else -> new entry with 1 as value
	 */
	
	public static void main(String[] args) {
		int[] input = {2,3,5,6,3,2,1,4,2,1,6,-1};
		
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();  // Declaring Tree Map
		
		for (Integer eachItem : input) {
			map.put(eachItem, map.getOrDefault(eachItem, 0)+1);			// Adding the array items to the map along with the count of duplicates
		}
		
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		
		for (Entry<Integer, Integer> eachItem : entrySet) {
		System.out.println(eachItem.getKey()+"-->"+eachItem.getValue());   // Print the map as per format
		}

	}

}
