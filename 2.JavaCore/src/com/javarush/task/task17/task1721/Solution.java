package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String f1 = reader.readLine();
            String f2 = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new FileReader(f1));
            BufferedReader reader2 = new BufferedReader(new FileReader(f2));
            String line;
            while ((line = reader1.readLine()) != null){
                allLines.add(line);
            }
            while ((line = reader2.readLine()) != null){
                forRemoveLines.add(line);
            }
            new Solution().joinData();
        }catch (Exception e){}
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
                allLines.removeAll(forRemoveLines);
        } else {
                allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }
    }
}
