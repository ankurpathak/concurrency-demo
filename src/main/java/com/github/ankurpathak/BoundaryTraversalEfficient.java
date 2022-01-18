package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversalEfficient {


    public static <T> boolean isLeaf(TreeNode<T> root){
        return root.left == null && root.right == null;
    }
    public static <T> List<T> boundaryTraversalAnticlockwise(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        if(!isLeaf(root)) ds.add(root.data);
        addLeftBoundary(root, ds);
        addLeafNodes(root, ds, true);
        int sizeBeforeRightBoundary = ds.size();
        addRightBoundary(root, ds);
        reverse(ds, sizeBeforeRightBoundary);
        return ds;
    }

    public static <T> List<T> boundaryTraversalClockwise(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        if(!isLeaf(root)) ds.add(root.data);
        addRightBoundary(root, ds);
        addLeafNodes(root, ds, false);
        int sizeBeforeLeftBoundary = ds.size();
        addLeftBoundary(root, ds);
        reverse(ds, sizeBeforeLeftBoundary);
        return ds;
    }






    private static <T> void addRightBoundary(TreeNode<T> root, List<T> ds) {
        TreeNode<T> it = root.right;
        while (it != null){
            if(!isLeaf(it)) ds.add(it.data);
            it = it.right != null ? it.right : it.left;
        }
    }

    private static <T> void addLeafNodes(TreeNode<T> root, List<T> ds, boolean anticlockwise) {
        if(isLeaf(root)) {
            ds.add(root.data);
            return;
        }
        TreeNode<T> first = anticlockwise ? root.left : root.right;
        TreeNode<T> second = anticlockwise ? root.right : root.left;

        if(first != null) addLeafNodes(first, ds, anticlockwise);

        if(second != null) addLeafNodes(second, ds, anticlockwise);
    }

    private static <T> void addLeftBoundary(TreeNode<T> root, List<T> ds) {
        TreeNode<T> it = root.left;
        while (it != null){
            if(!isLeaf(it)) ds.add(it.data);
            it = it.left != null ? it.left : it.right;
        }
    }


    public static <T> void  reverse(List<T> a, int index){
        int mid = (int) Math.ceil(index + (a.size() - 1.0 - index) / 2);
        for(int i = 0 ; index + i < mid; i++){
            T temp = a.get(index + i);
            a.set(index + i, a.get(a.size() - i -1));
            a.set(a.size() - i -1, temp);
        }
    }


}
