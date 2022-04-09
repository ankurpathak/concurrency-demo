package com.github.ankurpathak;

public class Queen1DCombination {

    public static void main(String[] args) {
        System.out.println(queenCombination(6, 3, 0, 0, new StringBuilder("")));
    }

    public static int queenCombination(int boxes, int queen, int i, int j, StringBuilder psf) {
        if (j == queen) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int k = i; k < boxes; k++) {
            String kSr = Integer.toString(k);
            String jStr = Integer.toString(j);
            psf.append('b').append(kSr).append('q').append(jStr).append(' ');
            count += queenCombination(boxes, queen, k + 1, j + 1, psf);
            psf.delete(psf.length() - 3 - kSr.length() - jStr.length(), psf.length());
        }
        return count;
    }
}
