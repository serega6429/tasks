package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                FileReader fileReader = new FileReader(reader.readLine());
                FileWriter fileWriter = new FileWriter(reader.readLine());
                reader.close();
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String aa = "";
                while (bufferedReader.ready()) {
                    int data = bufferedReader.read();
                    aa += (char) data;
                    if (aa.matches("^\\d+\\s") || aa.matches("\\s\\d+\\s")) {
                        bufferedWriter.write(aa.replaceFirst("\\s", "") + " ");
                    } else if (!aa.matches("[0-9]+")) {
                        aa = "";
                    }
                }
                    bufferedWriter.close();
                    bufferedReader.close();

            } catch (IOException e) {}
    }
}
