package com.javarush.task.task17.task1719;

/**
 * @author Sergey Yusupov on 12.10.2017
 */
public class eeee {
    public static void main(String[] args) {
        new eeee().smusl();
    }

    private void smusl(){
        int m = 6200000;
        int n = 6300000;
        int snm = 0;
        int[] mn = new int[n - m];
        for (int i = m; i < n + 1; i++) {
            snm += sFunction(i);
            //mn[i -m] = i;
        }
        System.out.println(snm);
    }


    private int sFunction(int m) {
        boolean g = false;
        int i = 0;
        while (!g) {
            if (fact(i) % m == 0) {
                g = true;
            } else {
                i++;
            }
        }
        return i;
    }

    public int fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }
}

