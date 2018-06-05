package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import javax.security.sasl.SaslServer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean a = true;
            String b;
            while (a){
                b = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(b);
                if (fileInputStream.available() < 1000){
                    fileInputStream.close();
                    a = false;
                    throw new DownloadException();
                }
            }
        } catch (Exception e){}
    }

    public static class DownloadException extends Exception {

    }
}
