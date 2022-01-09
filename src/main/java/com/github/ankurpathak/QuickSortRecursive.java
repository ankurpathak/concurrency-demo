package com.github.ankurpathak;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class QuickSortRecursive {
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

                quickSortRecursive(a, 0, a.length - 1);
                System.out.printf("Sorted array is: %s%n", Arrays.toString(a));

                System.out.print("Enter y to try sort more: ");
                choice = in.next();

            } while (Objects.equals(choice, "y"));
        }
    }

    private static void quickSortRecursive(int[] a, int l, int h) {
        if(l >= h) return;
        int k = partition(a, l, h);
        quickSortRecursive(a, l, k -1);
        quickSortRecursive(a, k + 1, h);
    }

    public static int partition(int[] a, int l, int h){
        int i = l - 1;
        int pivot = a[h];
        for(int j = l; j < h ; j++){
            if(a[j] < pivot){
                i++;
                if(i != j){
                    a[i] = a[i] ^ a[j];
                    a[j] = a[i] ^ a[j];
                    a[i] = a[i] ^ a[j];
                }
            }
        }

        if(i + 1 != h){
            a[i + 1] = a[i + 1] ^ a[h];
            a[h] = a[i + 1] ^ a[h];
            a[i + 1] = a[i + 1] ^ a[h];
        }

        return i + 1;
    }
}
