package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter (IncomeData incomeData){
            this.data = incomeData;
        }

        public String getCompanyName(){
            return data.getCompany();
        }
        public String getCountryName(){
            return countries.get(data.getCountryCode());
        }
        public String getName(){
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }
        public String getPhoneNumber(){
            String a = String.valueOf(data.getPhoneNumber());
            while (a.length() < 10) {
                a = "0" + a;
            }
            String[] strings = a.split("");
            String ret = "+" + data.getCountryPhoneCode() + "(" + strings[0] + strings[1] + strings[2] + ")";
            for (int i = 3 ; i < 10; i++){
                ret = ret + strings[i];
                if (i == 5 || i == 7){
                    ret = ret + "-";
                }
            }
            return ret;
        }


    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}