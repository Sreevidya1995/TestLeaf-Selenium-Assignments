package banks;

public class AxisBank extends BankInfo{

	public void deposit() {
		System.out.println("This is the overridden method/code to deposit money in the account - Exclusively for Axis bank");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		AxisBank customer = new AxisBank();
		
		customer.saving();
		customer.fixed();
		
		//overridden method
		customer.deposit();

	}

}
