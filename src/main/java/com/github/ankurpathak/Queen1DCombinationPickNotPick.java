package com.github.ankurpathak;

public class Queen1DCombinationPickNotPick {

    public static void main(String[] args) {

        // System.out.println(queenCombination(6, 3, 0, 0, new StringBuilder("")));
        System.out.println(queenCombination(3, 2, 0, 0, new StringBuilder("")));

    }

    public static int queenCombination(int boxes, int queen, int i, int j, StringBuilder psf) {
        if (i == boxes) {
            if (j == queen) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }


        int notPick = queenCombination(boxes, queen, i + 1, j, psf);

        psf.append('b').append(i).append('q').append(j).append(' ');
        int pick = queenCombination(boxes, queen, i + 1, j + 1, psf);
        psf.delete(psf.length() - 5, psf.length());

        return pick + notPick;

    }
}
