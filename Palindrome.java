package week1.day2;

public class Palindrome {
	
	/*
	 * Pseudo Code
	 * a) Declare A String value as"madam"
	 * b) Declare another String rev value as ""
	 * c) Iterate over the String in reverse order
	 * d) Add the char into rev
	 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
	 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
	 */
	
	public static void main(String[] args) {
		
		String str = "rotatoR";
		String rev = "";
		int length = str.length();
			
		for(int i=length-1; i>=0; i--)
		{
			rev= rev + str.charAt(i);
		}
		
		if(rev.equalsIgnoreCase(str))
		{
			System.out.println("The given string is a Palindrome");
		}
		else
		{
			System.out.println("The given string is not a Palindrome");
		}
	}

}
