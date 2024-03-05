package priv.leetCode.arrayAndString;

import java.util.HashMap;
import java.util.Map;

/*
    Roman numerals are represented by seven different symbols 'I', 'V', 'X', 'L', 'C', 'D', 'M'
    Referring to 1, 5,  10, 50, 100, 500, 1000
    'I' can be placed before 'V' and 'X' to make 4 or 9
    'X' can be placed before 'L' and "C' to make 40 and 90
    'C' can be placed before 'D' and 'M' to make 400 and 900

    Input1: s = "III"
    Output1: 3

    Input2: s = "LVIII"
    Output2: 58

    Input3: s = "MCMXCIV"
    Output: 1994

    LeetCode#13: https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String inp1 = "III";
        String inp2 = "LVIII";
        String inp3 = "MCMXCIV";

        assert convertRomanToInteger(inp1) == 3;
        assert convertRomanToInteger(inp2) == 58;
        assert convertRomanToInteger(inp3) == 1994;
    }

    public static int convertRomanToInteger(String roman) {
        // Mapping Roman letters to int val first
        Map<Character, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);

        // traverse from tail/head, calculating sum based on relation between adjacent letters
        int sum = romanIntMap.get(roman.charAt(roman.length() - 1));
        for (int i = roman.length() - 1; i >= 1; i--) {
            int currVal = romanIntMap.get(roman.charAt(i));
            int nextVal = romanIntMap.get(roman.charAt(i - 1));
            if (currVal <= nextVal) {
                sum += nextVal;
            } else {
                sum -= nextVal;
            }
        }
        return sum;
    }
}
