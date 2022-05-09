package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = sc.nextInt();
        }
        for (int mask = 1; mask < (1 << n); mask ++) {
            ArrayList <Integer> b = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < n; i ++) {
                if ((mask & (1 << i)) != 0) {
                    b.add(a[i]);
                    sum += a[i];
                }
            }
            if (sum == 0){
                System.out.println(b);
            }
        }
    }
}