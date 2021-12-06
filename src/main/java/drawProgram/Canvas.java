package drawProgram;

public class Canvas extends Geometry {

	// maximum size of the number of columns or lines inserted (to prevent an
	// OutOfMemoryError)
	private static final int arrayMaxSize = 4000;

	// number of instructions that should be received by the user
	private int inputSize = 3;

	// global width and height variables
	private int lines;
	private int columns;

	// method that validates the user's input

	@Override
	public void checkInput(String[] input) {
		// validates if the input has size 3 (command, width and height)
		if (input.length != inputSize) {

			throw new IllegalArgumentException("please insert a command, width and height value separated by [space]");
		}

		// validates if the width and height passed are integer numbers
		try {

			// declares the variables with the width and height
			columns = Integer.parseInt(input[1]);
			lines = Integer.parseInt(input[2]);

		} catch (NumberFormatException ex) {

			throw new NumberFormatException("width and height must be integer numbers");

		}

		// validates if the input does not pass a certain size
		if (lines > arrayMaxSize && columns > arrayMaxSize) {

			throw new NumberFormatException("The values inserted are too big, please insert smaller values");
		}

		// validates if the values inserted for the width and height are positive
		// numbers
		if (lines <= 0 || columns <= 0) {

			throw new IllegalArgumentException("width and height must be positive numbers");
		}

		// increments the width and height by 2 for the design of the canvas frame
		lines += 2;
		columns += 2;

	}

	@Override
	public char[][] drawY(char[][] arr) {
		char point = '|';

		for (int i = 0; i < lines; i++) {

			arr[i][0] = point;
			arr[i][columns-1] = point;
		}

		return arr;
	}

	@Override
	public char[][] drawX(char[][] arr) {
		char point = '-';

		for (int i = 0; i < columns; i++) {

			arr[0][i] = point;
			arr[lines-1][i] = point;
		}

		return arr;
	}

	@Override
	public char[][] draw(String[] input) {
		
		checkInput(input);

		// creates an multi index array with the size inserted by the user (+ the canvas
		// frame)

		char[][] arr = new char[lines][columns];

		checkInput(input);

		arr = drawY(arr);
		arr = drawX(arr);

		return arr;
	}

}
