package com.github.ankurpathak;

public class Queen1DPermutationPickNotPick {

    public static void main(String[] args) {
        System.out.println(queenCombination(new boolean[6], 3, 0, 0, new StringBuilder("")));
    }

    public static int queenCombination(boolean[] boxes, int queen, int i, int j, StringBuilder psf) {
        if (i == boxes.length) {
            if (j == queen) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }


        int notPick = queenCombination(boxes, queen, i + 1, j, psf);

        int pick = 0;

        if (!boxes[i]) {
            boxes[i] = true;
            psf.append('b').append(i).append('q').append(j).append(' ');
            pick = queenCombination(boxes, queen, 0, j + 1, psf);
            psf.delete(psf.length() - 5, psf.length());
            boxes[i] = false;
        }

        return pick + notPick;

    }
}
