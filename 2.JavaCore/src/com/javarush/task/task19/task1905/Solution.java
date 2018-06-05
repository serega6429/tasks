package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    public static void main(String[] args) {

    }
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }
        public String getCountryCode() {
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (pair.getValue().equals(customer.getCountryName())) {
                    return pair.getKey();
                }
            }
            return "a";
        }

        public String getCompany(){
            return customer.getCompanyName();
        }

        public String getContactFirstName(){
            return contact.getName().replaceFirst(".*,\\s", "");
        }

        public String getContactLastName(){
            return contact.getName().replaceFirst(",.*", "");
        }
        public String getDialString() {
            return contact.getPhoneNumber().replace("+","callto://+").replace("(","").replace(")","").replace("-","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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