package priv.leetCode.arrayAndString;

/*
    Given two strings str1 and str2, return the index of first occurrence of str1 in str2, or -1 if not found

    Input1: str1="sad", str2="sadbutsad"
    Output: 0

    Input: str1="leeto", str2="leetcode"
    Output: -1

    LeetCode#28: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        String haystack3 = "abc";
        String needle3 = "abcc";

        assert findFirstOccIndex(needle1, haystack1) == 0;
        assert findFirstOccIndex(needle2, haystack2) == -1;
        assert findFirstOccIndex(needle3, haystack3) == -1;

    }

    private static int findFirstOccIndex(String str1, String str2) {
        if (!str2.contains(str1)) {
            return -1;
        }
        if (str2.equals(str1)) {
            return 0;
        }
        if (str1.length() == 1) {
            return str2.indexOf(str1.charAt(0));
        }
        int idx = str2.indexOf(str1.charAt(0));
        if (idx + str1.length() >= str2.length()) {
            return -1;
        }
        while (idx < str2.length()) {
            if (str1.equals(str2.substring(idx, idx + str1.length()))) {
                return idx;
            } else {
                idx++;
            }
        }
        return idx;
    }
}
