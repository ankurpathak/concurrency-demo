package com.github.ankurpathak;

public class ArrayUtils {


    public static void main(String[] args) {

    }

    public static void reverse(int a[], int index){
        int mid = (int) Math.ceil(index + (a.length - 1.0 - index) / 2);
        for(int i = 0 ; index + i < mid; i++){
            int temp = a[index + i];
            a[index + i] = a[a.length - i -1];
            a[a.length - i -1] = temp;
        }
    }
}


