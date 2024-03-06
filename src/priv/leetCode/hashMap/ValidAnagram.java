package priv.leetCode.hashMap;

import java.util.Arrays;

/*
    Given two strings s and t, return true if t is an anagram of s, otherwise false

    Input1: s = "anagram", t = "nagaram"
    Output1: true

    Input2: s = "rat", t = "car"
    Output: false

    LeetCode#242: https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidAnagram {
    public static void main(String[] args) {
        assert isAnagram("anagram", "nagaram");
        assert !isAnagram("rat", "car");
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
}
