package drawProgram;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char[][] arr = null;

		CanvasUtils.instructions();

		System.out.println("Enter command:");

		while (true) {

			try {
				arr = CanvasUtils.readInput(arr);
				CanvasUtils.display(arr);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			System.out.println("Enter command:");

		}

	}

}
