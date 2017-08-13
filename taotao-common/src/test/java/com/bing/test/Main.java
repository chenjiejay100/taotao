package com.bing.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int a[] = new int[n];
        int b[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        List<Integer> myList = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);


        for (int i = 1; i <= n; i++) {
            int difmin = Integer.MAX_VALUE;
            int difsum = 0;
            if (i % 2 == 1) {
                for (int j = i / 2; j < n - i / 2; j++) {
                    int flag = i / 2;
                    int nex = i / 2;
                    while (flag > 0) {
                        flag--;
                        nex++;
                        difsum = difsum + a[j] - a[flag] + a[nex] - a[j] + (b[j] - b[flag] + b[nex] - b[j]);
                    }
                    if (difsum < difmin)
                        difmin = difsum;
                }
                myList.add(difmin);

            }

            if (i % 2 == 0) {
                for (int j = i / 2; j <= n - i / 2; j++) {
                    int left = i / 2;
                    int right = i / 2 - 1;
                    int next = i / 2;
                    while (left > 0) {
                        left--;
                        difsum = difsum + a[j] - a[left] + b[j] - b[left];
                    }
                    while (right > 0) {
                        right--;
                        next++;
                        difsum = difsum + a[next] - a[j] + b[next] - b[j];
                    }
                    if (difsum < difmin)
                        difmin = difsum;

                }
                myList.add(difmin);

            }
        }
        for (int h = 0; h < myList.size(); h++)
            if (h == myList.size() - 1)
                System.out.print(myList.get(h));
            else
                System.out.print(myList.get(h) + " ");
    }
}