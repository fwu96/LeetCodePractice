package priv.leetCode.hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and a target, return indices of two numbers such that the sum of them is target.
    Same element not use twice

    Input1: nums = [2, 7, 11, 15], target = 9
    Output1: [0, 1]

    Input2: nums = [3, 2, 4], target = 6
    Output2: [1, 2]

    Input3: nums = [3, 3], target = 6
    Output3: [0, 1]

    LeetCode#1: https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSum {
    public static void main(String[] args) {
        assert Arrays.toString(getIndices(new int[]{2, 7, 11, 15}, 9)).equals("[0, 1]");
        assert Arrays.toString(getIndices(new int[]{3, 2, 4}, 6)).equals("[1, 2]");
        assert Arrays.toString(getIndices(new int[]{3, 3}, 6)).equals("[0, 1]");
    }

    private static int[] getIndices(int[] nums, int target) {
        int[] indices = new int[2];
        // Storing value as key and index as value
        Map<Integer, Integer> valIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // the different between current number at i and target
            int gap = target - nums[i];
            // since key is value in the array, so if difference appears as key
            // means that the gap value is in the array -> found solution
            // the sum of value at index i and value gap is target
            if (valIdxMap.containsKey(gap)) {
                indices[0] = valIdxMap.get(gap);
                indices[1] = i;
                break;
            }
            valIdxMap.put(nums[i], i);
        }
        return indices;
    }
}
