package drawProgram;

import org.junit.Assert;
import org.junit.Test;

public class LineTest {
	
	private char[][] arr1;
	private Canvas canvas = new Canvas(arr1);
	private String[] inputCanvas = new String[] { "C", "4", "40" };
	private char[][] arr = canvas.draw(inputCanvas);
	private Line line = new Line(arr);

	@Test
	public void testValid() throws Exception {
		String[] inputLine = new String[] { "L", "4", "10", "4", "20" };
		line.draw(inputLine);
	}

	@Test
	public void testNoCanvas() {
		char[][] arr=null;
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			Line line = new Line(arr);
		});
		Assert.assertEquals("Please create a Canvas", exception.getMessage());
	}

	@Test
	public void testEmpty1() {
		String[] inputLine = new String[] { "L", "4", "10", "4" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			line.draw(inputLine);
		});
		Assert.assertEquals("please insert command, x1, y1, x2, y2", exception.getMessage());
	}

	@Test
	public void testNonInt() {
		String[] inputLine = new String[] { "L", "4", "10", "4", "5.2" };
		Throwable exception = Assert.assertThrows(NumberFormatException.class, () -> {
			line.draw(inputLine);
		});
		Assert.assertEquals("x1,y1,x2,y2 must be integer numbers", exception.getMessage());
	}

	@Test
	public void testOutScope() {
		String[] inputLine = new String[] { "L", "4", "10", "4", "50" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			line.draw(inputLine);
		});
		Assert.assertEquals("Please insert a point inside the canvas scope", exception.getMessage());
	}

	@Test
	public void testDiagonal() {
		String[] inputLine = new String[] { "L", "2", "10", "4", "30" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			line.draw(inputLine);
		});
		Assert.assertEquals("please insert an horizontal or vertical line", exception.getMessage());
	}

	@Test
	public void testNegative1() {
		String[] inputLine = new String[] { "L", "-4", "10", "-4", "20" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			line.draw(inputLine);
		});
		Assert.assertEquals("x1,y1,x2,y2 must be positive numbers", exception.getMessage());
	}

	@Test
	public void testNegative2() {

		String[] inputLine = new String[] { "L", "4", "-10", "4", "-20" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			line.draw(inputLine);
		});
		Assert.assertEquals("x1,y1,x2,y2 must be positive numbers", exception.getMessage());
	}
	
	@Test
	public void testSamePoint() {

		String[] inputLine = new String[] { "L", "4", "10", "4", "10" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			line.draw(inputLine);
		});
		Assert.assertEquals("Please insert different point coordinates to create a line", exception.getMessage());
	}


}
