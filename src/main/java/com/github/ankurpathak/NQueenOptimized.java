package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenOptimized {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        List<List<String>> collector = new ArrayList<>();
        boolean[] leftVisited = new boolean[n];
        boolean[] leftUpVisited = new boolean[2 * n - 1];
        boolean[] leftDownVisited = new boolean[2 * n - 1];
        solveNQueens(board, 0, collector, leftVisited, leftUpVisited, leftDownVisited);
        return collector;
    }


    public static void solveNQueens(char[][] board, int col, List<List<String>> collector, boolean[] leftVisited, boolean[] leftUpVisited, boolean[] leftDownVisited){
        if(col >= board.length){
            collector.add(boardList(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col, leftVisited, leftUpVisited, leftDownVisited)){
                board[row][col] = 'Q';
                leftVisited[row] = true;
                leftUpVisited[row - col + board.length -1] = true;
                leftDownVisited[row + col] = true;
                solveNQueens(board, col + 1, collector, leftVisited, leftUpVisited, leftDownVisited);
                leftDownVisited[row + col] = false;
                leftUpVisited[row - col + board.length -1] = false;
                leftVisited[row] = false;
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int row, int col, boolean[] leftVisited, boolean[] leftUpVisited, boolean[] leftDownVisited) {
        return !(leftVisited[row] || leftUpVisited[row - col + leftVisited.length - 1] || leftDownVisited[row + col]);
    }

    private static List<String> boardList(char[][] board){
        List<String> ds =  new ArrayList<>();
        for(char[] row: board){
            ds.add(new String(row));
        }
        return ds;
    }
}
