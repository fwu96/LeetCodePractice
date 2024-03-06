package priv.leetCode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
    Given a string s, find the length of longest substring without repeating characters

    Input1: s = "abcabcbb"
    Output1: 3

    Input2: s = "bbbbb"
    Output2: 1

    Input3: s = "pwwkew"
    Output3: 3

    LeetCode#3: https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestSubstringWithoutRep {
    public static void main(String[] args) {

        assert findLongestLength("abcabcbb") == 3;
        assert findLongestLength("bbbbb") == 1;
        assert findLongestLength("pwwkew") == 3;
    }

    private static int findLongestLength(String s) {
        Map<Character, Integer> occurredCharMap = new HashMap<>();
        int leftIdx = 0, rightIdx = 0;
        int longestLen = 0;
        while (rightIdx < s.length()) {
            // use key to keep track of visited char
            occurredCharMap.put(s.charAt(rightIdx), occurredCharMap.getOrDefault(s.charAt(rightIdx), 0) + 1);
            // map size (number of entries) equals to window size (the current subString length)
            // this means subString in current window contains unique chars
            // so the length is possible answer -> update ans and slide rightIdx to next index
            if (occurredCharMap.size() == rightIdx - leftIdx + 1) {
                longestLen = Math.max(longestLen, rightIdx - leftIdx + 1);
                rightIdx++;
            // current subString length is greater and map size
            // which means there are duplicated chars in the window
            // and for those char as key the value is larger than 1
            // we are not able to find ans by only sliding rightIdx to the next, need to slide leftIdx also
            } else if (occurredCharMap.size() < rightIdx - leftIdx + 1) {
                // before sliding, remove the track of element at leftIdx from the map
                occurredCharMap.put(s.charAt(leftIdx), occurredCharMap.get(s.charAt(leftIdx)) - 1);
                // if the entry value becomes 0 after removing, it means there is no this char appears in current window
                // remove the key from map to make sure next time we see this char it count as unique char in answer subString
                if (occurredCharMap.get(s.charAt(leftIdx)) == 0) {
                    occurredCharMap.remove(s.charAt(leftIdx));
                }
                leftIdx++;
                rightIdx++;
            }
        }
        return longestLen;
    }
}
