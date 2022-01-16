package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.ankurpathak.LinkedListDemoX.*;
import static com.github.ankurpathak.LinkedListUtil.count;
import static com.github.ankurpathak.LinkedListUtil.search;
import static org.assertj.core.api.Assertions.assertThat;


public class LinkedListDemoXTest {

    private Integer[] notEmpty = {1, 2, 3};
    private Integer[] onlyElement = {1};
    private Integer[] empty = {};
    private Integer[] longListOdd = {1, 2, 3, 4, 5};
    private Integer[] longListEven = {1, 2, 3, 4, 5, 6};
    private Node<Integer> notEmptyRoot;
    private Node<Integer> onlyElementRoot;
    private Node<Integer> emptyRoot;
    private Node<Integer> longListOddRoot;
    private Node<Integer> longListEvenRoot;


    @BeforeEach
    public void setUp() {
        notEmptyRoot = create(notEmpty);
        onlyElementRoot = create(onlyElement);
        emptyRoot = create(empty);
        longListOddRoot = create(longListOdd);
        longListEvenRoot = create(longListEven);
    }


    @Test
    public void testCreate() {
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
        assertThat(onlyElementRoot).isNotNull();
        assertThat(count(onlyElementRoot)).isEqualTo(1);
        assertThat(emptyRoot).isNull();
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(5);
        assertThat(longListEvenRoot).isNotNull();
        assertThat(count(longListEvenRoot)).isEqualTo(6);
    }


    @Test
    public void testAddFirstEmpty() {
        emptyRoot = addFirst(emptyRoot, 2);
        assertThat(emptyRoot).isNotNull();
        assertThat(count(emptyRoot)).isEqualTo(1);
        assertThat(emptyRoot.data).isEqualTo(2);
    }

