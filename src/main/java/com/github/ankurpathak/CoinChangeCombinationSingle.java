package com.github.ankurpathak;

public class CoinChangeCombinationSingle {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 7};
        int target = 10;
        System.out.println(coinChangeCombination(coins, 0, target, new StringBuilder("")));
    }


    static int coinChangeCombination(int[] coins, int uI, int target, StringBuilder psf) {
        if (target == 0) {
            System.out.println(psf.toString());
            return 1;
        }

        int n = coins.length;
        int count = 0;
        for (int i = uI; i < n; i++) {
            if (coins[i] <= target) {
                psf.append(coins[i]);
                count += coinChangeCombination(coins, i + 1, target - coins[i], psf);
                psf.deleteCharAt(psf.length() - 1);
            }
        }
        return count;
    }
}
