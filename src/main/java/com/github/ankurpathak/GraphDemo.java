package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphDemo {


    public static void main(String[] args) {
        bfsTraversal(List.of(
                List.of(1, 2, 3),
                List.of(1, 2, 3),
                List.of(1, 2, 3)
        ));
    }




    public static List<Integer> bfsTraversal(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        List<Integer> ds = new ArrayList<>();
        for(int i = 1; i < graph.size(); i++){
            if(!visited[i]){
                bfs(i, graph, visited, ds);
            }
        }
        return ds;
    }


    public static List<Integer> dfsTraversal(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        List<Integer> ds = new ArrayList<>();
        for(int i = 1; i < graph.size(); i++){
            if(!visited[i]){
                dfs(i, graph, visited, ds);
            }
        }
        return ds;
    }

    public static void dfs(int i, List<List<Integer>> graph,  boolean[] visited, List<Integer> ds){
        visited[i] = true;
        ds.add(i);
        for(Integer adjacent: graph.get(i)){
            if(!visited[adjacent]){
                dfs(adjacent, graph, visited, ds);
            }
        }
    }

    private static void bfs(Integer i, List<List<Integer>> graph, boolean[] visited, List<Integer> ds) {
        var queue =  new LinkedList<Integer>();
        queue.offerLast(i);
        visited[i] =  true;
        while(!queue.isEmpty()){
            Integer node =  queue.pollFirst();
            ds.add(node);
            for(Integer adjacent: graph.get(node)){
                if(!visited[adjacent]){
                    queue.offerLast(adjacent);
                    visited[adjacent] =  true;
                }
            }
        }
    }
}
