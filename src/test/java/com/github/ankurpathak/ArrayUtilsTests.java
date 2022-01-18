package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.ankurpathak.ArrayUtils.reverse;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayUtilsTests {
    private int[] evenLength;
    private int[] oddLength;

    @BeforeEach
    public void setUp(){
        evenLength = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        oddLength = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    }


    @Test
    public void testReverseArrayAtIndex(){
        assertThat(evenLength).isNotNull().isNotEmpty().hasSize(12);
        reverse(evenLength, 6);
        assertThat(evenLength).containsExactly(1, 2, 3, 4,5,6,12,11,10,9, 8, 7);

        assertThat(oddLength).isNotNull().isNotEmpty().hasSize(13);
        reverse(oddLength, 6);
        assertThat(evenLength).containsExactly(1, 2, 3, 4,5,6,12,11,10,9, 8, 7);
    }
}
