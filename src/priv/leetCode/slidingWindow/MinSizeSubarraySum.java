package priv.leetCode.slidingWindow;

/*
    Given an array of positive integer, and a positive target. Return the minimal length of a subarray which sum
    is greater than or equal to target. 0 if not found

    Input1: target=7, nums=[2, 3, 1, 2, 4, 3]
    Output1: 2

    Input2: target=4, nums=[1, 4, 4]
    Output2: 1

    Input3: target=11, nums[1, 1, 1, 1, 1, 1, 1, 1]
    Output3: 0

    LeetCode#209: https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] input1 = {2, 3, 1, 2, 4, 3};
        int[] input2 = {1, 4, 4};
        int[] input3 = {1, 1, 1, 1, 1, 1, 1};

        assert getMinLength(7, input1) == 2;
        assert getMinLength(4, input2) == 1;
        assert getMinLength(11, input3) == 0;

    }

    private static int getMinLength(int target, int[] nums) {
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 1;
            } else {
                return 0;
            }
        }
        int length = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {
            // sliding windows
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                length = Math.min(length, right - left + 1);
                left++;
            }
            right++;
        }
        if (length == Integer.MAX_VALUE) {
            return 0;
        }
        return length;
    }
}
