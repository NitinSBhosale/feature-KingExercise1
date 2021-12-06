package com.king.multiThreading;


import java.util.function.IntConsumer;

public class FizzBuzz {
    private int i;
    private int counter=1;
    public FizzBuzz(int k) {
        i = k;
    }


    public void fizz(Runnable printFizz) throws InterruptedException {
        while( counter <= i )
        {
            synchronized(FizzBuzz.class){
                if( counter<= i)
                    if( counter%3==0 && counter%5!=0 )
                    {
                        printFizz.run();
                        counter++;
                    }
            }
        }
    }


    public void buzz( Runnable printBuzz ) throws InterruptedException {
        while( counter<=i ){
            synchronized( FizzBuzz.class ){
                if( counter<=i )
                    if( counter%3!=0 && counter%5==0 )
                    {
                        printBuzz.run();
                        counter++;
                    }
            }
        }
    }


    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while( counter<=i ){
            synchronized( FizzBuzz.class ){
                if( counter<=i )
                    if( counter%5==0 && counter%3==0 ){
                        printFizzBuzz.run();
                        counter++;
                    }
            }
        }
    }


    public void number(IntConsumer printNumber) throws InterruptedException {
        while( counter<=i ){
            synchronized(FizzBuzz.class){
                if( counter<=i )
                    if( counter%5!=0 && counter%3!=0 ){
                        printNumber.accept(counter);
                        counter++;
                    }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final int input = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(input);

        Thread threadBuzz = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("Buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadFizz = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("Fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread threadFizzBuzz = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("FizzBuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread threadNumber = new Thread(() -> {
            try {
                fizzBuzz.number((n) -> System.out.println(n));
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
