package week1.day1;

public class FibonacciSeries {
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			int firstNum = 0, secondNum = 1, sum = 0;
			
			System.out.println(firstNum);
			System.out.println(secondNum);
			
			for (int i=1; i<=9; i++)
			{
				sum = firstNum+secondNum;
				System.out.println(sum);
				firstNum = secondNum ;
				secondNum = sum;
			}
	}
}



