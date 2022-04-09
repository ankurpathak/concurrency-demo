package com.github.ankurpathak;

public class Queen2DPermutation {

    public static void main(String[] args) {
        System.out.println(queenPermutation(new boolean[4][4], 4, 0, new StringBuilder("")));
    }

    public static int queenPermutation(boolean[][] boxes, int queen, int j, StringBuilder psf) {
        if (j == queen) {
            System.out.println(psf);
            return 1;
        }

        int m = boxes.length;
        int n = boxes[0].length;

        int count = 0;
        for (int k = 0; k < n * m; k++) {
            int row = k / n;
            int col = k % n;
            if (!boxes[row][col]) {
                boxes[row][col] = true;
                String strRow = Integer.toString(row);
                String strCol = Integer.toString(col);
                psf.append('(').append(strRow).append(',').append(strCol).append(')').append(' ');
                count += queenPermutation(boxes, queen, j + 1, psf);
                psf.delete(psf.length() - 4 - strRow.length() - strCol.length(), psf.length());
                boxes[row][col] = false;
            }

        }
        return count;
    }
}
