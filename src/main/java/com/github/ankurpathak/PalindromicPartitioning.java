package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {

    public static List<List<String>> partition(String str) {
        List<List<String>> collector = new ArrayList<>();
        var ds = new ArrayDeque<String>();
        dfs(str, 0, ds,collector);

        return collector;
    }

    private static void dfs(String str, int i, ArrayDeque<String> ds, List<List<String>> collector) {
        if(i >= str.length()){
            collector.add(new ArrayList<>(ds));
        }

        for(int j = i; j < str.length(); j++){
            if(isSafe(str, i, j)){
                ds.offerLast(str.substring(i, j + 1));
                dfs(str, j + 1, ds, collector);
                ds.pollLast();
            }
        }
    }

    private static boolean isSafe(String str, int i, int j) {
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
