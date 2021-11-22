package drawProgram;

import org.junit.Assert;
import org.junit.Test;

public class InputReaderTest {

	private char[][] arr = new char[][] { { ' ', 'X' }, { 'X', 'X' }, { 'X', ' ' } };

	@Test
	public void testValid1() throws Exception {
		String[] input = new String[] { "C", "4", "40" };
		char[][] arr = new char[][] {};
		InputReader.action(input, arr);
	}

	@Test
	public void testValid2() throws Exception {
		String[] input = new String[] { "L", "1", "1", "1", "3" };
		InputReader.action(input, arr);
	}

	@Test
	public void testValid3() throws Exception {
		String[] input = new String[] { "R", "1", "1", "4", "4" };
		InputReader.action(input, arr);
	}

	@Test
	public void testNull() {
		String[] input = new String[] {};
		char[][] arr = new char[][] {};
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			InputReader.action(input, arr);
		});
		Assert.assertEquals("Please insert an action", exception.getMessage());

	}
	
	@Test
	public void testInvalidCommand() {
		String[] input = new String[] {"P", "1", "1", "4", "4"};
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			InputReader.action(input, arr);
		});
		Assert.assertEquals("Please insert a valid action ([C] - New Canvas, [L] - New Line, [R] - New Rectangle, [Q] - Quit", exception.getMessage());

	}

}
