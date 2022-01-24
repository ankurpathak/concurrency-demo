package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        List<List<String>> collector = new ArrayList<>();
        solveNQueens(board, 0, collector);
        return collector;
    }


    public static void solveNQueens(char[][] board, int col, List<List<String>> collector){
        if(col >= board.length){
            collector.add(boardList(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                solveNQueens(board, col + 1, collector);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int cachedRow = row;
        int cachedCol = col;

        //checking queen along negative xaxis direction
        while (col >= 0){
            if(board[row][col] == 'Q')
                return false;
            col--;
        }

        col = cachedCol;

        //checking queen along negative x axis and positive y axis
        while(row >= 0 && col >=0){
            if(board[row][col] == 'Q')
                return false;
            col--;
            row--;
        }

        row = cachedRow;
        col =  cachedCol;

        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true;
    }

    private static List<String> boardList(char[][] board){
        List<String> ds =  new ArrayList<>();
        for(char[] row: board){
            ds.add(new String(row));
        }
        return ds;
    }
}
