package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileReader fileReader = new FileReader(reader.readLine());
            reader.close();
            String world = "";
            int count = 0;
            while (fileReader.ready()){
                int data = fileReader.read();
                world += (char)data;
                if (world.matches("world\\W")){
                    count++;
                    world="";
                } else if (!world.matches("\\w+")){
                    world = "";
                }
            }
            System.out.println(count);
            fileReader.close();
        } catch (IOException e) {
        }

    }
}
