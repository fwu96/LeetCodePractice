package priv.leetCode.hashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence

    Input1: nums = [100, 4, 200, 1, 3, 2]
    Output1: 4

    Input2: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
    Output2: 9

    LeetCode#128: https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        assert getLongestConsecutiveLengthBySorting(new int[] { 100, 4, 200, 1, 3, 2 }) == 4;
        assert getLongestConsecutiveLengthBySorting(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }) == 9;
        assert getLongestConsecutiveLengthBySet(new int[] { 100, 4, 200, 1, 3, 2 }) == 4;
        assert getLongestConsecutiveLengthBySet(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }) == 9;
    }

    private static int getLongestConsecutiveLengthBySorting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int longestLen = 0;
        int currentLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - 1 == nums[i - 1]) {
                    currentLen++;
                } else {
                    longestLen = Math.max(longestLen, currentLen);
                    currentLen = 1;
                }
            }
        }
        return Math.max(longestLen, currentLen);
    }

    private static int getLongestConsecutiveLengthBySet(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> checkedSet = new HashSet<>();
        for (int n : nums) {
            checkedSet.add(n);
        }
        int longestLen = 0;
        int currentLen = 1;
        for (int n : nums) {
            // means there is no value == n - 1 appears in the array
            if (!checkedSet.contains(n - 1)) {
                int newSubBeginVal = n;
                // need to reset the current tracked subsequence length
                currentLen = 1;
                // find valid consecutive sequence starting with value n
                while (checkedSet.contains(newSubBeginVal + 1)) {
                    currentLen++;
                    newSubBeginVal++;
                }
            }  // n - 1 is appeared -> no action because valid sequence begin with value n - 1 is already tracked
            // update the longest length, comparing to found length start from value n
            longestLen = Math.max(longestLen, currentLen);
        }
        return longestLen;
    }
}
