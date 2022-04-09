package com.github.ankurpathak;

public class Queen2DCombination {

    public static void main(String[] args) {
        System.out.println(queenCombination(4, 4, 4, 0, 0, new StringBuilder("")));
    }

    public static int queenCombination(int m, int n, int queen, int i, int j, StringBuilder psf) {
        if (j == queen) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int k = i; k < n * m; k++) {
            int row = k / n;
            int col = k % n;
            String strRow = Integer.toString(row);
            String strCol = Integer.toString(col);
            psf.append('(').append(strRow).append(',').append(strCol).append(')').append(' ');
            count += queenCombination(m, n, queen, k + 1, j + 1, psf);
            psf.delete(psf.length() - 4 - strRow.length() - strCol.length(), psf.length());
        }
        return count;
    }
}
