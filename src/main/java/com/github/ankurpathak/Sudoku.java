package com.github.ankurpathak;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
       char[][] board = {
               {'5','3','.','.','7','.','.','.','.'},
               {'6','.','.','1','9','5','.','.','.'},
               {'.','9','8','.','.','.','.','6','.'},
               {'8','.','.','.','6','.','.','.','3'},
               {'4','.','.','8','.','3','.','.','1'},
               {'7','.','.','.','2','.','.','.','6'},
               {'.','6','.','.','.','.','2','8','.'},
               {'.','.','.','4','1','9','.','.','5'},
               {'.','.','.','.','8','.','.','7','9'}
       };

       System.out.println(Arrays.deepToString(board));
       solveSudoku(board);
       System.out.println(Arrays.deepToString(board));

    }


    public static void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private static boolean solveSudoku(char[][] board, int row, int col){
        if(row >= board.length){
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if(col == board[0].length - 1){
            nextCol = 0;
            nextRow++;
        }

        if(board[row][col] != '.'){
            if(solveSudoku(board, nextRow, nextCol)){
                return true;
            };
        }else {
            for(char i = '1'; i <= '9'; i++){
                if(isSafe(board, row, col, i)){
                    board[row][col] = i;
                    if(solveSudoku(board, nextRow, nextCol)){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, char option) {
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == option)
                return false;

            if(board[i][col] == option)
                return false;

            if(board[((row / 3) * 3) + (i / 3)][((col / 3) * 3) + (i % 3)] == option)
                return false;
        }
        return true;
    }

}
