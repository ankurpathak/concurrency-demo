package com.github.ankurpathak;

import java.util.*;

public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        var stack = new LinkedList<Integer>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        boolean isCycle = false;


        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, pathVisited, stack)) {
                    isCycle = true;
                    break;
                }
            }
        }

        int[] arry = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            arry[i] = stack.pollFirst();
            i++;
        }
        return arry;
    }


    private static boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] pathVisited, Deque<Integer> stack) {
        visited[node] = true;
        pathVisited[node] = true;

        for (Integer it : graph.get(node)) {
            if (!visited[it]) {
                if (dfs(graph, it, visited, pathVisited, stack)) {
                    return true;
                }
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }
}
