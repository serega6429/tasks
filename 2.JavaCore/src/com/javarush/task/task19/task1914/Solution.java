package com.javarush.task.task19.task1914;

/* 
Решаем пример
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
        String [] a = byteArrayOutputStream.toString().split(" ");
        int aa = Integer.parseInt(a[0]);
        int bb = Integer.parseInt(a[2]);
        int cc;
        if (a[1].equals("+")){
            cc = aa + bb;
        } else if (a[1].equals("-")){
            cc = aa - bb;
        } else {
            cc = aa * bb;
        }
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " = " + cc);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

