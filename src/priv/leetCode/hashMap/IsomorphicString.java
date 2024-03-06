package priv.leetCode.hashMap;

import java.util.HashMap;
import java.util.Map;

/*
    Given two strings s and t, determine if they are isomorphic
    ture if chars in s can be replaced to get t
    All occurrences of a char must be replaced with another char while preserving the order of chars
    No two chars may map to the same char, but a char may map to itself

    Input1: s = "egg", t = "add"
    Output1: true

    Input2: s = "foo", t = "bar"
    Output2: false

    Input3: s = "paper", t = "title"
    Output3: true

    LeetCode#205: https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsomorphicString {
    public static void main(String[] args) {
        assert isIsomorphic("egg", "add");
        assert !isIsomorphic("foo", "bar");
        assert isIsomorphic("paper", "title");
        assert !isIsomorphic("bacd", "baba");
    }

    private static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            if (charMap.containsKey(sChar[i])) {
                if (charMap.get(sChar[i]) != tChar[i]) {
                    return false;
                }
            } else {
                if (charMap.containsValue(tChar[i])) {
                    return false;
                }
                charMap.put(sChar[i], tChar[i]);
            }
        }
        return true;
    }
}
