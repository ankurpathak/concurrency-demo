package com.github.ankurpathak;

import java.util.HashMap;
import java.util.Map;

public class GcdUtils {
    public static void main(String[] args) {
        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        Solution sol = new Solution();
        sol.hasGroupsSizeX(deck);
    }


    static class Solution {
        static int gcd(int n1, int n2) {
            while (n2 != 0) {
                int rem = n1 % n2;
                n1 = n2;
                n2 = rem;
            }
            return n1;
        }

        public boolean hasGroupsSizeX(int[] deck) {
            int n = deck.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
            }


            int gcd = 2;
            for (Integer freq : map.keySet()) {
                gcd = gcd(map.get(freq), gcd);
            }

            return gcd >= 2;
        }
    }


}
