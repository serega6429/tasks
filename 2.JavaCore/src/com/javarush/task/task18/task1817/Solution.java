package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            ArrayList<Character> cha = new ArrayList<>();
            int countSpace = 0;
            while (fileInputStream.available() > 0){
                char a = (char)(fileInputStream.read());
                cha.add(a);
                if (a == 32) {
                    countSpace++;
                }
            }
            System.out.format("%.2f", 1.0*countSpace/cha.size()*100);
            fileInputStream.close();
        } catch (IOException e){}
    }
}
