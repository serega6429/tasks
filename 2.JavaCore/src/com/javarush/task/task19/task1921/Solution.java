package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();


    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String name = "";
            String string = "";
            Date birthday;
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            while (bufferedReader.ready()){
                string = bufferedReader.readLine();
                name = string.replaceAll(" \\d+ \\d+ \\d","");
                birthday = format.parse(string.replaceAll("[а-яА-ЯёЁa-zA-Z\\-]+ ",""));
                PEOPLE.add(new Person(name, birthday));
            }
            fileReader.close();
            bufferedReader.close();
        }catch (Exception e){}

    }
}
