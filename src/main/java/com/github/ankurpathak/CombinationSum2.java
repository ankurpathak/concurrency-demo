package com.github.ankurpathak;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
      //  System.out.println(combinationSum2(new int[]{1, 1, 1, 2, 2}, 4));

        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> collector = new ArrayList<>();
        var ds = new LinkedList<Integer>();
        combinationSum2(candidates, target, 0, 0, ds, collector);
        return collector;
    }

    private static void combinationSum2(int[] candidates, int target, int i, int sum, Deque<Integer> ds, List<List<Integer>> collector) {
        if(sum >= target){
            if(sum == target){
                collector.add(new ArrayList<>(ds));
            }
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j - 1]) continue;
            ds.offerLast(candidates[j]);
            sum += candidates[j];
            combinationSum2(candidates, target, j + 1, sum, ds, collector);
            ds.pollLast();
            sum -= candidates[j];
        }
    }


}
