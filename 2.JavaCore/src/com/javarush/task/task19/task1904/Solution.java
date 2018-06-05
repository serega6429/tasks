package com.javarush.task.task19.task1904;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

}


    public static class PersonScannerAdapter implements  PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter (Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        public Person read(){
            String[] strings = fileScanner.nextLine().split(" ");
            SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
            Date date= new Date();
            try {
                date = ft.parse(strings[3] + "-" + strings[4] + "-" + strings[5]);
            } catch (ParseException e){}
            Person person = new Person(strings[1], strings[2], strings[0], date);
            return person;
        }
        public void close(){
            fileScanner.close();
        }

    }
}
