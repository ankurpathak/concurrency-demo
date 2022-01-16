package com.github.ankurpathak;

public class ListNode<T> {
    ListNode<T> next;
    T data;

    ListNode() {
    }

    ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
