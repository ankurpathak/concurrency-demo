package com.github.ankurpathak;

import java.util.*;

public class GraphToposort {
    public static List<Integer> dfsToposort(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean[] pathVisited = new boolean[graph.size()];
        var stack = new LinkedList<Integer>();
        boolean cycle = false;
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                if (dfsToposortHelper(graph, i, visited, pathVisited, stack)) {
                    break;
                }
            }
        }

        return stack;
    }

    public static boolean dfsToposortHelper(List<List<Integer>> graph, int node, boolean[] visited, boolean[] pathVisited, Deque<Integer> stack) {
        visited[node] = true;
        pathVisited[node] = true;

        for (Integer it : graph.get(node)) {
            if (!visited[it]) {
                if (dfsToposortHelper(graph, it, visited, pathVisited, stack)) return true;
            } else {
                if (pathVisited[it]) {
                    stack.clear();
                    return true;
                }
            }
        }
        pathVisited[node] = false;
        stack.offerFirst(node);
        return false;
    }


    public static List<Integer> bfsToposort(List<List<Integer>> graph) {
        int[] inDegree = new int[graph.size()];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < graph.size(); i++) {
            // i----> it
            for (Integer it : graph.get(i)) {
                inDegree[it]++;
            }
        }

        for (int i = 1; i < graph.size(); i++) {
            if (inDegree[i] == 0) {
                queue.offerLast(i);
            }
        }

        int count = 0;
        List<Integer> ds = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer node = queue.pollFirst();
            ds.add(node);
            // node ---> it
            for (Integer it : graph.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) queue.offerLast(it);
            }
        }

        if (ds.size() < graph.size() - 1)
            ds.clear();

        return ds;
    }
}
