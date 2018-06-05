package com.javarush.task.task16.task1630;

import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
     static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (Exception e){}
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fileName = "";
        ArrayList<String> aa = new ArrayList<>();
        String itog = "";
        public void setFileName (String fullFileName){
            this.fileName = fullFileName;
        }
        public String getFileContent(){
            return itog;
        }


        public void start (){
            run();
        }


        public void run() {
            String bb = "";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while ((bb = reader.readLine()) != null){
                    aa.add(bb);
                }
                reader.close();
            } catch (Exception e){}
            while (!aa.isEmpty()){
                itog = itog + " " + aa.get(0);
                aa.remove(0);
            }
            itog = itog.replaceAll("^ ", "");
        }
    }
    //add your code here - добавьте код тут
}
