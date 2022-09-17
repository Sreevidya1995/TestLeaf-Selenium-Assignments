package org.system;

public class Desktop extends Computer{
	public void desktopSize() {
		System.out.println(" The display size is : 15.6 inch");
	}

	public static void main(String[] args) {
		
		Desktop mySystem = new Desktop();
		mySystem.computerModel();
		mySystem.desktopSize();
		
	}
		
}
