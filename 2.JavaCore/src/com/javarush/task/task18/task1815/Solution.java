package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        private ATableInterface aTableInterface;
        public TableInterfaceWrapper (ATableInterface aTableInterface){
             this.aTableInterface = aTableInterface;

        }
        public void setModel(List rows){
            System.out.println(rows.size());
            aTableInterface.setModel(rows);
        }

        public void setHeaderText(String newHeaderText){
            aTableInterface.setHeaderText(newHeaderText);
        }

        public String getHeaderText(){
            return aTableInterface.getHeaderText().toUpperCase();
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}