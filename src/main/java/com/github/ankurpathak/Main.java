package com.github.ankurpathak;
//FileReader in = new FileReader(System.getProperty("user.dir") + "/main.txt");

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader(System.getProperty("user.dir") + "/main.txt");
        BufferedReader br = new BufferedReader(in);
        MedianPriorityQueue qu = new MedianPriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }

    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            // write your code here
            if (right.size() > 0 && val > right.peek()) {
                right.offer(val);
            } else {
                left.offer(val);
            }
            balanceQueue();
        }


        private void balanceQueue() {
            if ((left.size() - right.size()) > 1) {
                right.offer(left.poll());
            } else if ((right.size() - left.size()) > 1) {
                left.offer(right.poll());
            }
        }

        public int remove() {
            // write your code here
            if (size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            if (right.size() > left.size()) {
                return right.poll();
            } else {
                return left.poll();
            }
        }

        public int peek() {
            // write your code here
            if (size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            if (right.size() > left.size()) {
                return right.peek();
            } else {
                return left.peek();
            }
        }

        public int size() {
            // write your code here
            return left.size() + right.size();
        }
    }
}