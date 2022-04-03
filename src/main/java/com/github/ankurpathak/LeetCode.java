package com.github.ankurpathak;

import java.util.*;

/*
["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
[[],[4],[3],[4],[2],[4], [4],[3],[4],[4]]
*/
class Solution67 {
    public static String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Comparator<Map.Entry<Character, Integer>> comp = (e1, e2) -> (e1.getValue() - e2.getValue()) * -1;
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(comp);
        queue.addAll(map.entrySet());
        Deque<Map.Entry<Character, Integer>> stack = new LinkedList<>();
        StringBuilder newS = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                return "";
            }
            var curr = queue.poll();
            newS.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            if (!stack.isEmpty()) {
                queue.offer(stack.pollLast());
            }
            if (curr.getValue() > 0) {
                stack.offerLast(curr);
            }
        }


        return newS.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
    }
}






