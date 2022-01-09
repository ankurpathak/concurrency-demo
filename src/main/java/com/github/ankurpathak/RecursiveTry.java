package com.github.ankurpathak;

public class RecursiveTry {
    public static void main(String[] args) {
        var a = new int[]{ 1, 2, 3 , 4, 5 ,6, 7 , 8, 9};
        System.out.printf("%s%n", sumOfRecursiveElementsOfArray(a, a.length));

        System.out.printf("%s%n", findSumOfNaturalNumbers(150));

        System.out.printf("%s%n", recursiveSlowPower(2, 5));
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
}
