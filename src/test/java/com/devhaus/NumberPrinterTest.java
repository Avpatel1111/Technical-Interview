package com.devhaus;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    NumberPrinter numberPrinter = new NumberPrinter();

    /*
     * start - 1, end - 21, it will test numbers multiple of 3, 5, 7, 3 and 5, 3 and 7
     */
    @Test
    public void Test_printNumbers_Positive() {
        // ARRANGE
        String[] expectedArray = new String[]{"Devhaus", "Learning", "Devhaus", "Model", "Devhaus", "Learning", "Devhaus", "Model",
                "Devhaus Learning", "Devhaus", "Learning", "Devhaus Model"};

        // ACT
        numberPrinter.printNumbers(1, 21);

        // ASSERT
        String consoleOutput = outContent.toString();
        String[] actualArray = consoleOutput.split("\n");

        assertArrayEquals(expectedArray, actualArray);
    }

    /*
     * start - 100, end - 105, it will test numbers multiple of 3, 5, 7, 3 and 5, 3 and 7
     */
    @Test
    public void Test_printNumbers_multiple3_5_7_Positive() {
        // ARRANGE
        String[] expectedArray = new String[]{"Learning", "Devhaus", "Devhaus Learning Model"};

        // ACT
        numberPrinter.printNumbers(100, 105);

        // ASSERT
        String consoleOutput = outContent.toString();
        String[] actualArray = consoleOutput.split("\n");

        assertArrayEquals(expectedArray, actualArray);
    }

    /*
    * start number is greater than end number. It shouldn't process the request.
    */
    @Test
    public void Test_printNumbers_start_GT_end_Negative() {
        // ACT
        numberPrinter.printNumbers(10, 1);

        // ASSERT
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.isEmpty());
    }

    /*
     * start number is zero. It shouldn't process the request.
     */
    @Test
    public void Test_printNumbers_start_zero_Negative() {
        // ACT
        numberPrinter.printNumbers(0, 1);

        // ASSERT
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.isEmpty());
    }

    /*
     * end number is zero. It shouldn't process the request.
     */
    @Test
    public void Test_printNumbers_end_zero_Negative() {
        // ACT
        numberPrinter.printNumbers(1, 0);

        // ASSERT
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.isEmpty());
    }
}
