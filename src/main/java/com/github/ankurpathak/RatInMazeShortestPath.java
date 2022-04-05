package com.github.ankurpathak;

public class RatInMazeShortestPath {
    private static char[] charDirs = {'r', 'w', 'd'};
    private static int[][] dirs = {{0, 1}, {1, 1}, {1, 0}};

    public static void main(String[] args) {
        var min = mazePath(0, 0, 2, 2);
        System.out.println(min.len + " " + min.path);
    }

    public static Path mazePath(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            return new Path();
        }

        var min = new Path(Integer.MAX_VALUE);
        for (int i = 0; i < dirs.length; i++) {
            int newSr = sr + dirs[i][0];
            int newSc = sc + dirs[i][1];
            if (newSr >= 0 && newSr <= dr && newSc >= 0 && newSc <= dc) {
                var subMin = mazePath(newSr, newSc, dr, dc);
                subMin.len = subMin.len != Integer.MAX_VALUE ? subMin.len + 1 : subMin.len;
                if (subMin.len < min.len) {
                    min.len = subMin.len;
                    min.path = subMin.path;
                    min.path.append(charDirs[i]);
                }
            }
        }
        return min;
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
