package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapDemo {


    public static void enqueue(List<Integer> list, int val) {
        list.add(val);
        upheapify(list, val);
    }

    public static Integer peek(List<Integer> list) {
        return list.get(0);
    }

    public static Integer size(List<Integer> list) {
        return list.size();
    }

    private static void upheapify(List<Integer> list, int i) {
        if (i == 0)
            return;
        int parent = ((i - 1) >> 1);
        if (list.get(i) < list.get(parent)) {
            Collections.swap(list, i, parent);
            upheapify(list, parent);
        }
    }

    public static Integer dequeue(List<Integer> list, int val) {
        Collections.swap(list, 0, list.size() - 1);
        Integer removed = list.remove(list.size() - 1);
        downheapify(list, 0);
        return removed;
    }

    private static void downheapify(List<Integer> list, int i) {
        int minIndex = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < list.size() && list.get(minIndex) > list.get(leftChild)) {
            minIndex = leftChild;
        }

        if (leftChild < list.size() && list.get(minIndex) > list.get(rightChild)) {
            minIndex = rightChild;
        }

        if (i != minIndex) {
            Collections.swap(list, minIndex, i);
            downheapify(list, minIndex);
        }

    }

    public List<Integer> create(int a[]) {
        if (a == null || a.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for (int it : a) {
            list.add(it);
        }

        for (int i = (list.size() >> 1) - 1; i >= 0; i--) {
            downheapify(list, i);
        }
        return list;
    }
}
