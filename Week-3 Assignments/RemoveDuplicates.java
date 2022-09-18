package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		 
		String text = "We learn java basics as part of java sessions in java week1";		

		String[] strings = text.split(" ");
		
		Set<String> stringSet = new LinkedHashSet<String>();
		
		//loading the string array into a Linked Hash set
		for (String eachstring : strings) {
			stringSet.add(eachstring);
		}
		
		//Printing the Linked Hash set
		System.out.println(stringSet);
		
		//Convert Set back to String
		
		String editedText = "";
		
		for (String stringEdit : stringSet) {
			editedText = editedText +" "+stringEdit;
		}
		
		System.out.println(editedText);
	}

}
