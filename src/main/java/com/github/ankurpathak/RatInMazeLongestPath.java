package com.github.ankurpathak;

public class RatInMazeLongestPath {
    private static char[] charDirs = {'r', 'w', 'd'};
    private static int[][] dirs = {{0, 1}, {1, 1}, {1, 0}};

    public static void main(String[] args) {
        Path max = mazePath(0, 0, 2, 2);
        System.out.println(max.path + " " + max.len);
    }

    public static Path mazePath(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            return new Path();
        }

        Path max = new Path(Integer.MIN_VALUE);
        for (int i = 0; i < dirs.length; i++) {
            int newSr = sr + dirs[i][0];
            int newSc = sc + dirs[i][1];
            if (newSr >= 0 && newSr <= dr && newSc >= 0 && newSc <= dc) {
                Path subMax = mazePath(newSr, newSc, dr, dc);
                subMax.len = subMax.len != Integer.MIN_VALUE ? subMax.len + 1 : subMax.len;
                if (subMax.len > max.len) {
                    max.len = subMax.len;
                    max.path = subMax.path;
                    max.path.append(charDirs[i]);
                }
            }
        }
        return max;
    }

    private static class Path {
        StringBuilder path = new StringBuilder("");
        int len;

        Path(int len) {
            this.len = len;
        }

        Path() {
        }
    }
}
