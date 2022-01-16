package com.github.ankurpathak;

import java.util.Objects;

public class LinkedListUtil {
    public static <T> int count(ListNode<T> root){
        ListNode<T> it = root;

        int count = 0;
        while(it != null){
            System.out.printf("%s ", it.data);
            it = it.next;
            count++;
        }
        return count;
    }

    public static <T> ListNode<T> search(ListNode<T> head, T data){
        ListNode<T> it = head;
        while(it != null){
            if(Objects.equals(data, it.data)){
                return it;
            }
            it = it.next;
        }
        return null;
    }

    public static <T> void traverse(ListNode<T> root, String message){
        ListNode<T> it = root;

        System.out.printf("%s: ", message);
        while(it != null){
            System.out.printf("%s ", it.data);
            it = it.next;
        }
        System.out.println();
    }
}
