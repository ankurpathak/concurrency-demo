package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class GraphCycle {


    public static boolean dfsDirectedCycleChecker(List<List<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];
        boolean pathVisited[] = new boolean[graph.size()];

        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                return dfsDirectedCycle(graph, i, visited, pathVisited);
            }
        }
        return false;
    }

    private static boolean dfsDirectedCycle(List<List<Integer>> graph, int node, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (Integer it : graph.get(node)) {
            if (!visited[it]) {
                if (dfsDirectedCycle(graph, it, visited, pathVisited)) return true;
            } else {
                if (pathVisited[it]) return true;
            }
        }
        return false;
    }


    public static boolean dfsCycleChecker(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                return dfsCycle(graph, i, visited, -1);
            }
        }
        return false;
    }

    public static boolean bfsCycleChecker(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                return bfsCycle(graph, i, visited, -1);
            }
        }
        return false;
    }

    private static boolean bfsCycle(List<List<Integer>> graph, int node, boolean[] visited, int parent) {
        Deque<Pair> queue = new ArrayDeque<>();
        visited[node] = true;
        queue.offerLast(new Pair(node, parent));

        while (!queue.isEmpty()) {
            Pair curr = queue.pollFirst();
            for (Integer it : graph.get(curr.node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queue.push(new Pair(it, curr.node));
                } else {
                    if (it != curr.parent)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsCycle(List<List<Integer>> graph, int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (Integer it : graph.get(node)) {
            if (!visited[it]) {
                visited[it] = true;
                if (dfsCycle(graph, it, visited, node)) {
                    return true;
                }
            } else {
                if (it != parent) return true;
            }
        }

        return false;
    }

    private static class Pair {
        int node;
        int parent;

        Pair() {
        }

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
