package test;

import main.leetcode.TopKFrequentElements;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.logging.Logger;

public class TopKFrequentElementsTest {

    @Test
    public void testCaseOne(){
        // Arrange: Setup my input data
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expected = {1, 2};
        // Act: Execute the static method
        int[] actual = TopKFrequentElements.topKFrequent(nums, k);
        //Assert
        assertArrayEquals(expected, actual, "The top k frequent elements do not match the expected output");
    }

    @Test
    public void testCaseTwo(){
        // Arrange: Setup my input data
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        int[] expected = {1, 2};
        // Act: Execute the static method
        int[] actual = TopKFrequentElements.topKFrequent(nums, k);
        //Assert
        assertArrayEquals(expected, actual, "The top k frequent elements do not match the expected output");
    }

    @Test
    public void testCaseThree(){
        // Arrange: Setup my input data
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        // Act: Execute the static method
        int[] actual = TopKFrequentElements.topKFrequent(nums, k);
        //Assert
        assertArrayEquals(expected, actual, "The top k frequent elements do not match the expected output");
    }
}
