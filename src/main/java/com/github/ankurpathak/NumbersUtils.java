package com.github.ankurpathak;

import java.util.*;

public class NumbersUtils {
    public static void main(String[] args) {
        System.out.printf("Number of leading zeros in 25! is: %d%n", findTrailingZerosInFactorial(25));
        System.out.printf("Number of leading zeros in 625! is: %d%n", findTrailingZerosInFactorial(625));


        System.out.printf("Is 125 palindrome?! is: %b%n", isNumberPalindrome(125));
        System.out.printf("Is 1001 palindrome?! is: %b%n", isNumberPalindrome(1001));


        System.out.printf("Is 1 prime? %b%n", isPrime(1));
        System.out.printf("Is 37 prime? %b%n", isPrime(37));
        System.out.printf("Is 100 prime? %b%n", isPrime(100));


        System.out.printf("Prime factors of 1? %s%n", factorization(1));
        System.out.printf("Prime  factors of 37? %s%n", factorization(37));
        System.out.printf("Prime factors of 100? %s%n", factorization(100));
        System.out.printf("Prime factors of 1020? %s%n", factorization(1020));


        System.out.print("Prime factors till 50?");
        boolean[] prime = sieveOfEratosthenes(50);
        for (int i = 0; i < 51; i++) {
            System.out.printf(" %d:%b", i, prime[i]);
            if (i % 10 == 0) {
                System.out.println();
            }
        }

        System.out.printf("5 ^ 5? %d%n", fastPower(5, 5));
        System.out.printf("5 ^ 5? %d%n", fastPowerRecursive(5, 5));

        System.out.println(fastPowerMod(3978432, 5, 1000000007));
        System.out.println(fastPowerRecursiveMod(3978432, 5, 1000000007));

        System.out.println(fastPowerFractions(2, -2));

        System.out.println(fastPowerFractions(2, -2147483648));


        System.out.println(countPrimes(2));


        System.out.println(isUgly(-2147483648));

    }

    static int findTrailingZerosInFactorial(int n) {
        int zeros = 0;
        for (int i = 5; i <= n; i = i * 5) {
            zeros = zeros + n / i;
        }
        return zeros;
    }


    static boolean isNumberPalindrome(int n) {
        int tempN = n;
        int reverseN = 0;
        while (tempN > 0) {
            int digit = tempN % 10;
            reverseN = reverseN * 10 + digit;
            tempN = tempN / 10;
        }

        return reverseN == n;
    }


    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; 1L * i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static Map<Integer, Integer> factorization(int n) {
        int d = 2;
        Map<Integer, Integer> factors = new HashMap<>();
        if (n == 1) {
            factors.put(2, 0);
        }
        while (1L * d * d <= n && n > 1) {
            int k = 0;
            while (n % d == 0) {
                n /= d;
                k++;
            }
            if (k > 0) {
                factors.put(d, k);
            }
            d++;
        }
        if (n > 1) {
            factors.put(n, 1);
        }
        return factors;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;
        for (int i = 2; 1L * i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }


    static int fastPower(int a, int n) {
        int result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = result * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return result;
    }

    //Leetecode
    static double fastPowerFractions(double a, long n) {
        double result = 1;
        long p = Math.abs(n);
        while (p > 0) {
            if ((p & 1) == 1) {
                result = result * a;
            }
            a = a * a;
            p = p >> 1;
        }

        return n < 0 ? 1 / result : result;
    }


    static long fastPowerMod(long a, long n, int mod) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * a % mod) % mod;
            }
            a = (a % mod * a % mod) % mod;
            n = n >> 1;
        }
        return result;
    }

    static int fastPowerRecursive(int a, int n) {
        if (n == 0)
            return 1;

        if ((n & 1) == 1)
            return a * fastPowerRecursive(a * a, n >> 1);

        return fastPowerRecursive(a * a, n >> 1);
    }


    static long fastPowerRecursiveMod(long a, long n, int mod) {
        if (n == 0)
            return 1;

        long cache = (a % mod * a % mod) % mod;

        if ((n & 1) == 1)
            return (a % mod * fastPowerRecursiveMod(cache, n >> 1, mod)) % mod;

        return fastPowerRecursiveMod(cache, n >> 1, mod);
    }


    static int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;

        for (int i = 2; 1L * i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) count++;
        }
        return count;
    }


    static boolean isUgly(long n) {
        if (n <= 0)
            return false;
        long divisor = 2;
        while (divisor <= 5) {
            while (n % divisor == 0) {
                n = n / divisor;
            }
            divisor++;
        }

        if (n > 1) {
            return false;
        }
        return true;
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> nums =  new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(isSelfDividingNumber(i))
                nums.add(i);
        }
        return nums;
    }


    public boolean isSelfDividingNumber(int n){
        int p = n;
        while(p > 0){
            int digit = p % 10;
            if(digit == 0)
                return false;
            if(n % digit != 0)
                return false;
            p = p / 10;
        }
        return true;
    }




}
