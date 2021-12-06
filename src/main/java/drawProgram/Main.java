package drawProgram;

import static drawProgram.CanvasUtils.getInput;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char[][] arr = null;

		//CanvasUtils.instructions();
		//System.out.println("Enter command:");

		String input [] = getInput(scanner.nextLine());
		String firstInLine = input[0];

		while (!firstInLine.toUpperCase().equals("Q")) {

			try {
				arr = CanvasUtils.readInput(arr, input);
				CanvasUtils.display(arr);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			//System.out.println("Enter command:");
			input = getInput(scanner.nextLine());
			firstInLine = input[0];

		}

	}

}
