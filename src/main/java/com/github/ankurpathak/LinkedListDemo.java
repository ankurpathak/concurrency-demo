package com.github.ankurpathak;

public class LinkedListDemo {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        Node<Integer> root = create(a);
        traverse(root, "Link List Created");
        root = remove(root, 2);
        traverse(root, "Link List After Index 2 Removed");

        root = remove(root, 100);
        traverse(root, "Link List After Index 100 Removed");

        root = remove(root, 0);
        traverse(root, "Link List After Index 0 Removed");

        root = add(root, 1,0);
        traverse(root, "Link List After Adding 1 at Index 0");


        root = add(root, 1,100);
        traverse(root, "Link List After Adding 1 at Index 100");

        root = add(root, 3, 2);
        traverse(root, "Link List After Adding 3 At Index 2 Removed");


        root = addLast(root, 6);
        traverse(root, "Link List After Adding 6 At Last Index");

        root = removeLast(root);
        traverse(root, "Link List After Removing last Index");


        root = addFirst(root, 0);
        traverse(root, "Link List After Adding 0 at First");

        root = removeFirst(root);
        traverse(root, "Link List After Removing First");

        Integer[] b = {};
        root = create(b);
        root = addLastX(root, 5);
        traverse(root, "Testing addLastX Empty array");

        b = new Integer[]{1, 2, 3};
        root = create(b);
        root = addLastX(root, 4);
        traverse(root, "Testing addLastX Non Empty Array array");


        b = new Integer[]{1};
        root = create(b);
        root = removeLastX(root);
        traverse(root, "Testing removeLastX Single element array");

        b = new Integer[]{1, 2, 3};
        root = create(b);
        root = removeLastX(root);
        traverse(root, "Testing addLastX Non Single Element Array array");

    }


    public static <T> void traverse(Node<T> root, String message){
        Node<T> it = root;

        System.out.printf("%s: ", message);
        while(it != null){
            System.out.printf("%s ", it.data);
            it = it.next;
        }
        System.out.println();
    }


    public static <T> Node<T> create(T[] a){
        if(a == null || a.length == 0)
            return null;

        Node<T> head = null , it = null;
        for (T t : a) {
            if (it == null) {
                it = new Node<>(t);
                head = it;
            } else {
                it.next = new Node<>(t);
                it = it.next;
            }
        }
        return head;
    }


    public static <T> Node<T> addFirst(Node<T> head, T data) {
        Node<T> toAdd = new Node<>(data);
        toAdd.next = head;
        return toAdd;
    }

    public static <T> Node<T> removeFirst(Node<T> head) {
        // list is empty and nothing to delete
        if (head == null)
            return null;

        //delete the first node
        head = head.next;
        System.gc();
        return head;
    }


    public static <T> Node<T> add(Node<T> head, T data, int index) {
        if (index < 0)
            return head;

        if(index == 0){
            Node<T> toAdd =  new Node<>(data);
            toAdd.next = head;
            return toAdd;
        }

        Node<T> it = head;
        int counter = 0;
        while (it != null && counter < index - 1) {
            counter++;
            it = it.next;
        }

        if (it == null)
            return head;

        Node<T> toAdd = new Node<>(data);
        toAdd.next = it.next;
        it.next = toAdd;

        return head;
    }


    public static <T> Node<T> remove(Node<T> head, int index){
        if(index < 0)
            return head;

        if(head == null)
            return null;

        if(index == 0){
            head = head.next;
            System.gc();
            return head;
        }

        Node<T> it =  head;
        int counter = 0;
        while(it != null && counter < index - 1 ){
            counter++;
            it = it.next;
        }

        if(it == null || it.next == null){
            return head;
        }

        it.next = it.next.next;
        it = null;
        System.gc();
        return head;
    }


    public static <T> Node<T> addLast(Node<T> head, T data) {
        //list is empty and insert as first node
        Node<T> toAdd = new Node<>(data);
        if (head == null) {
            return toAdd;
        }

        Node<T> it = head;

        //move to last node
        while (it.next != null) {
            it = it.next;
        }

        it.next = toAdd;
        return head;
    }

    public static <T> Node<T> removeLast(Node<T> head) {
        //list is empty and nothing to delete
        if (head == null)
            return null;

        //delete only node and free memory
        if (head.next == null) {
            head = null;
            System.gc();
            return null;
        }

        //move to second last node
        Node<T> it = head;
        while (it.next.next != null) {
            it = it.next;
        }

        //delete last node and free memory
        it.next = null;
        System.gc();
        return head;
    }


    public static <T> Node<T> addLastX(Node<T> head, T data) {

        Node<T> toAdd = new Node<>(data);
        Node<T> start =  new Node<>();
        start.next = head;

        Node<T> it = start;
        while (it.next != null) {
            it = it.next;
        }

        it.next = toAdd;
        return start.next;
    }


    public static <T> Node<T> removeLastX(Node<T> head) {

        if (head == null)
            return null;

        Node<T> start = new Node<>();
        start.next = head;


        Node<T> it = start;
        while (it.next.next != null) {
            it = it.next;
        }


        it.next = null;
        System.gc();
        return start.next;
    }


}


