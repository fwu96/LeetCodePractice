package priv.leetCode.hashMap;

import java.util.HashSet;
import java.util.Set;

/*
    Given an integer array nums and an integer k, return true if two distinct indices i and j in nums
    such that nums[i] == nums[j] and abs(i - j) <= k

    Input1: nums = [1, 2, 3, 1], k = 3
    Output1: true

    Input2: nums = [1, 0, 1, 1], k = 1
    Output2: true

    Input3: nums = [1, 2, 3, 1, 2, 3], k = 2
    Output3: false

    LeetCode#219: https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainsDuplicationII {
    public static void main(String[] args) {
        assert containDuplicates(new int[]{ 1, 2, 3, 1 }, 3);
        assert containDuplicates(new int[]{ 1, 0, 1, 1 }, 1);
        assert !containDuplicates(new int[]{ 1, 2, 3, 1, 2, 3 }, 2);
    }

    private static boolean containDuplicates(int[] nums, int k) {
        // keep track of checked element within length of k from current idx
        if (nums.length == 1 || k == 0) {
            return false;
        }
        Set<Integer> scannedValSet = new HashSet<>();
        int leftIdx = 0;

        for (int num : nums) {
            if (scannedValSet.contains(num)) {
                return true;
            }
            scannedValSet.add(num);
            if (scannedValSet.size() > k) {
                scannedValSet.remove(nums[leftIdx]);
                leftIdx++;
            }
        }
        return false;
    }
}
