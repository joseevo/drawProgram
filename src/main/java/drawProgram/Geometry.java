package drawProgram;

//Abstract class that serves as a blueprint for the geometric elements
public abstract class Geometry {
	
	public abstract void checkInput(String[] input);
	
	public abstract char[][] drawX(char[][] arr);
	
	public abstract char[][] drawY(char[][] arr);
		
	public abstract char[][] draw(String[] input);
		

}
