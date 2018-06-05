package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream fileWriter = new FileOutputStream(bufferedReader.readLine());
            PrintStream printStream = System.out;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream1 = new PrintStream(byteArrayOutputStream);
            System.setOut(printStream1);
            testString.printSomething();
            System.setOut(printStream);
            bufferedReader.close();
            fileWriter.write(byteArrayOutputStream.toByteArray());
            System.out.println(byteArrayOutputStream.toString());
            fileWriter.close();
        }catch (IOException e){}
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

