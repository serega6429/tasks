package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String file = bufferedReader.readLine();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader);
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader1.ready()){
                arrayList.add(new StringBuilder(bufferedReader1.readLine()).reverse().toString());
            }
            bufferedReader.close();
            fileReader.close();
            for (int i = 0; i < arrayList.size(); i++){
                System.out.println(arrayList.get(i));
            }
        } catch (IOException e){}
    }
}
