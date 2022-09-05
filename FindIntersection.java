package week1.day2;

//import java.util.Arrays;

public class FindIntersection {
	
	/*
	 * Pseudo Code
	 * a) Declare An array for {3,2,11,4,6,7};	 
	 * b) Declare another array for {1,2,8,4,9,7};
	 * c) Declare for loop iterator from 0 to array length
	 * d) Declare a nested for another array from 0 to array length
	 * e) Compare Both the arrays using a condition statement
	 * f) Print the first array (should match item in both arrays)
	 */

	public static void main(String[] args) {
		
		int[] array1 = {3,2,11,4,6,7};
		int[] array2 = {1,2,8,4,9,7};
		
		
		int length1 = array1.length;
		int length2 = array2.length;
		
		int[] intersection = new int[length1];
		
		//Arrays.sort(array1);
		//Arrays.sort(array2);
		
		for (int i=0,k=0; i<length1; i++)
		{
			for (int j=0; j<length2; j++)
			{
				if(array1[i]==array2[j])
				{
					intersection[k]= array1[i];
					k++;
				}
			}	
		}
		
		//Arrays.sort(intersection);
				
		for (int i=0; i<intersection.length; i++)
		{
			System.out.print(intersection[i]+ " ");
		}		

	}

}
