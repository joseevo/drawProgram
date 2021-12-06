package drawProgram;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SpringerNatureTest {
    private final IoCapturer ioCapturer = new IoCapturer();
    private static final String lineSeparator = System.lineSeparator();

    @After
    public void tearDown() {
        ioCapturer.stop();
    }

    @Test
    public void createsEmptyCanvas() {
        ioCapturer.setInputLines("C 20 4", "Q");
        Main.main(new String[]{});
        String expectedOutput =
                "----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------";
        assertThat(ioCapturer.output(), containsString(expectedOutput));
    }

    @Test
    public void drawsVerticalLine() {
        ioCapturer.setInputLines("C 20 4", "L 1 2 1 4", "Q");
        Main.main(new String[]{});
        String expectedOutput =
                "----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|x                   |" + lineSeparator +
                "|x                   |" + lineSeparator +
                "|x                   |" + lineSeparator +
                "----------------------";
        assertThat(ioCapturer.output(), containsString(expectedOutput));
    }
}

/**
 * Please don't worry about this class - we will concentrate on the test class above in the pairing exercise.
 */
class IoCapturer {
    public class StringInputStream extends ByteArrayInputStream {

        public StringInputStream(String input) {
            super(input.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        public synchronized int read(byte[] b, int off, int len) {
            stringStream.println(); // to compensate for Scanner dropping the new line when it does a readLine
            return super.read(b, off, len);
        }
    }

    public class StringPrintStream extends PrintStream {
        public StringPrintStream() {
            super(new ByteArrayOutputStream());
        }

        @Override
        public String toString() {
            return out.toString();
        }
    }

    private StringPrintStream stringStream = new StringPrintStream();
    private PrintStream originalOut = System.out;
    private InputStream originalIn = System.in;

    public IoCapturer() {
        System.setOut(stringStream);
    }

    public void setInputLines(String... inputLines) {
        String input = String.join("\n", inputLines);
        System.setIn(new StringInputStream(input));
    }

    public void stop() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    public String output() {
        String output = stringStream.toString();
        originalOut.println(output);
        return output;
    }
}

