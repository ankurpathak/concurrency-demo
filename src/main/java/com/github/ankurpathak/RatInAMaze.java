package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.List;

class Solution {


    private static final String[] dirStrs = new String[]{"R", "U", "L", "D"};
    private static final int dirRow[] = new int[]{0, -1, 0, 1};
    private static final int dirCol[] = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        System.out.println(findPath(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}

        }, 4));


        System.out.println(findPath(new int[][]{
                {1, 1},
                {1, 1}

        }, 2));


        System.out.println(findPath(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}

        }, 4));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> collector = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        if (m[0][0] == 1 && m[n - 1][n - 1] == 1) {
            visited[0][0] = true;
            dfs(m, n, 0, 0, "", visited, collector);
            visited[0][0] = false;
        }
        return collector;
    }


    public static void dfs(int[][] rat, int n, int row, int col, String path, boolean[][] visited, List<String> collector) {

        if (row == n - 1 && col == n - 1) {
            collector.add(path);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol] && rat[newRow][newCol] == 1) {
                visited[newRow][newCol] = true;
                dfs(rat, n, newRow, newCol, path + dirStrs[i], visited, collector);
                visited[newRow][newCol] = false;
            }
        }

    }
}
