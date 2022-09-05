package week1.day2;

public class RemoveDuplicates {
	
	/*
	 * Pseudo code 
	 * a) Use the declared String text as input	String text = "We learn java basics as part of java sessions in java week1";		
	 * b) Initialize an integer variable as count	  
	 * c) Split the String into array and iterate over it 
	 * d) Initialize another loop to check whether the word is there in the array
	 * e) if it is available then increase and count by 1. 
	 * f) if the count > 1 then replace the word as "" 
	 * g) Displaying the String without duplicate words	
	 */
	
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		//int count = 0;
		String[] strArray = text.split(" ");
		
		for(int i=0; i<strArray.length; i++)
		{
			for(int j=i+1; j<strArray.length-1; j++)
			{
				if(strArray[i].equalsIgnoreCase(strArray[j]))
				{
					//count++;
					strArray[j] = "";
		
				}
			}
		}
		
		for(int i=0; i<strArray.length; i++)
		{
			System.out.print(" "+ strArray[i]);
		}
		
	}

}
