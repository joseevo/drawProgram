package drawProgram;

import org.junit.Assert;
import org.junit.Test;

public class CanvasUtilsTest {


	@Test
	public void testNoCanvas1() {
		char[][] arr = null;
		String[] input=null;
		Throwable exception = Assert.assertThrows(Exception.class, () -> {
			CanvasUtils.readInput(arr, input);
		});
		Assert.assertEquals("Please insert a valid input separated by [space]", exception.getMessage());
	}

	@Test
	public void testNoCanvas2() {
		char[][] arr = null;
		Throwable exception = Assert.assertThrows(Exception.class, () -> {
			CanvasUtils.display(arr);
		});
		Assert.assertEquals("Please insert a valid input separated by [space]", exception.getMessage());
	}

}
