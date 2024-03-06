package priv.leetCode.hashMap;

import java.util.*;

/*
    Given an array of strings strs, group the anagrams together
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    LeetCode#49: https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> groupedStrings = groupAnagrams(strs);

        List<List<String>> expected = new ArrayList<>();
        expected.add(List.of("eat, tea, ate"));
        expected.add(List.of("bat"));
        expected.add(List.of("tan, nat"));

        assert groupedStrings.toString().equals(expected.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Soring chars to make each word in alphabet order, make it as HashMap key
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (!anagramsMap.containsKey(sortedStr)) {
                anagramsMap.put(sortedStr, new ArrayList<>());
            }
            anagramsMap.get(sortedStr).add(s);
        }
        return new ArrayList<>(anagramsMap.values());
    }
}