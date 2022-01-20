package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.github.ankurpathak.GraphDemo.dfsTraversal;
import static org.assertj.core.api.Assertions.assertThat;

public class GraphDemoTests {
    private List<List<Integer>> firstGraph;


    @BeforeEach
    public void setup(){
        firstGraph = List.of(
                //0
                Collections.emptyList(),
                //1
                List.of(2,5),
                //2
                List.of(1,3),
                //3
                List.of(2,5),
                //4
                List.of(6),
                //5
                List.of(1,3),
                //6
                List.of(4)
        );
    }


    @Test
    public void testDfs(){
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(dfsTraversal(firstGraph)).isNotNull().isNotEmpty().containsExactly(1, 2, 3, 5, 4, 6);
    }

}
