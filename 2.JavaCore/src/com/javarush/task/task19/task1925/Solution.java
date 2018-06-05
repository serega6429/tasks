package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(args[0]));
            FileWriter fileWriter = new FileWriter(args[1]);
            String string;
            String aa = "";
            while (bufferedReader1.ready()) {
                string = bufferedReader1.readLine();
                String[] a = string.split(" ");

                for (int i = 0; i < a.length; i++) {
                    if (a[i].length() > 6) {
                        if (aa.equals("")) {
                            aa = a[i];
                        } else {
                            aa = aa + "," + a[i];
                        }
                    }
                }
            }
            fileWriter.write(aa);
            fileWriter.close();
            bufferedReader1.close();
        }catch (IOException e){}
    }
}
