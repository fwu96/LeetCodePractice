package priv.leetCode.hashMap;

import java.util.HashMap;
import java.util.Map;

/*
    Given a pattern and a string s, find if s follow the same pattern

    Input1: pattern = "abba", s = "dog cat cat dog"
    Output1: true

    Input2: pattern = "abba", s = "dog cat cat fish"
    Output2: false

    Input3: pattern = "aaaa", s = "dog cat cat dog"
    Output3: false

    LeetCode#290: https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordPattern {
    public static void main(String[] args) {
        assert isFollowingPattern("abba", "dog cat cat dog");
        assert !isFollowingPattern("abba", "dog cat cat fish");
        assert !isFollowingPattern("aaaa", "dog cat cat dog");
        assert !isFollowingPattern("abba", "dog cat");
        assert !isFollowingPattern("abba", "dog dog dog dog");

        assert isFollowingPatternV2("abba", "dog cat cat dog");
        assert !isFollowingPatternV2("abba", "dog cat cat fish");
        assert !isFollowingPatternV2("aaaa", "dog cat cat dog");
        assert !isFollowingPatternV2("abba", "dog cat");
        assert !isFollowingPatternV2("abba", "dog dog dog dog");

    }

    private static boolean isFollowingPattern(String pattern, String s) {
        // number of spaces in s
        int spaceCount = s.length() - s.replace(" ", "").length();
        if (spaceCount != pattern.length() - 1) {
            return false;
        }
        Map<Character, String> patternMap = new HashMap<>();
        char[] patternChar = pattern.toCharArray();
        int wordIdx = 0;
        int wordStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                String word;
                if (i == s.length() - 1) {
                    word = s.substring(wordStart, i + 1);
                } else {
                    word = s.substring(wordStart, i);
                }
                if (patternMap.containsKey(patternChar[wordIdx])) {
                    if (!patternMap.get(patternChar[wordIdx]).equals(word)) {
                        return false;
                    }
                } else {
                    if (patternMap.containsValue(word)) {
                        return false;
                    }
                    patternMap.put(patternChar[wordIdx], word);
                }
                wordStart = i + 1;
                wordIdx += 1;
            }
        }
        return true;
    }

    private static boolean isFollowingPatternV2(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (patternMap.containsKey(c)) {
                if (!patternMap.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (patternMap.containsValue(words[i])) {
                    return false;
                }
                patternMap.put(c, words[i]);
            }
        }
        return true;
    }
}
