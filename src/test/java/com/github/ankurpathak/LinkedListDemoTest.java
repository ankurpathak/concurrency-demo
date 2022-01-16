package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.ankurpathak.LinkedListDemo.*;
import static com.github.ankurpathak.LinkedListUtil.count;
import static com.github.ankurpathak.LinkedListUtil.search;
import static org.assertj.core.api.Assertions.assertThat;


public class LinkedListDemoTest {

    private Integer[] notEmpty = {1, 2, 3};
    private Integer[] onlyElement = {1};
    private Integer[] empty = {};
    private ListNode<Integer> notEmptyRoot;
    private ListNode<Integer> onlyElementRoot;
    private ListNode<Integer> emptyRoot;


    @BeforeEach
    public void setUp(){
        notEmptyRoot = create(notEmpty);
        onlyElementRoot =  create(onlyElement);
        emptyRoot = create(empty);
    }



    @Test
    public void testCreate(){
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
        assertThat(onlyElementRoot).isNotNull();
        assertThat(count(onlyElementRoot)).isEqualTo(1);
        assertThat(emptyRoot).isNull();
    }




    @Test
    public void testAddFirstEmpty(){
        emptyRoot = addFirst(emptyRoot, 2);
        assertThat(emptyRoot).isNotNull();
        assertThat(count(emptyRoot)).isEqualTo(1);
        assertThat(emptyRoot.data).isEqualTo(2);
    }

    @Test
    public void testAddFirstNotEmpty(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = addFirst(notEmptyRoot, 2);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        assertThat(notEmptyRoot.data).isEqualTo(2);
    }

    @Test
    public void testAddLastEmpty(){
        emptyRoot = addLast(this.emptyRoot, 2);
        assertThat(emptyRoot).isNotNull();
        assertThat(count(emptyRoot)).isEqualTo(1);
        assertThat(emptyRoot.data).isEqualTo(2);
    }

    @Test
    public void testAddLastNotEmpty(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = addLast(notEmptyRoot, 4);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        ListNode<Integer> it = search(notEmptyRoot, 4);
        assertThat(it ).isNotNull();
        assertThat(it.data).isEqualTo(4);
    }

    @Test
    public void testAddNotEmpty(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = add(notEmptyRoot, 10, 2);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        ListNode<Integer> it = search(notEmptyRoot, 10);
        assertThat(it).isNotNull();
        assertThat(it.data).isEqualTo(10);
    }

    @Test
    public void testAddEmpty(){
        emptyRoot = add(emptyRoot, 2, 0);
        assertThat(emptyRoot).isNotNull();
        assertThat(count(emptyRoot)).isEqualTo(1);
        assertThat(emptyRoot.data).isEqualTo(2);
    }


    @Test
    public void testAddOutOfRange(){
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
        notEmptyRoot = add(notEmptyRoot, 50, 100);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
        assertThat(search(notEmptyRoot, 50)).isNull();
    }

    @Test
    public void testAddAtCount(){
        assertThat(notEmptyRoot).isNotNull();
        Integer count = count(notEmptyRoot);
        assertThat(count).isEqualTo(3);
        notEmptyRoot = add(notEmptyRoot, 50, count);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        ListNode<Integer> it = search(notEmptyRoot, 50);
        assertThat(it).isNotNull();
        assertThat(it.next).isNull();
    }


    @Test
    public void testRemoveFirstOnlyElement(){
        assertThat(onlyElementRoot).isNotNull();
        onlyElementRoot = removeFirst(onlyElementRoot);
        assertThat(onlyElementRoot).isNull();
        assertThat(count(onlyElementRoot)).isEqualTo(0);
    }


    @Test
    public void testRemoveFirstNotEmpty(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = removeFirst(notEmptyRoot);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(2);
        assertThat(notEmptyRoot.data).isEqualTo(2);
        assertThat(search(notEmptyRoot, 1)).isNull();
    }


    @Test
    public void testRemoveLastOnlyElement(){
        assertThat(onlyElementRoot).isNotNull();
        onlyElementRoot = removeLast(onlyElementRoot);
        assertThat(onlyElementRoot).isNull();
        assertThat(count(onlyElementRoot)).isEqualTo(0);
        assertThat(search(onlyElementRoot, 1)).isNull();
    }

    @Test
    public void testRemoveLastNotEmpty(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = removeLast(notEmptyRoot);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(2);
        ListNode<Integer> it = search(notEmptyRoot, 2);
        assertThat(it).isNotNull();
        assertThat(it.next).isNull();
        assertThat(it.data).isEqualTo(2);
    }


    @Test
    public void testRemoveOnlyElement(){
        assertThat(onlyElementRoot).isNotNull();
        onlyElementRoot = remove(onlyElementRoot, 0);
        assertThat(onlyElementRoot).isNull();
        assertThat(count(onlyElementRoot)).isEqualTo(0);
        assertThat(search(onlyElementRoot, 1)).isNull();
    }


    @Test
    public void testRemoveNotEmpty(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = remove(notEmptyRoot, 1);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(2);
        ListNode<Integer> it = search(notEmptyRoot, 2);
        assertThat(it).isNull();
    }

    @Test
    public void testRemoveOutOfRange(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = remove(notEmptyRoot, 50);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
    }

    @Test
    public void testRemoveNodeAfterLast(){
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = remove(notEmptyRoot, 3);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
    }


}
