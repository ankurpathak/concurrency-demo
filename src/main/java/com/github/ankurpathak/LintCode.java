package com.github.ankurpathak;

class Solution20 {


    public static void main(String[] args) {
        int[][] costs = {{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}};
        System.out.println(minCostII(costs));
    }

    public static int minCostII(int[][] costs) {
        // write your code here

        int n = costs.length;
        int k = 0;
        if (n > 0)
            k = costs[0].length;


        int[][] dp = new int[n][k];


        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];

            if (first > dp[0][j]) {
                second = first;
                first = dp[0][j];
            } else if (second > dp[0][j]) {
                second = dp[0][j];
            }
        }


        for (int i = 1; i < n; i++) {
            int newFirst = Integer.MAX_VALUE;
            int newSecond = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                dp[i][j] = costs[i][j] + (dp[i - 1][j] != first ? first : second);
                if (newFirst > dp[i][j]) {
                    newSecond = newFirst;
                    newFirst = dp[i][j];
                } else if (newSecond > dp[i][j]) {
                    newSecond = dp[i][j];
                }
            }
            first = newFirst;
            second = newSecond;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;

    }
}

