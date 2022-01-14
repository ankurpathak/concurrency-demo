package com.github.ankurpathak;

import java.util.LinkedList;

public class CombinationSum2 {
    public static void main(String[] args) {
        backtracing(new int[]{1, 2, 3}, 0, new LinkedList<>());
    }


    static public void backtracing(int[] a, int i, LinkedList<Integer> cur){

        if(i >= a.length){
            System.out.println(cur);
            return;
        }
        System.out.println(cur);
        for(int j=i; j <a.length; j++){
            cur.add(a[j]);
            backtracing(a,j+1, cur);
            cur.removeLast();
        }
    }
}
