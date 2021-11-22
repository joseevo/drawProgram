package drawProgram;

import java.util.Scanner;

public class CanvasUtils {

	private static Scanner scanner = new Scanner(System.in);

	public static char[][] readInput(char[][] arr) {
		String[] input;

		try {
			// reads the user's input and splits it into an array
			input = scanner.nextLine().split(" ");
		} catch (Exception ex) {
			throw new IllegalArgumentException("Please insert a valid input separated by [space]");
		}

		if (input[0].isEmpty() || input.length == 0) {
			throw new IllegalArgumentException("Please insert a valid input separated by [space]");
		}
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
		}
		catch(Exception ex) {
			throw new IllegalArgumentException("Please insert a valid input separated by [space]");
		}
		
		

		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j]);
			}

			System.out.println();
		}

	}

}
