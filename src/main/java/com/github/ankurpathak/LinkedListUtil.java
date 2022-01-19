package com.github.ankurpathak;

import java.util.Objects;

public class LinkedListUtil {
    public static  int count(ListNode root){
        ListNode it = root;

        int count = 0;
        while(it != null){
            System.out.printf("%s ", it.data);
            it = it.next;
            count++;
        }
        return count;
    }

    public static  ListNode search(ListNode head,Integer data){
        ListNode it = head;
        while(it != null){
            if(Objects.equals(data, it.data)){
                return it;
            }
            it = it.next;
        }
        return null;
    }

    public static  void traverse(ListNode root, String message){
        ListNode it = root;

        System.out.printf("%s: ", message);
        while(it != null){
            System.out.printf("%s ", it.data);
            it = it.next;
        }
        System.out.println();
    }
}
