package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));

            while (in.ready()) {
                String[] readerWord = in.readLine().split(" ");
                for (int i = 0; i < readerWord.length; i++) {
                    if (readerWord[i].matches(".*\\d.*")) {
                        out.write(readerWord[i] + " ");
                    }
                }
            }
            in.close();
            out.close();
        } catch (Exception e){}
    }
}

