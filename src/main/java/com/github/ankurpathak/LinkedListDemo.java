package com.github.ankurpathak;


import static com.github.ankurpathak.LinkedListUtil.traverse;


public class LinkedListDemo {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        ListNode root = create(a);
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


    }





    public static  ListNode create(Integer[] a){
        if(a == null || a.length == 0)
            return null;

        ListNode head = null , it = null;
        for (Integer t: a) {
            if (it == null) {
                it = new ListNode(t);
                head = it;
            } else {
                it.next = new ListNode(t);
                it = it.next;
            }
        }
        return head;
    }


    public static  ListNode addFirst(ListNode head,Integer data) {
        ListNode toAdd = new ListNode(data);
        toAdd.next = head;
        return toAdd;
    }

    public static  ListNode removeFirst(ListNode head) {
        // list is empty and nothing to delete
        if (head == null)
            return null;

        //delete the first node
        head = head.next;
        System.gc();
        return head;
    }


    public static  ListNode add(ListNode head,Integer data, int index) {
        if (index < 0)
            return head;

        if(index == 0){
            ListNode toAdd =  new ListNode(data);
            toAdd.next = head;
            return toAdd;
        }

        ListNode it = head;
        int counter = 0;
        while (it != null && counter < index - 1) {
            counter++;
            it = it.next;
        }

        if (it == null)
            return head;

        ListNode toAdd = new ListNode(data);
        toAdd.next = it.next;
        it.next = toAdd;

        return head;
    }


    public static  ListNode remove(ListNode head, int index){
        if(index < 0)
            return head;

        if(head == null)
            return null;

        if(index == 0){
            head = head.next;
            System.gc();
            return head;
        }

        ListNode it =  head;
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


    public static  ListNode addLast(ListNode head,Integer data) {
        //list is empty and insert as first node
        ListNode toAdd = new ListNode(data);
        if (head == null) {
            return toAdd;
        }

        ListNode it = head;

        //move to last node
        while (it.next != null) {
            it = it.next;
        }

        it.next = toAdd;
        return head;
    }

    public static  ListNode removeLast(ListNode head) {
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
        ListNode it = head;
        while (it.next.next != null) {
            it = it.next;
        }

        //delete last node and free memory
        it.next = null;
        System.gc();
        return head;
    }









}


