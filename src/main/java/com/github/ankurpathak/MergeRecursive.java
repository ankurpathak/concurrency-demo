package com.github.ankurpathak;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MergeRecursive {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            String choice = "y";
            do {
                System.out.print("Enter number of elements: ");
                int n = in.nextInt();
                int a[] = new int[n];
                System.out.println("Enter elements: ");
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }

                mergeSortRecursive(a, 0, a.length - 1);
                System.out.printf("Sorted array is: %s%n", Arrays.toString(a));

                System.out.print("Enter y to try sort more: ");
                choice = in.next();

            } while (Objects.equals(choice, "y"));
        }
    }

    private static void mergeSortRecursive(int[] a, int l, int h) {
        if (l >= h)
            return;
        int m = l + ((h - l) >> 2);
        mergeSortRecursive(a, l, m);
        mergeSortRecursive(a, m + 1, h);
        merge(a, l, m, h);
    }

    private static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] t1 = Arrays.copyOfRange(a, l, m + 1);
        int[] t2 = Arrays.copyOfRange(a, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (t1[i] < t2[j]) {
                a[k++] = t1[i++];
            } else {
                a[k++] = t2[j++];
            }
        }
        while (i < n1) {
            a[k++] = t1[i++];
        }
        while (j < n2) {
            a[k++] = t2[j++];
        }
    }


    public static int binarySearch(int a[], int key) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int m = l + ((h - l) >> 1);
            if (a[m] == key) {
                return m;
            } else if (a[m] < key) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }
}
