package com.github.ankurpathak;

import java.util.Arrays;

public class BinaryUtils {
    public static void main(String[] args) {
        System.out.printf("Is 5 even? %b%n", isEven(5));
        System.out.printf("Is 4 even? %b%n", isEven(4));

        System.out.printf("Is 5 odd? %b%n", isOdd(5));
        System.out.printf("Is 4 odd? %b%n", isOdd(4));

        System.out.printf("Double of 5 id: %d%n", multipleBy2(5));
        System.out.printf("Double of 4 id: %d%n", multipleBy2(4));

        System.out.printf("Half of 5 id: %d%n", divideBy2(5));
        System.out.printf("Half of 4 id: %d%n", divideBy2(4));

        //always a nd b are two different variable. It will fail in case of swap of a with a
        swap(10, 20);

        //Start from 0 bit
        System.out.printf("4th bit of 16 is: %d%n", findNthBit(16, 4));
        System.out.printf("2th bit of 8 is: %d%n", findNthBit(8, 3));
        System.out.printf("1st bit of 5 is: %d%n", findNthBit(5, 1));
        System.out.printf("Oth bit of 2 is: %d%n", findNthBit(2, 0));


        System.out.printf("Set 3rd bit of 16: %d%n", setNthBit(16, 3));


        System.out.printf("Clear 4rd bit of 16: %d%n", clearNthBit(16, 4));


        System.out.printf("Different bits in 8 and 16: %d%n", differentBitsInTwoNumbers(8, 16));

        System.out.printf("Only non repeating number if all numbers repeats twice: %d%n", findOnlyNonRepeatingNumberIfAllOtherNumberRepeatingTwice(new int []{5, 4, 1, 4, 3, 5, 1}));
        System.out.printf("two non repeating number if all numbers repeats twice: %s%n", Arrays.toString(findTwoNonRepeatingIntegerIfAllOtherNumberRepeatingTwice(new int []{9,5, 4, 1, 4, 3, 5, 1})));


        System.out.printf("Only non repeating number if all numbers repeats thrice: %d%n", findOnlyNonRepeatingNumberIfAllOtherNumberRepeatingThrice(new int []{2, 2, 1, 5, 1, 1, 2}));


    }




    public static boolean isEven(int n){
        //Precedence of assignment is more than logical and
        return (n & 1) == 0;
    }

    public static boolean isOdd(int n){
        return (n & 1) == 1;
    }

    public static int multipleBy2(int n){
        return n << 1;
    }

    public static  int divideBy2(int n){
        return n >> 1;
    }

    public static void  swap(int a, int b){
        System.out.printf("a = %d b = %d%n", a, b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("a = %d b = %d%n", a, b);
    }

    public static int findNthBit(int n, int i){
        System.out.printf("findNthBit n=%d(%s) i=%d%n", n, Integer.toBinaryString(n), i);
        int mask = 1 << i;
        return (n & mask) != 0 ? 1 : 0;
    }


    public static int setNthBit(int n, int i){
        System.out.printf("setNthBit n=%d(%s) i=%d%n", n, Integer.toBinaryString(n), i);
        int mask = 1 << i;
        System.out.printf("setNthBit n=%d(%s) i=%d%n", n | mask, Integer.toBinaryString(n | mask), i);
        return n | mask ;
    }


    public static int clearNthBit(int n, int i){
        System.out.printf("clearNthBit n=%d(%s) i=%d%n", n, Integer.toBinaryString(n), i);
        int mask = ~(1 << i);
        System.out.printf("clearNthBit n=%d(%s) i=%d%n", n & mask, Integer.toBinaryString(n & mask), i);
        return n & mask ;
    }


    public static int differentBitsInTwoNumbers(int n, int m){
        System.out.printf("differentBitsInTwoNumbers n=%d(%s) m=%d(%s)%n", n, Integer.toBinaryString(n), m, Integer.toBinaryString(m));
        int result = n ^ m;
        int i  = 0;
        while(result > 0){
            result = result & (result - 1);
            i++;
        }
        return i;
    }


    public static int findOnlyNonRepeatingNumberIfAllOtherNumberRepeatingTwice(int[] a){
        int xorAll = 0;
        for(int i = 0; i < a.length; i++){
            xorAll = xorAll ^ a[i];
        }
        return xorAll;
    }


    public static int[] findTwoNonRepeatingIntegerIfAllOtherNumberRepeatingTwice(int[] a){
        int xorAll = 0;
        for(int i = 0; i < a.length; i++){
            xorAll = xorAll ^ a[i];
        }

        int k = 0;
        while(xorAll > 0 && (xorAll & (1 << k)) != (1 << k)) k++;

        int xorAllBitK0 = 0, xorAllBitK1 = 0;

        for(int i =0; i < a.length; i++) {
            if((a[i] & (1 << k)) == (1 << k)){
                xorAllBitK1 = xorAllBitK1 ^ a[i];
            }else {
                xorAllBitK0 = xorAllBitK0 ^ a[i];
            }
        }

        return new int[]{ xorAll ^ xorAllBitK0, xorAll ^ xorAllBitK1};

    }


    public static int findOnlyNonRepeatingNumberIfAllOtherNumberRepeatingThrice(int[] a){
        int[] binaryDigitsCount =  new int[32];
        Arrays.fill(binaryDigitsCount, 0);

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < 32; j++){
                if((a[i] & (1 << j)) == (1 << j)){
                    binaryDigitsCount[j]++;
                }
            }
        }

        int result = 0;

        for(int i = 0; i < binaryDigitsCount.length ; i++){
            int digit = binaryDigitsCount[i] % 3;
            if(digit == 1){
                result += (1 << i);
            }
        }

        return result;
    }



}
