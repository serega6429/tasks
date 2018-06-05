package com.javarush.task.task17.task1711;

import com.javarush.task.task17.task1710.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat ddate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int i = 1;
try {


    switch (args[0]) {
        case "-u":
            while (args[i] != null) {
                try {
                    Date date = new Date();
                    date = ddate.parse(args[i + 3]);
                    Sex sex;
                    sex = args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE;
                    synchronized (allPeople) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setBirthDay(date);
                        person.setName(args[i + 1]);
                        person.setSex(sex);
                    }
                } catch (Exception e) {
                }
                i = i + 4;
            }
            break;
        case "-c":
            while (args[i] != null) {
                try {
                    Date date = new Date();
                    date = ddate.parse(args[i + 2]);
                    synchronized (allPeople) {
                        if (args[i + 1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], date));
                        } else {
                            allPeople.add(Person.createFemale(args[i], date));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                } catch (Exception e) {
                }
                i = i + 3;
            }
            break;
        case "-d":
            while (args[i] != null) {
                synchronized (allPeople) {
                    Person personForremove = allPeople.get(Integer.parseInt(args[i]));
                    personForremove.setBirthDay(null);
                    personForremove.setName(null);
                    personForremove.setSex(null);
                }
                i++;
            }
            break;
        case "-i":
            while (args[i] != null) {
                synchronized (allPeople) {
                    Person personSout = allPeople.get(Integer.parseInt(args[i]));
                    SimpleDateFormat dateSout = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    String sexSout = personSout.getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.println(personSout.getName() + " " + sexSout + " " + dateSout.format(personSout.getBirthDay()));
                }
                i++;
            }
            break;
    }
} catch (Exception e){

}
    }
}
