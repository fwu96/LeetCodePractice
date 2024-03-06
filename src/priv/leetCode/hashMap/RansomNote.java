package priv.leetCode.hashMap;

import java.util.HashMap;
import java.util.Map;

/*
    Given two strings s1 and s2, return true is s1 can be constructed by using the letters
    from s2, and false if not. Each letter in s2 can only be used once

    Input1: s1 = "a", s2 = "b"
    Output1: false

    Input2: s1 = "aa", s2 = "ab"
    Output2: false;

    Input3: s1 = "aa", s2 = "aab"
    Output3: true;

    LeetCode#383: https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RansomNote {
    public static void main(String[] args) {
        assert !isConstructable("a", "b");
        assert !isConstructable("aa", "ab");
        assert isConstructable("aa", "aab");
    }
    private static boolean isConstructable(String s1, String s2) {
        Map<Character, Integer> occurredCharMap = new HashMap<>();
        for (Character c : s2.toCharArray()) {
            occurredCharMap.put(c, occurredCharMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : s1.toCharArray()) {
            if (occurredCharMap.containsKey(c)) {
                if (occurredCharMap.get(c) != 0) {
                    occurredCharMap.put(c, occurredCharMap.get(c) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
