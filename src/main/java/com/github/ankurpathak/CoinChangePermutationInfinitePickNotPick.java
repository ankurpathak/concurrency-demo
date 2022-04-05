package com.github.ankurpathak;

public class CoinChangePermutationInfinitePickNotPick {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 7};
        int target = 10;
        System.out.println(coinChangePermutation(coins, 0, target, new StringBuilder("")));
    }


    static int coinChangePermutation(int[] coins, int i, int target, StringBuilder psf) {
        int n = coins.length;
        if (i == n) {
            if (target == 0) {
                System.out.println(psf.toString());
                return 1;
            }
            return 0;
        }


        int notPick = coinChangePermutation(coins, i + 1, target, psf);

        int pick = 0;
        if (coins[i] <= target) {
            psf.append(coins[i]);
            pick += coinChangePermutation(coins, 0, target - coins[i], psf);
            psf.deleteCharAt(psf.length() - 1);
        }

        return pick + notPick;
    }
}
