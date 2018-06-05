package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String f1 = reader.readLine();
            String f2 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(f1);
            FileOutputStream fileOutStream1 = new FileOutputStream(f2);
            int count = fileInputStream.available();
            byte[] buffer = new byte[count];
            while (fileInputStream.available() > 0)
            {
                int  a = fileInputStream.read(buffer);
            }
            for (int i = buffer.length; i > 0; i--){
                fileOutStream1.write(buffer[i-1]);
            }
            fileInputStream.close();
            fileOutStream1.close();
        } catch (Exception e){}
    }
}
