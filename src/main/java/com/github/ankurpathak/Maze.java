package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.Deque;



public class Maze {


    public static void main(String[] args) {
        System.out.println(
        hasPath(new int[][]{
                {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0 }
        }, new int[]{0, 4}, new int[]{3, 2}));
    }


    private static class Node {
        int row;
        int col;
        int level;
        Node() {}
        Node(int row, int col, int level){
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Deque<Node> queue = new ArrayDeque<>();
        maze[start[0]][ start[1]] = 2;
        queue.offerLast(new Node(start[0],start[1], 0));


        String[] dirStr = new String[]{"R", "U", "L", "D"};
        int dirRow[] = new int[]{0, -1, 0, 1};
        int dirCol[] = new int[]{1, 0, -1, 0};

        while(!queue.isEmpty()){
            Node node = queue.pollFirst();
            int row = node.row;
            int col = node.col;
            int level = node.level;

            if(row == destination[0] && col == destination[1])
                return true;

            for(int i = 0; i < 4; i++){
                int newRow = row;
                int newCol = col;

                while(newRow >= 0 && newRow < m && newCol >=0 && newCol < n && maze[newRow][newCol] != 1){
                    newRow += dirRow[i];
                    newCol += dirCol[i];
                }

                newRow -= dirRow[i];
                newCol -= dirCol[i];

                if(maze[newRow][newCol] != 2){
                    maze[newRow][newCol] = 2;
                    queue.offerLast(new Node(newRow, newCol, level + 1));
                }
            }
        }

        return false;
    }
}
