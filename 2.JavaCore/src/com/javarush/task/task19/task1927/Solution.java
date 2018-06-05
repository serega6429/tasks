package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream1);
        testString.printSomething();
        System.setOut(printStream);
        int count = 0;
        byte[] bytes = byteArrayOutputStream.toByteArray();
        for (int i = 0; i < byteArrayOutputStream.size(); i++){
            System.out.print((char) bytes[i]);
            if ((char)bytes[i] == 10)
                count++;
            if (count % 2 == 0 && (count != 0)){
                System.out.println("JavaRush - курсы Java онлайн");
                count = 0;
            }
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
