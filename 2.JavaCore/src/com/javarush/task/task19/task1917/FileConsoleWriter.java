package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    public static void main(String[] args) {


    }
    public FileConsoleWriter(String var1) throws IOException {
        fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(String var1, boolean var2) throws IOException {
        fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(File var1) throws IOException {
        fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(File var1, boolean var2) throws IOException {
        fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(FileDescriptor var1) {
        fileWriter = new FileWriter(var1);
    }
    public void write(char[] cbuf, int off, int len) throws IOException{
        System.out.println(new String(cbuf, off, len));
        fileWriter.write(cbuf, off, len);
    }
    public void write(int c) throws IOException{
        System.out.println(c);
        fileWriter.write(c);
    }
    public void write(String str) throws IOException{
        System.out.println(str);
        fileWriter.write(str);
    }
    public void write(String str, int off, int len){
        try {
            System.out.println(new String(str.toCharArray(), off, len));
            fileWriter.write(str, off, len);
        } catch (IOException e){}
    }
    public void write(char[] cbuf) throws IOException{
        System.out.println(cbuf);
        fileWriter.write(cbuf);
    }
    public void close() throws IOException{
        fileWriter.close();
    }

}
