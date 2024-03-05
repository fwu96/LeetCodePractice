package priv.leetCode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array, return all triplets nums[i], nums[j], nums[k] such that i !=j, i != k, j != k
    and nums[i] + nums[j] + nums[k] == 0

    Input1: nums=[-1, 0, 1, 2, -1, -4] -> [-4, -1, -1, 0, 1, 2]
    Output1: [[-1, -1, 2], [-1, 0, 1]]

    Input2: nums=[0, 1, 1]
    Output2: []

    Input3: nums=[0, 0, 0]
    Output3: [[0, 0, 0]]

    LeetCode#15: https://leetcode.com/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] input1 = {-1, 0, 1, 2, -1, -4};
        int[] input2 = {0, 1, 1};
        int[] input3 = {0, 0, 0};

        assert getTriplets(input1).toString().equals("[[-1, -1, 2], [-1, 0, 1]]");
        assert getTriplets(input2).toString().equals("[]");
        assert getTriplets(input3).toString().equals("[[0, 0, 0]]");
    }

    public static List<List<Integer>> getTriplets(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums.length < 3) {  // not able to find any triplets
            return triplets;
        }
        Arrays.sort(nums);
        // traverse from head
        for (int firstIdx = 0; firstIdx < nums.length; firstIdx++) {
            if (nums[firstIdx] > 0) {  // since it is sorted, if current val is positive then no way to find two other to make sum 0
                break;
            }
            // we already tried to find possible solution for the value at this index, after first element
            if (firstIdx > 0 && nums[firstIdx] == nums[firstIdx - 1]) {
                continue;
            }
            int secondIdx = firstIdx + 1;
            int thirdIdx = nums.length - 1;
            // find two possible value from substring from next index until end
            while (secondIdx < thirdIdx) {
                int sum = nums[firstIdx] + nums[secondIdx] + nums[thirdIdx];
                if (sum > 0) {  // right side value too big
                    thirdIdx--;
                } else if (sum < 0) {  // middle value too small
                    secondIdx++;
                } else {
                    // store one solution
                    triplets.add(Arrays.asList(nums[firstIdx], nums[secondIdx], nums[thirdIdx]));
                    // with index firstIdx, this is the unique solution for these three values
                    // keep track of the second and third number stored, moving second and third pointer
                    // to next different value
                    int lastLow = nums[secondIdx];
                    int lastHigh = nums[thirdIdx];
                    while (secondIdx < thirdIdx && nums[secondIdx] == lastLow) {
                        secondIdx++;
                    }
                    while (secondIdx < thirdIdx && nums[thirdIdx] == lastHigh) {
                        thirdIdx--;
                    }
                }
            }
        }
        return triplets;
    }
}
