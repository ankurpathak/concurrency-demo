package com.github.ankurpathak;

public class CoinChangePermutationSingle {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 7};
        int target = 10;
        System.out.println(coinChangePermutation(coins, target, new StringBuilder("")));
    }


    static int coinChangePermutation(int[] coins, int target, StringBuilder psf) {
        if (target == 0) {
            System.out.println(psf.toString());
            return 1;
        }

        int n = coins.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (coins[i] > 0 && coins[i] <= target) {
                coins[i] = -1 * coins[i];
                psf.append(-1 * coins[i]);
                count += coinChangePermutation(coins, target - coins[i] * -1, psf);
                psf.deleteCharAt(psf.length() - 1);
                coins[i] = -1 * coins[i];
            }
        }
        return count;
    }
}
