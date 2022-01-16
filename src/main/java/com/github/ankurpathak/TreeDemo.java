package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeDemo {
    public static void main(String[] args) {
        Integer a[] = new Integer[]{ 1, 2, 3, 4, 5, 7, 8, null,null, 6,null, null,null,9,10};
        TreeNode<Integer> root = create(a);
        List<Integer> sequence =  new ArrayList<>();
        inorder(root, sequence);
        System.out.println(sequence);
        sequence.clear();
        preorder(root, sequence);
        System.out.println(sequence);
    }


    public static <T> TreeNode<T> create(T a[]){
        if(a == null || a.length == 0)
            return null;
        Deque<Pair<TreeNode<T>>> queue = new LinkedList<>();
        TreeNode<T> root = new TreeNode<>(a[0]);
        Pair<TreeNode<T>> pair = new Pair<>(root, 0);
        queue.offerLast(pair);
        int i = 0;
        while (!queue.isEmpty()){
            pair = queue.pollFirst();
            int lChildIndex = 2 * pair.index + 1;
            int rChildIndex = 2 * pair.index + 2;
            T lChild = a[lChildIndex];
            T rChild = a[rChildIndex];
            if(lChild != null){
                pair.t.left = new TreeNode<>(lChild);
                queue.offerLast(new Pair<>(pair.t.left, lChildIndex));
            }

            if(rChild != null){
                pair.t.right = new TreeNode<>(rChild);
                queue.offerLast(new Pair<>(pair.t.right, rChildIndex));
            }
            i = rChildIndex;
            if(i >= a.length - 1){
                queue.clear();
            }
        }
        return root;
    }

    public static <T> void inorder(TreeNode<T> root, List<T> ds){
        if(root == null)
            return;
        inorder(root.left, ds);
        ds.add(root.data);
        inorder(root.right, ds);
    }

    public static <T> void preorder(TreeNode<T> root, List<T> ds){
        if(root == null)
            return;
        ds.add(root.data);
        preorder(root.left, ds);
        preorder(root.right, ds);
    }

    public static <T> void postorder(TreeNode<T> root, List<T> ds){
        if(root == null)
            return;
        postorder(root.left, ds);
        postorder(root.right, ds);
        ds.add(root.data);
    }
 }

class Pair<T>{
    T t;
    int index;

    public Pair(T t, int index) {
        this.t = t;
        this.index = index;
    }
}

