package drawProgram;

public class InputReader {
	
	//method that validates if the input isn't empty and uses the first character from the user's input to return the intended subclass
		public static Geometry action (String[] input, char[][] arr) {
			
			if(input.length==0) {
				throw new IllegalArgumentException ("Please insert an action");
			}
			
			
			switch (Character.toUpperCase(input[0].charAt(0))) {
				
			case 'C':
				return new Canvas();
				
			case 'L':
				return new Line(arr);
				
			case 'R':
				return new Rectangle(arr);
				
			case 'Q':
				System.out.println("Exit");
				System.exit(0);

				
			default:
				
				throw new IllegalArgumentException ("Please insert a valid action ([C] - New Canvas, [L] - New Line, [R] - New Rectangle, [Q] - Quit");
			}
					
		}

}
