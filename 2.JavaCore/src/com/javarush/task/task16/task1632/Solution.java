package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {


    }
    static {
        Nit1 nit1 = new Nit1();
        Nit2 nit2 = new Nit2();
        Nit3 nit3 = new Nit3();
        Nit4 nit4 = new Nit4();
        Nit5 nit5 = new Nit5();
        threads.add(nit1);
        threads.add(nit2);
        threads.add(nit3);
        threads.add(nit4);
        threads.add(nit5);
    }
    public static class Nit1 extends Thread implements Runnable {
        public void run(){
            while (true){}
        }
    }
    public static class Nit2 extends Thread implements Runnable{
        public void run(){
            try {
                while (true){
                    Thread.sleep(1);
                }
            }catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Nit3 extends Thread implements Runnable {
        public void run(){
            try {
                while(true){
                System.out.println("Ура");
                Thread.sleep(500);
                }
            } catch (InterruptedException e){}
        }
    }
    public static class Nit4  extends Thread implements Runnable, Message {
        public void run(){
            try {
                while (!isAlive()){
                    Thread.sleep(2);
                }
            } catch (InterruptedException e){}
        }
        public void showWarning(){
            interrupted();
        }
    }
    public static class Nit5 extends Thread implements Runnable {
        public void run(){
            try {
                String s;
                int i = 0;
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (!(s = reader.readLine()).equals("N")){
                     i = i + Integer.parseInt(s);
                }
                System.out.println(i);
            } catch (IOException e){}
        }
    }
}