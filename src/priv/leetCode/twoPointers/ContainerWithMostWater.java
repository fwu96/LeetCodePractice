package priv.leetCode.twoPointers;

/*
    Given an int array height, of length n. There are n vertical line drawn such that two endpoints of ith line are
    (i, 0) and (i, height[i]). Find two lines that together with x-axis form a container, such that container contains
    most water. Return the max amount of water a container can store

    Input1: height=[1, 8, 6, 2, 5, 4, 8, 3, 7]
    Output1: 49

    Input2: [1, 1]
    Output: 1

    LeetCode#11: https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] input1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] input2 = {1, 1};

        assert getMostWater(input1) == 49;
        assert getMostWater(input2) == 1;
    }

    public static int getMostWater(int[] heights) {
        // Actually need to find the largest rectangle area made up by left and left vertical line
        int i = 0;
        int j = heights.length - 1;
        int mostWater = 0;
        while (i < j) {
            int minHeight = Math.min(heights[i], heights[j]);
            int waterAmount = minHeight * (j - i);
            mostWater = Math.max(mostWater, waterAmount);

            if (heights[i] < heights[j]) {  // left line is lower than right, which is the limitation of area
                i++;
            } else {  // vice vesa
                j--;
            }
        }
        return mostWater;
    }
}
