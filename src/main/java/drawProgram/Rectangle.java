package drawProgram;

public class Rectangle extends Geometry {

	private char[][] arr;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int inputSize = 5;

	public Rectangle(char[][] arr) {
		// validates if the canvas has been created
		if (arr == null) {

			throw new IllegalArgumentException("Please create a Canvas");
		}

		this.arr = arr;

	}

	@Override
	public void checkInput(String[] input) {
		// validates if the input has size 5 (command, x1,y1,x2,y2)
		if (input.length != inputSize) {

			throw new IllegalArgumentException("please insert command, x1, y1, x2, y2");
		}

		// validates if the x1,y1,x2,y2 passed are integer numbers
		try {
			// declares the variables with the x1,y1,x2,y2 values
			x1 = Integer.parseInt(input[1]);
			y1 = Integer.parseInt(input[2]);
			x2 = Integer.parseInt(input[3]);
			y2 = Integer.parseInt(input[4]);

		} catch (Exception ex) {

			throw new NumberFormatException("x1,y1,x2,y2 must be integer numbers");

		}

		// validates if the points inserted are inside the canvas
		if ((x1 > arr.length - 2) || (x2 > arr.length - 2) || (y1 > arr[1].length - 2) || (y2 > arr[1].length - 2))
			throw new IllegalArgumentException("Please insert a point inside the canvas scope");

		// validates if the values inserted for the width and height are positive
		// numbers
		if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0) {

			throw new IllegalArgumentException("x1,y1,x2,y2 must be positive numbers");
		}

		// validates if the values inserted don't have equal sides
		if (x2 - x1 == y2 - y1) {

			throw new IllegalArgumentException("Sides are equal");
		}

		// validates if the horizontal or the vertical coordinates are different
		if (x1 == x2 || y1 == y2) {

			throw new IllegalArgumentException(
					"Please insert different horizontal and vertical coordinates to create a rectangle");
		}

		if (x1 > x2) {
			int xTemp = x2;
			x2 = x1;
			x1 = xTemp;
		}

		if (y1 > y2) {
			int xTemp = y2;
			y2 = y1;
			y1 = xTemp;
		}

	}

	@Override
	public char[][] drawX(char[][] arr) {
		char point = 'x';

		for (int i = x1; i <= x2; i++) {

			arr[y1][i] = point;
			arr[y2][i] = point;
		}

		return arr;

	}

	@Override
	public char[][] drawY(char[][] arr) {
		char point = 'x';

		for (int i = y1; i <= y2; i++) {

			arr[i][x1] = point;
			arr[i][x2] = point;
		}

		return arr;
	}

	@Override
	public char[][] draw(String[] input) {
		checkInput(input);

		arr = drawX(arr);
		arr = drawY(arr);

		return arr;
	}

}
