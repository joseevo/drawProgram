package drawProgram;

//import java.util.Scanner;

public class CanvasUtils {

	//private static Scanner scanner = new Scanner(System.in);

	public static char[][] readInput(char[][] arr, String[] input) {
		arr = InputReader.action(input, arr).draw(input);

		return arr;
	}

	// displays the content of the array
	public static void display(char[][] arr) {

		int lines;
		int columns;

		try {
			lines = arr.length;
			columns = arr[1].length;
		} catch (Exception ex) {
			throw new IllegalArgumentException("Please insert a valid input separated by [space]");
		}

		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j]== 0 ? " ": arr[i][j]);

			}

			System.out.print("\r\n");

		}

	}

	public static void instructions() {

		System.out.print("C w h - Should create a new canvas of width w and height h.\r\n\n" + "L x1 y1 x2 y2 - "
				+ "Should create a new line from (x1,y1) to (x2,y2) . Currently only\r\n"
				+ "horizontal or vertical lines are supported. Horizontal and vertical lines will be\r\n"
				+ "drawn using the x character.\r\n\n" + "R x1 y1 x2 y2 - "
				+ "Should create a new rectangle, whose upper left corner is (x1,y1) and\r\n"
				+ "lower right corner is (x2,y2) . Horizontal and vertical lines will be drawn\r\n"
				+ "using the x character.\r\n\n" + "Q - Should quit the program.\r\n\n");
	}

	public static String[] getInput(String line) {
		String[] input;
		try {
			// reads the user's input and splits it into an array
			input = line.split(" ");
		} catch (Exception ex) {
			throw new IllegalArgumentException("Please insert a valid input separated by [space]");
		}
		return input;
	}

}
