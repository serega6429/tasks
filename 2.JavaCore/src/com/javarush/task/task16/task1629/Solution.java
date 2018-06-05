package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread implements Runnable {
        ArrayList<String> aa = new ArrayList<>();
        public void run(){
            try {
                aa.add(reader.readLine());
                aa.add(reader.readLine());
                aa.add(reader.readLine());
            } catch (Exception e){}
        }
        public void printResult(){
            System.out.println(aa.get(0) + " " + aa.get(1) + " " + aa.get(2));
        }
    }
}
