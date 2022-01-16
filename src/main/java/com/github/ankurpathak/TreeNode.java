package com.github.ankurpathak;

public class TreeNode<T> {
    TreeNode<T> left, right;
    T data;

    TreeNode(T data){
        this.data = data;
    }
}
