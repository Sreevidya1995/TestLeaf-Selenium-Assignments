package abstraction;

public abstract class MultipleLanguage implements Language, TestTool{
  
	public void python() {
		System.out.println("This is Python Code");
		System.out.println();
	}
	
	//Unimplemented method 
	
	public abstract void ruby();
	
}
