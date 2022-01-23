package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation2 {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        List<List<Integer>> collector = new ArrayList<>();
        permute(numsList, 0, collector);
        return collector;
    }


    private static  void permute(List<Integer> numsList, int i, List<List<Integer>> collector){
        if(i >= numsList.size()){
            collector.add(new ArrayList<>(numsList));
        }
        for(int j = i; j < numsList.size(); j++){
            if(numsList.subList(i, j).contains(numsList.get(j))) continue;
            Collections.swap(numsList, i, j);
            permute(numsList, i + 1, collector);
            Collections.swap(numsList, i, j);
        }
    }



}
