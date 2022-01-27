package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {

    public static void main(String[] args) {

    }

    class Solution {
        private static class Node {
            int level;
            int row;
            int col;

            public Node(int row, int col, int level) {
                this.row = row;
                this.col = col;
                this.level =  level;
            }
            public Node() {}
        }
        public static int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Deque<Node> queue = new ArrayDeque<>();

            int noOfOranges = 0;

            String[] sirStrs = new String[]{"R", "U", "L", "D"};
            int dirCol[] = {1, 0, -1, 0};
            int dirRow[] = {0, -1, 0, 1};

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 2){
                        queue.offerLast(new Node(i, j, 0));
                        noOfOranges++;
                    }else if(grid[i][j] == 1){
                        noOfOranges++;
                    }
                }
            }

            int orangesProcessedInQueue = 0;
            int span = 0;

            while (!queue.isEmpty()){
                Node it = queue.pollFirst();
                orangesProcessedInQueue++;
                for(int i = 0; i < 4; i++){
                    int adjacentRow = it.row + dirRow[i];
                    int adjacentCol = it.col + dirCol[i];
                    if(adjacentRow >= 0 && adjacentRow < m && adjacentCol >= 0 && adjacentCol < n && grid[adjacentRow][adjacentCol] == 1){
                        grid[adjacentRow][adjacentCol] = 2;
                        span = it.level + 1;
                        queue.offerLast(new Node(adjacentRow, adjacentCol, span));
                    }
                }
            }

            if(orangesProcessedInQueue == noOfOranges)
                return span;

            return -1;
        }
    }
}
