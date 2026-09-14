package test;

import main.leetcode.TopKFrequentElements;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TopKFrequentElementsTest {

    @Test
    public void testOne(){
        // Arrange
        int[] arr = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] expected = new int[]{1, 2};

        // Act
        int[] actual = TopKFrequentElements.topKFrequent(arr, k);

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testTwo(){
        // Arrange
        int[] arr = new int[]{1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        int[] expected = new int[]{1, 2};

        // Act
        int[] actual = TopKFrequentElements.topKFrequent(arr, k);

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThree(){
        // Arrange
        int[] arr = new int[]{1};
        int k = 1;
        int[] expected = new int[]{1};

        // Act
        int[] actual = TopKFrequentElements.topKFrequent(arr, k);

        // Assert
        assertArrayEquals(expected, actual);
    }
}
