package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            String name;
            Double d;
            Double max = Double.MIN_NORMAL;
            HashMap<String, Double> spisok = new HashMap<>();
            while (bufferedReader.ready()){
                string = bufferedReader.readLine();
                name = string.replaceAll(" .*","");
                d = Double.parseDouble(string.replaceAll(".* ", ""));
                if (spisok.containsKey(name)){
                    spisok.put(name, d + spisok.get(name));
                } else {
                    spisok.put(name, d);
                }
            }
            fileReader.close();
            for (Double g: spisok.values()) {
                if (g > max)
                    max = g;
            }
            ArrayList<String> hg = new ArrayList<>();
            for (String s: spisok.keySet()) {
                if (max.equals(spisok.get(s)))
                    hg.add(s);
            }
            Collections.sort(hg);
            for ( int i = 0 ; i < hg.size(); i++) {
                System.out.println(hg.get(i));
            }
        } catch (IOException e){}

    }
}
