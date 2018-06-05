package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream  extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException, IOException {
        super(file.getFD());
        this.original = file;

    }


    @Override
    public void write(int i) throws IOException {
        original.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        original.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        original.write(bytes, i, i1);
    }

    @Override
    public void close() throws IOException {
        original.flush();
        original.write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }
}
