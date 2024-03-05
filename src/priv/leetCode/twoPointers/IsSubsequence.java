package priv.leetCode.twoPointers;

/*
    Given two strings s1, s2
    return true is s1 is a subsequence of s2, otherwise false

    Input1: s1="abc", s2="ahbgdc"
    Output1: true

    Input2: s1="axc", s2="ahbgdc"
    Output2: false

    LeetCode#392: https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";
        String s3 = "axc";
        String s4 = "b";

        assert isSubsequence(s1, s2);
        assert !isSubsequence(s3, s2);
        assert isSubsequence(s4, s1);
    }

    private static boolean isSubsequence(String s1, String s2) {
        if (s1.isEmpty()) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        }
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            if (s2.charAt(j) == s1.charAt(i)) {
                i++;
            }
            if (i == s1.length()) {
                return true;
            }
            j++;
        }
        return false;
    }
}
