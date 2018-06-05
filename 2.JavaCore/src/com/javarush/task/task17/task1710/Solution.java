package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat ddate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = new Date();

        switch (args[0]){
            case "-u":
                try {
                    date = ddate.parse(args[4]);
                } catch (Exception e){}
                Sex sex;
                sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setBirthDay(date);
                person.setName(args[2]);
                person.setSex(sex);
            break;
            case "-c":
                try {
                    date = ddate.parse(args[3]);
                } catch (Exception e){}
                if ( args[2].equals("м")){
                    allPeople.add(Person.createMale(args[1], date));
                } else {
                    allPeople.add(Person.createFemale(args[1], date));
                }
                System.out.println(allPeople.size() - 1);
                break;
            case "-d":
                Person personForremove = allPeople.get(Integer.parseInt(args[1]));
                personForremove.setBirthDay(null);
                personForremove.setName(null);
                personForremove.setSex(null);
                break;
            case "-i":
                Person personSout = allPeople.get(Integer.parseInt(args[1]));
                SimpleDateFormat dateSout = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String sexSout = personSout.getSex().equals(Sex.MALE) ? "м" : "ж";
                System.out.println(personSout.getName() + " " + sexSout + " " + dateSout.format(personSout.getBirthDay()));
                break;
            default:
                break;
            }
        }
    }

