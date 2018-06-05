package com.javarush.task.task17.task1719;

import java.util.ArrayList;

/**
 * @author Sergey Yusupov on 11.10.2017
 */
//Дано равенство, в котором цифры заменены на буквы:
//syx + rvsv = ryrs
//Найдите сколько у него решений, если различным буквам соответствуют различные цифры (ведущих нулей в числе не бывает).
public class dddd {
    public static void main (String[] args){
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        int k = 0;
        int l = 0;
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                for (int v = 0; v < 10; v++){
                    for (int s = 1; s < 10; s++){
                        for (int r = 1; r < 10; r++){
                            num1 = Integer.parseInt(String.valueOf(s) + String.valueOf(y) + String.valueOf(x));
                            num2 = Integer.parseInt(String.valueOf(r) + String.valueOf(v) + String.valueOf(s) + String.valueOf(v));
                            sum = Integer.parseInt(String.valueOf(r) + String.valueOf(y) + String.valueOf(r) + String.valueOf(s));
                            int sNum = Integer.parseInt(String.valueOf(s));
                            int yNum = Integer.parseInt(String.valueOf(y));
                            int xNum = Integer.parseInt(String.valueOf(x));
                            int rNum = Integer.parseInt(String.valueOf(r));
                            int vNum = Integer.parseInt(String.valueOf(v));
                            if (num1 + num2 == sum){
                                k++;
                                //System.out.println("k= " + k);
                                //System.out.println(num1 + " + " + num2 + " = " + sum );

                                if (sNum !=yNum && yNum != xNum && xNum != rNum && rNum != vNum){
                                    l++;
                                    System.out.println("l= " + l);
                                    System.out.println("sNum = " + sNum + " yNum = " + yNum + " xNum = " + xNum + " rNum = " + rNum + " vNum = " + vNum);
                                } else {
                                    //System.out.println("!!!!!");
                                    //System.out.println("sNum = " + sNum + " yNum = " + yNum + " xNum = " + xNum + " rNum = " + rNum + " vNum = " + vNum);
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}