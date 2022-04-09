package com.github.ankurpathak;

public class Queen1DPermutation {

    public static void main(String[] args) {
        System.out.println(queenCombination(new boolean[6], 3, 0, new StringBuilder("")));
    }

    public static int queenCombination(boolean[] boxes, int queen, int j, StringBuilder psf) {
        if (j == queen) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int k = 0; k < boxes.length; k++) {
            if (!boxes[k]) {
                boxes[k] = true;
                psf.append('b').append(k).append('q').append(j).append(' ');
                count += queenCombination(boxes, queen, j + 1, psf);
                psf.delete(psf.length() - 5, psf.length());
                boxes[k] = false;
            }
        }
        return count;
    }
}
