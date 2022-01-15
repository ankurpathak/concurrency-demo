package com.github.ankurpathak;

import org.junit.jupiter.api.Test;

import static com.github.ankurpathak.LinkedListDemoX.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListDemoXTest {

    @Test
    public void testCreate(){
        Integer[] a = {1, 2, 3};
        Node<Integer> root = create(a);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(3);
    }

    @Test
    public void testAddFirstEmpty(){
        Node<Integer> root = addFirst(null, 2);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(1);
        assertThat(root.data).isEqualTo(2);
    }

    @Test
    public void testAddFirstNotEmpty(){
        Node<Integer> root = create(new Integer[]{1, 2, 3});
        assertThat(root).isNotNull();
        root = addFirst(root, 2);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(4);
        assertThat(root.data).isEqualTo(2);
    }

    @Test
    public void testAddLastEmpty(){
        Node<Integer> root = addLast(null, 2);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(1);
        assertThat(root.data).isEqualTo(2);
    }

    @Test
    public void testAddLastNotEmpty(){
        Node<Integer> root = create(new Integer[]{1, 2, 3});
        assertThat(root).isNotNull();
        root = addLast(root, 4);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(4);
        Node<Integer> it = search(root, 4);
        assertThat(it ).isNotNull();
        assertThat(it.data).isEqualTo(4);
    }

    @Test
    public void testAddNotEmpty(){
        Node<Integer> root = create(new Integer[]{1, 2, 3});
        assertThat(root).isNotNull();
        root = add(root, 10, 2);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(4);
        Node<Integer> it = search(root, 10);
        assertThat(it).isNotNull();
        assertThat(it.data).isEqualTo(10);
    }

    @Test
    public void testAddEmpty(){
        Node<Integer> root = add(null, 2, 0);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(1);
        assertThat(root.data).isEqualTo(2);
    }


    @Test
    public void testAddOutOfRange(){
        Node<Integer> root =
                create(new Integer[]{1, 2 , 3});
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(3);
        root = add(root, 50, 100);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(3);
        assertThat(search(root, 50)).isNull();
    }

    @Test
    public void testAddAtCount(){
        Node<Integer> root =
                create(new Integer[]{1, 2 , 3});
        assertThat(root).isNotNull();
        Integer count = count(root);
        assertThat(count).isEqualTo(3);
        root = add(root, 50, count);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(4);
        Node<Integer> it = search(root, 50);
        assertThat(it).isNotNull();
        assertThat(it.next).isNull();
    }


    @Test
    public void testRemoveFirstOnlyElement(){
        Integer[] a = new Integer[]{1};
        Node<Integer> root = create(a);
        assertThat(root).isNotNull();
        root = removeFirst(root);
        assertThat(root).isNull();
        assertThat(count(root)).isEqualTo(0);
    }


    @Test
    public void testRemoveFirstNotEmpty(){
        Integer[] a = new Integer[]{1, 2, 3};
        Node<Integer> root = create(a);
        assertThat(root).isNotNull();
        root = removeFirst(root);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(2);
        assertThat(root.data).isEqualTo(2);
        assertThat(search(root, 1)).isNull();
    }


    @Test
    public void testRemoveLastOnlyElement(){
        Node<Integer> root = create(new Integer[]{1});
        assertThat(root).isNotNull();
        root = removeLast(root);
        assertThat(root).isNull();
        assertThat(count(root)).isEqualTo(0);
        assertThat(search(root, 1)).isNull();
    }

    @Test
    public void testRemoveLastNotEmpty(){
        Node<Integer> root = create(new Integer[]{1, 2, 3});
        assertThat(root).isNotNull();
        root = removeLast(root);
        assertThat(root).isNotNull();
        assertThat(count(root)).isEqualTo(2);
        Node<Integer> it = search(root, 2);
        assertThat(it).isNotNull();
        assertThat(it.next).isNull();
        assertThat(it.data).isEqualTo(2);
    }
}
