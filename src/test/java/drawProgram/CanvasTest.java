package drawProgram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CanvasTest {

private Canvas canvas;
	
	@Before
	public void initialization(){
		canvas = new Canvas();
	}
	
		
	@Test
    public void testValid() throws Exception {       
       String[] input = new String[] {"C", "4", "40"};
       canvas.draw(input);
    }

	@Test
	public void testNegative1() {
		String[] input = new String[] {"C", "-1", "40"};
	    Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
	    	canvas.draw(input);
	    });
	    Assert.assertEquals("width and height must be positive numbers", exception.getMessage());
	}
	
	@Test
	public void testNegative2() {
		String[] input = new String[] {"C", "2", "-5"};
	    Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
	    	canvas.draw(input);
	    });
	    Assert.assertEquals("width and height must be positive numbers", exception.getMessage());
	}
	
	
	@Test
	public void testEmpty1() {
		String[] input = new String[] {"C", "4"};
	    Throwable exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
	    	canvas.draw(input);
	    });
	    Assert.assertEquals("please insert a command, width and height value separated by [space]", exception.getMessage());
	}
	
	@Test
	public void testNonInt() {
		String[] input = new String[] {"C", "5.2", "6.8"};
	    Throwable exception = Assert.assertThrows(NumberFormatException.class, () -> {
	    	canvas.draw(input);
	    });
	    Assert.assertEquals("width and height must be integer numbers", exception.getMessage());
	}


}
