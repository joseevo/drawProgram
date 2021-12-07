package drawProgram;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {
	
	private char[][] arr1;
	private Canvas canvas = new Canvas(arr1);
	private String[] inputCanvas = new String[] { "C", "20", "60" };
	private char[][] arr = canvas.draw(inputCanvas);
	private Rectangle rectangle = new Rectangle(arr);

	@Test
	public void testValid() throws Exception {
		String[] inputRectangle = new String[] { "R", "1", "1", "2", "3" };
		rectangle.draw(inputRectangle);
	}

	@Test
	public void testNoCanvas() {
		char[][] arr = null;
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			Rectangle rectangle = new Rectangle(arr);
		});
		Assert.assertEquals("Please create a Canvas", exception.getMessage());
	}

	@Test
	public void testEmpty1() {
		String[] inputLine = new String[] { "R", "1", "1", "4" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			rectangle.draw(inputLine);
		});
		Assert.assertEquals("please insert command, x1, y1, x2, y2", exception.getMessage());
	}

	@Test
	public void testNonInt() {
		String[] inputLine = new String[] { "R", "4", "10", "10", "5.2" };
		Throwable exception = Assert.assertThrows(NumberFormatException.class, () -> {
			rectangle.draw(inputLine);
		});
		Assert.assertEquals("x1,y1,x2,y2 must be integer numbers", exception.getMessage());
	}

	@Test
	public void testOutScope() {
		String[] inputLine = new String[] { "R", "4", "10", "6", "70" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			rectangle.draw(inputLine);
		});
		Assert.assertEquals("Please insert a point inside the canvas scope", exception.getMessage());
	}

	@Test
	public void testNegative1() {
		String[] inputLine = new String[] { "R", "-4", "10", "4", "20" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			rectangle.draw(inputLine);
		});
		Assert.assertEquals("x1,y1,x2,y2 must be positive numbers", exception.getMessage());
	}

	@Test
	public void testNegative2() {

		String[] inputLine = new String[] { "R", "4", "-10", "6", "-20" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			rectangle.draw(inputLine);
		});
		Assert.assertEquals("x1,y1,x2,y2 must be positive numbers", exception.getMessage());
	}

	@Test
	public void testRectangle() {
		String[] inputLine = new String[] { "R", "1", "1", "3", "3" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			rectangle.draw(inputLine);
		});
		Assert.assertEquals("Sides are equal", exception.getMessage());
	}

	@Test
	public void testSameCoordinates() {
		String[] inputLine = new String[] { "R", "1", "2", "1", "5" };
		Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
			rectangle.draw(inputLine);
		});
		Assert.assertEquals("Please insert different horizontal and vertical coordinates to create a rectangle",
				exception.getMessage());
	}


}
