package com.github.ankurpathak;

import java.util.Objects;
import java.util.Scanner;

public class BinaryIterativeDemo {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.print("Enter number of elements: ");
            int n = in.nextInt();
            int a[] = new int [n];
            System.out.println("Enter elements: ");
            for(int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }

            String choice = "y";
            do {
                System.out.print("Enter key: ");
                int key = in.nextInt();
                int index = binarySearch(a, key);

                if(index == -1){
                    System.out.printf("Key %d not found%n", key);
                }else {
                    System.out.printf("Key %d found at index %d%n", key, index);
                }
                System.out.print("Enter y to try search more: ");
                choice = in.next();

            }while (Objects.equals(choice, "y"));
        }
    }


    public static int binarySearch(int a[], int key){
        int l = 0;
        int h = a.length - 1;
        while(l <= h){
            int m = l + ((h - l) >> 1);
            if(a[m] == key){
                return m;
            }else if(a[m] < key ){
                l = m + 1;
            }else {
                h = m - 1;
            }
        }
        return -1;
    }
}
