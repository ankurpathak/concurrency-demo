package com.github.ankurpathak;

public class RatInMazeWithJumps {
    private static char[] charDirs = {'r', 'w', 'd'};
    private static int[][] dirs = {{0, 1}, {1, 1}, {1, 0}};

    public static void main(String[] args) {
        System.out.println(mazePath(0, 0, 2, 2, new StringBuilder("")));
    }

    public static int mazePath(int sr, int sc, int dr, int dc, StringBuilder psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf.toString());
            return 1;
        }

        int count = 0;
        for (int i = 0; i < dirs.length; i++) {
            for (int j = 1; j <= Math.max(dr, dc); j++) {
                int newSr = sr + j * dirs[i][0];
                int newSc = sc + j * dirs[i][1];
                if (newSr >= 0 && newSr <= dr && newSc >= 0 && newSc <= dc) {
                    psf.append(charDirs[i]).append(j);
                    count += mazePath(newSr, newSc, dr, dc, psf);
                    psf.deleteCharAt(psf.length() - 1).deleteCharAt(psf.length() - 1);
                } else break;
            }
        }
        return count;
    }
}
