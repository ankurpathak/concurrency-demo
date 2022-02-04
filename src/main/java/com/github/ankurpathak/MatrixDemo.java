package com.github.ankurpathak;

public class MatrixDemo {

    public static void main(String[] args) {
        int a[][] = new int[7][7];

        int m = a.length;
        int n = a[0].length;

        int midM = ((m - 1) >> 1);
        int midN = ((n - 1) >> 1);

        for (int i = 0; i <= midM; i++) {
            for (int j = 0; j <= midN; j++) {
                a[i][j] = 1;
                a[i][n - j - 1] = 1;
                a[m - i - 1][j] = 1;
                a[m - i - 1][n - j - 1] = 1;
            }
        }

        //System.out.println(Arrays.deepToString(a));
        pascalTriangle(6);
    }


    public static void pascalTriangle(int n) {
        for (int i = 0; i < n; i++) {
            int nCrCurr = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(nCrCurr + "\t");
                nCrCurr = nCrCurr * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

}
