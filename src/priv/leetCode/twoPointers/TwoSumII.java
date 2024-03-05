package priv.leetCode.twoPointers;

import java.util.Arrays;

/*
    Given a 1-indexed array of integers that is already sorted in non-decreasing order. Find two numbers such that
    the sum is a specific target number. Return indices of two numbers added by one as int array
    numbers.length >= 2

    Input1: numbers=[2, 7, 11, 15], target=9
    Output1: [1, 2]

    Input2: numbers=[2, 3, 4], target=6
    Output2: [1, 3]

    Input3: numbers=[-1, 0], target=-1
    Output3: [1, 2]

    LeetCode#167: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSumII {

    public static void main(String[] args) {
        Integer[] input1 = {2, 7, 11, 15};
        Integer[] input2 = {2, 3, 4};
        Integer[] input3 = {-1, 0};

        assert Arrays.toString(getIndices(input1, 9)).equals("[1, 2]");
        assert Arrays.toString(getIndices(input2, 6)).equals("[1, 3]");
        assert Arrays.toString(getIndices(input3, -1)).equals("[1, 2]");

        assert Arrays.toString(getIndicesV2(input1, 9)).equals("[1, 2]");
        assert Arrays.toString(getIndicesV2(input2, 6)).equals("[1, 3]");
        assert Arrays.toString(getIndicesV2(input3, -1)).equals("[1, 2]");
    }

    private static Integer[] getIndices(Integer[] numbers, int target) {
        Integer[] res = new Integer[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }
        return res;
    }

    private static Integer[] getIndicesV2(Integer[] numbers, int target) {
        Integer[] res = new Integer[2];
        int idx1 = 0;
        int idx2 = numbers.length - 1;

        while (idx1 < idx2) {
            int sum = numbers[idx1] + numbers[idx2];
            if (sum == target) {
                res[0] = idx1 + 1;
                res[1] = idx2 + 1;
                break;
            } else if (sum < target) {
                idx1++;
            } else {
                idx2--;
            }
        }
        return res;
    }
}
