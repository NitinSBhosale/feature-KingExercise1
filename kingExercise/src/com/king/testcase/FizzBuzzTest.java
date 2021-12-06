package com.king.testcase;

import com.king.multiThreading.FizzBuzz;
import org.junit.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class FizzBuzzTest {

    FizzBuzz sut;

    Thread threadBuzz;
    Thread threadFizz;
    Thread threadFizzBuzz;
    Thread threadNumber;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    private static final String EXPECTED_OUTPUT = "1\r\n" +
            "2\r\n" +
            "Fizz\r\n" +
            "4\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "7\r\n" +
            "8\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n" +
            "11\r\n" +
            "Fizz\r\n" +
            "13\r\n" +
            "14\r\n" +
            "FizzBuzz\r\n";



    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void FifteenExpectedOutputIsEquals() {

        final int input = 15;
        sut = new FizzBuzz(input);

        startFizzBuzzThreads();
        Assert.assertEquals(EXPECTED_OUTPUT+"", outputStreamCaptor+"");
    }

    private void startFizzBuzzThreads() {

        threadBuzz = new Thread(() -> {
            try {
                sut.buzz(() -> System.out.println("Buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadFizz = new Thread(() -> {
            try {
                sut.fizz(() -> System.out.println("Fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadFizzBuzz = new Thread(() -> {
            try {
                sut.fizzbuzz(() -> System.out.println("FizzBuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadNumber = new Thread(() -> {
            try {
                sut.number((n) -> System.out.println(n));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadFizz.start();
        threadBuzz.start();
        threadFizzBuzz.start();
        threadNumber.start();

    }

}
