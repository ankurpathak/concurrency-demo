package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.Arrays;
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
                return bfsCycle(graph, i, visited);
            }
        }
        return false;
    }

    private static boolean bfsCycle(List<List<Integer>> graph, int node, boolean[] visited) {
        Deque<Pair> queue = new ArrayDeque<>();
        visited[node] = true;
        queue.offerLast(new Pair(node, -1));

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




    public static boolean notBipartiteChecker(List<List<Integer>> graph) {
        int[] colored = new int[graph.size()];
        Arrays.fill(colored, -1);
        for (int i = 1; i < graph.size(); i++) {
            if (colored[i] == -1) {
                return dfsBipartite(graph, i, colored, false);
            }
        }
        return false;
    }

    public static boolean dfsBipartite(List<List<Integer>> graph, int node, int[] coloured, boolean color) {
        int intColor = color ? 1 : 0;
        coloured[node] = intColor;
        for (Integer it : graph.get(node)) {
            if (coloured[it] == -1) {
                if (dfsBipartite(graph, it, coloured, !color)) return true;
            } else {
                if (coloured[it] == intColor) return true;
            }
        }
        return false;
    }

    private static boolean bfsOddCycle(List<List<Integer>> graph, int[] visited, int node) {
        Deque<Pair> queue = new ArrayDeque<>();

        Pair startPair = new Pair(node, -1);
        startPair.label = 0;
        queue.offerLast(startPair);
        while (!queue.isEmpty()) {
            Pair curr = queue.pollFirst();

            if (visited[curr.node] != -1) {

                if (visited[curr.node] != curr.label) {
                    return true;
                }
                continue;
            }

            visited[curr.node] = curr.label;

            for (Integer it : graph.get(curr.node)) {
                if (visited[it] == -1) {
                    Pair itPair = new Pair(it, node);
                    itPair.label = curr.label + 1;
                    queue.offerLast(itPair);
                }
            }
        }

        return false;
    }

    private static boolean bfsEvenCycle(List<List<Integer>> graph, int[] visited, int node) {
        Deque<Pair> queue = new ArrayDeque<>();
        Pair startPair = new Pair(node, -1);
        startPair.label = 0;
        queue.offerLast(startPair);
        while (!queue.isEmpty()) {
            Pair curr = queue.pollFirst();

            if (visited[curr.node] != -1) {
                //reverse condition for odd cycle
                if (visited[curr.node] == curr.label) {
                    return true;
                }
                continue;
            }
            //parent is used to store label
            visited[curr.node] = curr.label;

            for (Integer it : graph.get(curr.node)) {
                if (visited[it] == -1) {
                    Pair itPair = new Pair(it, node);
                    itPair.label = curr.label + 1;
                    queue.offerLast(itPair);
                }
            }
        }

        return false;
    }

    public static boolean bfsEvenCycleChecker(List<List<Integer>> graph) {
        int[] visited = new int[graph.size()];
        Arrays.fill(visited, -1);
        for (int i = 1; i < graph.size(); i++) {
            if (visited[i] == -1) {
                if (bfsEvenCycle(graph, visited, i)) return true;
            }
        }
        return false;
    }

    public static boolean bfsOddCycleChecker(List<List<Integer>> graph) {
        int[] visited = new int[graph.size()];
        Arrays.fill(visited, -1);
        for (int i = 1; i < graph.size(); i++) {
            if (visited[i] == -1) {
                if (bfsOddCycle(graph, visited, i)) return true;
            }
        }
        return false;
    }

    private static class Pair {
        int node;
        int parent;
        int label;

        Pair() {
        }

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }

        Pair(int node) {
            this.node = node;

        }
    }
}
