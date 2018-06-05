package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            ArrayList<Character> cha = new ArrayList<>();
            while (fileInputStream.available() > 0){
                char a = (char)(fileInputStream.read());
                if (((a > 64) && (a < 91)) || ((a > 96 ) && (a < 123))) {
                    cha.add(a);
                }
            }
            System.out.println(cha.size());
            fileInputStream.close();
        } catch (IOException e){}
    }
}