    @Test
    public void testAddFirstNotEmpty() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = addFirst(notEmptyRoot, 2);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        assertThat(notEmptyRoot.data).isEqualTo(2);
    }

    @Test
    public void testAddLastEmpty() {
        emptyRoot = addLast(this.emptyRoot, 2);
        assertThat(emptyRoot).isNotNull();
        assertThat(count(emptyRoot)).isEqualTo(1);
        assertThat(emptyRoot.data).isEqualTo(2);
    }

    @Test
    public void testAddLastNotEmpty() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = addLast(notEmptyRoot, 4);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        Node<Integer> it = search(notEmptyRoot, 4);
        assertThat(it).isNotNull();
        assertThat(it.data).isEqualTo(4);
    }

    @Test
    public void testAddNotEmpty() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = add(notEmptyRoot, 10, 2);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        Node<Integer> it = search(notEmptyRoot, 10);
        assertThat(it).isNotNull();
        assertThat(it.data).isEqualTo(10);
    }

    @Test
    public void testAddEmpty() {
        emptyRoot = add(emptyRoot, 2, 0);
        assertThat(emptyRoot).isNotNull();
        assertThat(count(emptyRoot)).isEqualTo(1);
        assertThat(emptyRoot.data).isEqualTo(2);
    }


    @Test
    public void testAddOutOfRange() {
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
        notEmptyRoot = add(notEmptyRoot, 50, 100);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
        assertThat(search(notEmptyRoot, 50)).isNull();
    }

    @Test
    public void testAddAtCount() {
        assertThat(notEmptyRoot).isNotNull();
        Integer count = count(notEmptyRoot);
        assertThat(count).isEqualTo(3);
        notEmptyRoot = add(notEmptyRoot, 50, count);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(4);
        Node<Integer> it = search(notEmptyRoot, 50);
        assertThat(it).isNotNull();
        assertThat(it.next).isNull();
    }


    @Test
    public void testRemoveFirstOnlyElement() {
        assertThat(onlyElementRoot).isNotNull();
        onlyElementRoot = removeFirst(onlyElementRoot);
        assertThat(onlyElementRoot).isNull();
        assertThat(count(onlyElementRoot)).isEqualTo(0);
    }


    @Test
    public void testRemoveFirstNotEmpty() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = removeFirst(notEmptyRoot);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(2);
        assertThat(notEmptyRoot.data).isEqualTo(2);
        assertThat(search(notEmptyRoot, 1)).isNull();
    }


    @Test
    public void testRemoveLastOnlyElement() {
        assertThat(onlyElementRoot).isNotNull();
        onlyElementRoot = removeLast(onlyElementRoot);
        assertThat(onlyElementRoot).isNull();
        assertThat(count(onlyElementRoot)).isEqualTo(0);
        assertThat(search(onlyElementRoot, 1)).isNull();
    }

    @Test
    public void testRemoveLastNotEmpty() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = removeLast(notEmptyRoot);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(2);
        Node<Integer> it = search(notEmptyRoot, 2);
        assertThat(it).isNotNull();
        assertThat(it.next).isNull();
        assertThat(it.data).isEqualTo(2);
    }


    @Test
    public void testRemoveOnlyElement() {
        assertThat(onlyElementRoot).isNotNull();
        onlyElementRoot = remove(onlyElementRoot, 0);
        assertThat(onlyElementRoot).isNull();
        assertThat(count(onlyElementRoot)).isEqualTo(0);
        assertThat(search(onlyElementRoot, 1)).isNull();
    }


    @Test
    public void testRemoveNotEmpty() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = remove(notEmptyRoot, 1);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(2);
        Node<Integer> it = search(notEmptyRoot, 2);
        assertThat(it).isNull();
    }

    @Test
    public void testRemoveOutOfRange() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = remove(notEmptyRoot, 50);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
    }

    @Test
    public void testRemoveNodeAfterLast() {
        assertThat(notEmptyRoot).isNotNull();
        notEmptyRoot = remove(notEmptyRoot, 3);
        assertThat(notEmptyRoot).isNotNull();
        assertThat(count(notEmptyRoot)).isEqualTo(3);
    }

    @Test
    public void testReverse() {
        longListOddRoot = reverse(longListOddRoot);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(5);
        assertThat(longListOddRoot.data).isEqualTo(5);
        Node<Integer> it = search(longListOddRoot, 1);
        assertThat(it).isNotNull();
        assertThat(it.data).isEqualTo(1);
        assertThat(it.next).isNull();
    }

    @Test
    public void testReverseOnlyElement() {
        onlyElementRoot = reverse(onlyElementRoot);
        assertThat(onlyElementRoot).isNotNull();
        assertThat(count(onlyElementRoot)).isEqualTo(1);
        assertThat(onlyElementRoot.data).isEqualTo(1);
        assertThat(onlyElementRoot.next).isNull();
    }


    @Test
    public void testReverseRecursiveOnlyElement() {
        onlyElementRoot = reverseRecursive(null, onlyElementRoot);
        assertThat(onlyElementRoot).isNotNull();
        assertThat(count(onlyElementRoot)).isEqualTo(1);
        assertThat(onlyElementRoot.data).isEqualTo(1);
        assertThat(onlyElementRoot.next).isNull();
    }


    @Test
    public void testReverseRecursive() {
        longListOddRoot = reverseRecursive(null, longListOddRoot);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(5);
        assertThat(longListOddRoot.data).isEqualTo(5);
        Node<Integer> it = search(longListOddRoot, 1);
        assertThat(it).isNotNull();
        assertThat(it.data).isEqualTo(1);
        assertThat(it.next).isNull();
    }


    @Test
    public void testRemoveNth() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLast2N(longListOddRoot, 2);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(4);
        assertThat(search(longListOddRoot, 4)).isNull();
    }

    @Test
    public void testRemoveNthFirstElement() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLast2N(longListOddRoot, count(longListOddRoot));
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(4);
        assertThat(search(longListOddRoot, 1)).isNull();
    }

    @Test
    public void testRemoveNthLastElement() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLast2N(longListOddRoot, 0);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(5);
    }

    @Test
    public void testRemoveNthOutOfRange() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLast2N(longListOddRoot, -4);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(5);
    }


    @Test
    public void testRemoveNthN() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLastN(longListOddRoot, 2);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(4);
        assertThat(search(longListOddRoot, 4)).isNull();
    }

    @Test
    public void testRemoveNthNFirstElement() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLastN(longListOddRoot, count(longListOddRoot));
        assertThat(longListOddRoot).isNotNull()
                .satisfies(it -> {
                    assertThat(count(it)).isEqualTo(4);
                    assertThat(search(longListOddRoot, 1)).isNull();
                });


    }

    @Test
    public void testRemoveNthNLastElement() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLastN(longListOddRoot, 0);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(5);
    }

    @Test
    public void testRemoveNthNOutOfRange() {
        assertThat(longListOddRoot).isNotNull();
        longListOddRoot = removeNthNodeFromLastN(longListOddRoot, -4);
        assertThat(longListOddRoot).isNotNull();
        assertThat(count(longListOddRoot)).isEqualTo(5);
    }

    @Test
    public void testfindMiddleNodeN() {
        Node<Integer> middle = findMiddleNodeN(longListEvenRoot);
        assertThat(middle).isNotNull()
                .extracting(Node::getData)
                .isEqualTo(4);

        middle = findMiddleNodeN(longListOddRoot);
        assertThat(middle).isNotNull()
                .extracting(Node::getData)
                .isEqualTo(3);

        middle = findMiddleNodeN(onlyElementRoot);
        assertThat(middle).isNotNull()
                .isEqualTo(middle);


        middle = findMiddleNodeN(emptyRoot);
        assertThat(middle).isNull();
    }

    @Test
    public void testfindMiddleNode2N() {
        Node<Integer> middle = findMiddleNodeN(longListEvenRoot);
        assertThat(middle).isNotNull()
                .extracting(Node::getData)
                .isEqualTo(4);

        middle = findMiddleNodeN(longListOddRoot);
        assertThat(middle).isNotNull()
                .extracting(Node::getData)
                .isEqualTo(3);

        middle = findMiddleNodeN(onlyElementRoot);
        assertThat(middle).isNotNull()
                .isEqualTo(middle);


        middle = findMiddleNodeN(emptyRoot);
        assertThat(middle).isNull();
    }

}
