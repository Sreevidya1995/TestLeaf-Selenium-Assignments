package week3.day2;

//import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesInString {

	public static void main(String[] args) {


//		Declare a String as PayPal India
		String name = "PayPal India";
				
//		Convert it into a character array
		char[] charArray = name.toCharArray();
		 
//		Declare a Set as charSet for Character
		Set<Character> charSet = new LinkedHashSet<Character>();
		
//		Iterate character array and add it into charSet
//      Check whether the character is space, if not add to charSet
//		Iterate using charSet
		for (Character eachChar: charArray)
		{
			if(eachChar!= ' ')
			{
			charSet.add(eachChar);
			}
		}
		
//		print each character for charSet
		System.out.println(charSet);
		
		

	}

}
