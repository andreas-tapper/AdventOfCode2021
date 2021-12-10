package com.adventofcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testExampleOne() throws IOException {
            var path = Paths.get("src","test","resources","example01.txt").toFile().getAbsolutePath();

        App.main(new String[]{"1", path});

        var content = outContent.toString().split("\n");
        var answer = Arrays.stream(content)
                .filter(x -> x.startsWith("Answer is:"))
                .findFirst()
                .orElse("");

        if(answer.length() == 0) fail("Could not find answer.");

        assertEquals("7", answer.substring(11));
    }

    @Test
    public void testProblemOne() throws IOException {
        var path = Paths.get("src","test","resources","input01.txt").toFile().getAbsolutePath();

        App.main(new String[]{"1", path});

        var content = outContent.toString().split("\n");
        var answer = Arrays.stream(content)
                .filter(x -> x.startsWith("Answer is:"))
                .findFirst()
                .orElse("");

        if(answer.length() == 0) fail("Could not find answer.");

        assertEquals("1602", answer.substring(11));
    }

    @Test
    public void testExampleTwo() throws IOException {
        var path = Paths.get("src","test","resources","example01.txt").toFile().getAbsolutePath();

        App.main(new String[]{"2", path});

        var content = outContent.toString().split("\n");
        var answer = Arrays.stream(content)
                .filter(x -> x.startsWith("Answer is:"))
                .findFirst()
                .orElse("");

        if(answer.length() == 0) fail("Could not find answer.");

        assertEquals("5", answer.substring(11));
    }

    @Test
    public void testPartTwo() throws IOException {
        var path = Paths.get("src","test","resources","input01.txt").toFile().getAbsolutePath();

        App.main(new String[]{"2", path});

        var content = outContent.toString().split("\n");
        var answer = Arrays.stream(content)
                .filter(x -> x.startsWith("Answer is:"))
                .findFirst()
                .orElse("");

        if(answer.length() == 0) fail("Could not find answer.");

        assertEquals("1633", answer.substring(11));
    }
}
