package com.github.ankurpathak;

public class Node<T> {
    Node<T> next;
    T data;

    Node() {
    }

    Node(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
