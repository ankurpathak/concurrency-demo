package com.github.ankurpathak;

import java.util.Arrays;
import java.util.List;

class solve
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    @SuppressWarnings("checked")
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m)
    {
        Arrays.fill(color, -1);
        boolean result = dfs(G, color, i, m);
        return result;
    }


    private static boolean dfs(List<Integer>[] G, int[] color, int i, int m){
        if(i >= G.length){
            return true;
        }


        for(int j = 0; j < m; j++){
            if(isSafe(G, color, i, j)){
                color[i] = j;
                if(dfs(G, color, i + 1, m)) return true;
                color[i] = -1;
            }
        }

        return false;
    }


    private static boolean isSafe(List<Integer>[] G, int[] color, int i, int j){
        for(int adjacent: G[i]){
            if(color[adjacent]==j){
                return false;
            }
        }
        return true;
    }
}