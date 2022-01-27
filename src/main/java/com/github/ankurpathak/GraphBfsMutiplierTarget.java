package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.Deque;

public class GraphBfsMutiplierTarget {

    private static class Pair {
        int level;
        int data;

        public Pair() {
        }

        public Pair(int data, int level) {
            this.level = level;
            this.data = data;
        }
    }
    public static void main(String[] args) {
        System.out.println(bfsMultiplication(2, 101, new int[]{2, 5, 10}));
    }


    public static int bfsMultiplication(int start, int end, int[] factors){
        boolean visited[] = new boolean[end + 1];
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offerLast(new Pair(start, 0));
        visited[start] = true;
        while(!queue.isEmpty()){
            Pair it = queue.pollFirst();
            if(it.data == end)
                return it.level;
            for(int factor: factors){
                int adjacent =  it.data * factor;
                if(adjacent <= end && !visited[adjacent]){
                    visited[adjacent] = true;
                    queue.offerLast(new Pair(adjacent, it.level + 1));
                }
            }
        }
        return -1;
    }

}


