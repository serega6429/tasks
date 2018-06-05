package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
            }
            bufferedWriter.write(aa.replaceAll("\\.", "!"));
            bufferedWriter.close();
            bufferedReader.close();

        } catch (IOException e) {}
    }
}
