package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> collector = new ArrayList<>();
        var ds = new LinkedList<Integer>();
        combinationSum(candidates, target, 0, ds, collector);
        return collector;
    }

    private void combinationSum(int[] candidates, int target, int i, Deque<Integer> ds, List<List<Integer>> collector) {
        if(i >= candidates.length){
            if(target == 0){
                collector.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[i] <= target){
            ds.offerLast(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, ds, collector);
            ds.pollLast();
        }
        combinationSum(candidates, target, i + 1, ds, collector);
    }


}
