package abstraction;

public class Automation extends MultipleLanguage{
	//Remaining unimplemented methods from the Interface classes
	
	public void java() {
		System.out.println("This is a Java Code");
		System.out.println();
	}

	public void selenium() {
		System.out.println("This is a Selenium code");
		System.out.println();
	}

	@Override
	public void ruby() {
		System.out.println("This is a Ruby code");
		System.out.println();
	}

	public static void main(String[] args) {
		
		Automation example = new Automation();
		
		example.python();
		example.java();
		example.selenium();
		example.ruby();
				
	}

	

}
