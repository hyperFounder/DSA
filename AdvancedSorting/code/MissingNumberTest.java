package test;

import main.leetcode.MissingNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MissingNumberTest {

    @Test
    public void testOne() {
        // Arrange: Setup the input data
        int[] nums = {3, 0, 1};
        int expected = 2;

        // Act
        int actual = MissingNumber.missingNumber(nums);
        assertEquals(expected, actual, "Actual output does not match the expected value.");
    }

    @Test
    public void testTwo() {
        // Arrange: Setup the input data
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int expected = 8;

        // Act
        int actual = MissingNumber.missingNumber(nums);
        assertEquals(expected, actual, "Actual output does not match the expected value.");
    }
}
