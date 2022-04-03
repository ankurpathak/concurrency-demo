package com.github.ankurpathak;

public class FloodFill {
    private static char[] charDirs = {'r', 'w', 'd', 's', 'l', 'e', 'u', 'n'};
    private static int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};


    public static void main(String[] args) {
        System.out.println(floodFill(0, 0, 2, 2, new boolean[3][3], new StringBuilder("")));
    }

    public static int floodFill(int sr, int sc, int dr, int dc, boolean[][] visited, StringBuilder psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf.toString());
            return 1;
        }
        visited[sr][sc] = true;
        int count = 0;
        for (int i = 0; i < dirs.length; i++) {
            int newSr = sr + dirs[i][0];
            int newSc = sc + dirs[i][1];
            if (newSr >= 0 && newSr <= dr && newSc >= 0 && newSc <= dc) {

                if (!visited[newSr][newSc]) {
                    psf.append(charDirs[i]);
                    count += floodFill(newSr, newSc, dr, dc, visited, psf);
                    psf.deleteCharAt(psf.length() - 1);
                }

            }
        }
        visited[sr][sc] = false;
        return count;
    }
}
