package priv.leetCode.arrayAndString;

/*
    Find the longest common prefix string amongst an array of strings
    If no common prefix, return an empty string

    Input1: strs = ["flower","flow","flight"]
    Output1: "fl"

    Input2: strs = ["dog","racecar","car"]
    Output2: ""

    LeetCode#14: https://leetcode.com/problems/longest-common-prefix/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] inp1 = {"flower", "flow", "flight"};
        String[] inp2 = {"dog", "rececar", "car"};

        assert getLongestCommonPrefix(inp1).equals("fl");
        assert getLongestCommonPrefix(inp2).isEmpty();
        assert getPrefixApproachTwo(inp1).equals("fl");
        assert getPrefixApproachTwo(inp2).isEmpty();
    }

    private static String getLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefixOfTwo(prefix, strs[i]);
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }

    private static String getPrefixOfTwo(String str1, String str2) {
        // max length of prefix is the length of shortest string
        int maxLength = Math.min(str1.length(), str2.length());
        int idx = 0;
        // while not complete scanning string and chars are same at the same position - move to compare next position char
        while (idx < maxLength && str1.charAt(idx) == str2.charAt(idx)) {
            idx++;
        }
        return str1.substring(0, idx);
    }

    private static String getPrefixApproachTwo(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int maxLength = strs[0].length();
        // scan through each char in first string
        for (int i = 0; i < maxLength; i++) {
            char curr = strs[0].charAt(i);  // store current char at index i
            for (int j = 1; j < strs.length; j++) {
                // if char at index i of string j is different from current char - not in the common prefix
                // source string is scanned completed, return
                if (strs[j].charAt(i) != curr || i == strs[j].length()) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
