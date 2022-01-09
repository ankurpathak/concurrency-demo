package com.github.ankurpathak;

import java.util.Arrays;

public class RecursiveTry {
    public static void main(String[] args) {
        var a = new int[]{ 1, 2, 3 , 4, 5 ,6, 7 , 8, 9};
        System.out.printf("%s%n", sumOfRecursiveElementsOfArray(a, a.length));

        System.out.printf("%s%n", findSumOfNaturalNumbers(150));

        System.out.printf("%s%n", recursiveSlowPower(2, 5));

        reverseArray(a, 0, a.length -1);
        System.out.printf("%s%n", Arrays.toString(a));

        reverseArray(a, 0);
        System.out.printf("%s%n", Arrays.toString(a));

        System.out.printf("%b%n", palindromeString("rukna", 0));
        System.out.printf("%b%n", palindromeString("maam", 0));
        System.out.printf("%b%n", palindromeString("mam", 0));
    }


    static int sumOfRecursiveElementsOfArray(int[] a, int n){
        if(n <= 0)
            return 0;
        return a[n-1] + sumOfRecursiveElementsOfArray(a, n-1);
    }

    static int findSumOfNaturalNumbers(int n){
        if(n <= 0)
            return 0;
        return n + findSumOfNaturalNumbers(n - 1);
    }

    static int recursiveSlowPower(int a, int n){
        if(n == 0)
            return 1;
        return a * recursiveSlowPower(a, n -1);
    }

    static int factorial(int n){
        if(n <= 1)
            return 1;
        return n * factorial(n -1);
    }

    static int fibonacci(int n){
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacci(n -1) + fibonacci(n -2);
    }


    static void reverseArray(int[] a, int i, int j){
        if(i >= j)
            return;
        int temp = a[i];
        a[i] = a[j];
        a[j] =  temp;
        reverseArray(a, i+1, j -1);
    }

    static void reverseArray(int[] a, int i){
        if(i >= a.length/2)
            return;
        int temp = a[i];
        a[i] = a[a.length - i - 1];
        a[a.length - i - 1] = temp;
        reverseArray(a, i + 1);
    }

    static boolean palindromeString(String str, int i){
        if(i >= str.length() / 2)
            return true;
        if(str.charAt(i) != str.charAt(str.length() -i -1))
            return  false;
        return palindromeString(str, i + 1);
    }
}
